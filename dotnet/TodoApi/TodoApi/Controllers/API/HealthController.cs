using System;
using Microsoft.AspNetCore.Mvc;

namespace TodoApi.Controllers.API
{
    [ApiController]
    [Route("actuator")]
    public class HealthController : ControllerBase
    {
        [HttpGet("health")]
        public string Status() => "{\"status\": \"UP\"}";
    }
}