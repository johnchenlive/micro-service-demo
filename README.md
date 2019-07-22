# micro-service-demo

This Spring Boot microservice will convert an integer to its Roman numeral representation. 
It's built by Gradle. It packages to a single jar file micro-service-demo-0.0.1.jar. It's easy to be deployed to a container like Docker. The DevOps capabilities for metrics, monitoring, and logging are provided as well.

## Development and Local test


### Development Environment

1. Install Oracle JVM 1.8 (tested with version 1.8.0_144), then set JAVA_HOME to this version.

2. In the project root directory, use gradle wrapper (gradlew) to run the builds -

```bash
gradlew build
```
### Run application from command line with gradle

```bash
gradlew bootrun
```

Or use your favorite IDE to run Application.java class.

## API Endpoints

All API endpoints are exposed on port 8080.

### API Endpoints

Copy this line in the web browser -

http://localhost:8080/romannumeral?query={integer}

{integer} should be any number between 1-3999

The login page will be displayed if this is the first request.

### Login credentials

user: user

password: [copy from the start up console]

find the line similar to this -

Using generated security password: ca792fdc-1689-4b7f-8d78-5f578af223b9

## Management Endpoints

All management endpoints are exposed on port 9000.
The login page will be displayed if this is the first request.
The login credentials are the same as above.

### Monitoring
Two endpoints are avaialble for the monitoring purposes.

1 An overall status that indicates if a service is up and running

http://localhost:9000/manage/status	

Response
```
{
    "status": "UP"
}
```	

2 Detailed status of a service 

http://localhost:9000/manage/health

Response
```
{
    "status": "UP",
    "details": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 1000240963584,
                "free": 608698851328,
                "threshold": 10485760
            }
        }
    }
}
```

### Metrics

1 List of names of available metrics

http://localhost:9000/manage/metrics

Response
```
{"names":["jvm.memory.max","http.server.requests","jdbc.connections.active","process.files.max","jvm.gc.memory.promoted","tomcat.cache.hit","system.load.average.1m","tomcat.cache.access","jvm.memory.used","jvm.gc.max.data.size","jdbc.connections.max","jdbc.connections.min","jvm.memory.committed","system.cpu.count","logback.events","tomcat.global.sent","jvm.buffer.memory.used","tomcat.sessions.created","jvm.threads.daemon","system.cpu.usage","jvm.gc.memory.allocated","tomcat.global.request.max","hikaricp.connections.idle","hikaricp.connections.pending","tomcat.global.request","tomcat.sessions.expired","hikaricp.connections","jvm.threads.live","jvm.threads.peak","tomcat.global.received","hikaricp.connections.active","hikaricp.connections.creation","process.uptime","tomcat.sessions.rejected","process.cpu.usage","tomcat.threads.config.max","jvm.classes.loaded","hikaricp.connections.max","hikaricp.connections.min","jvm.gc.pause","jvm.classes.unloaded","tomcat.global.error","tomcat.sessions.active.current","tomcat.sessions.alive.max","jvm.gc.live.data.size","tomcat.servlet.request.max","hikaricp.connections.usage","tomcat.threads.current","tomcat.servlet.request","hikaricp.connections.timeout","process.files.open","jvm.buffer.count","jvm.buffer.total.capacity","tomcat.sessions.active.max","hikaricp.connections.acquire","tomcat.threads.busy","process.start.time","tomcat.servlet.error"]}
```	

2 The details of a metrics

http://localhost:9000/manage/metrics/process.uptime

Response
```
{"name":"process.uptime","description":"The uptime of the Java virtual machine","baseUnit":"seconds","measurements":[{"statistic":"VALUE","value":1076.961}],"availableTags":[]}
```

### Logging

1 List of names of available loggers

http://localhost:9000/manage/loggers

2 The details of a logger

http://localhost:9000/manage/loggers/org.springframework.data.web

Response
```
{"configuredLevel":null,"effectiveLevel":"INFO"}
```

## Test
The unit tests are in RomanNumeralUnitTest.java. The test results can be found in 
../PROJECT_ROOT/build/reports/tests/test/index.html

The test cases are designed to cover all scenarios in RomanNumeralServiceImpl.java. Each test case covers more than one scenarios in RomanNumeralServiceImpl.java. The intention is to keep the test cases small.

