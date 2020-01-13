using System;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using Consul;
using Microsoft.AspNetCore.Hosting.Server;
using Microsoft.AspNetCore.Hosting.Server.Features;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;

namespace TodoApi.Infraestructure
{
    public class ConsulHostedService : IHostedService
    {
        private Task _executingTask;
        private CancellationTokenSource _cts;
        private readonly IConsulClient _consulClient;
        private readonly IOptions<ConsulConfig> _consulConfig;
        private readonly ILogger<ConsulHostedService> _logger;
        private readonly IServer _server;
        private string _registrationID;

        public ConsulHostedService(IConsulClient consulClient, IOptions<ConsulConfig> consulConfig,
            ILogger<ConsulHostedService> logger, IServer server)
        {
            _server = server;
            _logger = logger;
            _consulConfig = consulConfig;
            _consulClient = consulClient;
        }

        public async Task StartAsync(CancellationToken cancellationToken)
        {
            // Create a linked token so we can trigger cancellation outside of this token's cancellation
            _cts = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);

            var features = _server.Features;
            var addresses = features.Get<IServerAddressesFeature>();
            var address = "http://192.168.99.84:5001"; //addresses.Addresses.First();

            var uri = new Uri(address);
            _registrationID = $"{_consulConfig.Value.ServiceID}-{uri.Port}";

            var registration = new AgentServiceRegistration()
            {
                ID = _registrationID,
                Name = _consulConfig.Value.ServiceName,
                //Address = $"{uri.Scheme}://{uri.Host}",
                Address = $"{uri.Host}",
                Port = uri.Port,
                Tags = new[] {"dotnet"},
                Check = new AgentServiceCheck()
                                {
                                    HTTP = "http://192.168.99.84:5001/actuator/health",//$"{uri.Scheme}://{uri.Host}:{uri.Port}/actuator/health",
                                    Timeout = TimeSpan.FromSeconds(3),
                                    Interval = TimeSpan.FromSeconds(10)
                                }
            };

            _logger.LogInformation("Registering in Consul");
            await _consulClient.Agent.ServiceDeregister(registration.ID, _cts.Token);
            await _consulClient.Agent.ServiceRegister(registration, _cts.Token);
        }

        public async Task StopAsync(CancellationToken cancellationToken)
        {
            _cts.Cancel();
            _logger.LogInformation("Deregistering from Consul");
            try
            {
                await _consulClient.Agent.ServiceDeregister(_registrationID, cancellationToken);
            }
            catch (Exception ex)
            {
                _logger.LogError(ex, $"Deregisteration failed");
            }
        }
    }
}