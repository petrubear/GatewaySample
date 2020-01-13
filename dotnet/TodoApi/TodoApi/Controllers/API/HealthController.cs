using System;
using Microsoft.AspNetCore.Mvc;

namespace TodoApi.Controllers.API
{
    [ApiController]
    [Route("actuator")]
    public class HealthController : ControllerBase
    {
        [HttpGet("health")]
        //public IActionResult Status() => Ok();
        public String Status() => "{\"status\": \"UP\"}";
    }
}