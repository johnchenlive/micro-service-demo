# micro-service-demo


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

## API End Points

### Login page
user: user
password: [copy from the start up console]
find the line similar to this -
Using generated security password: ca792fdc-1689-4b7f-8d78-5f578af223b9

### API End Points
Copy this line in the web browser -
http://HOST_NAME:8080/romannumeral?query={integer}

## Test
The unit tests are in RomanNumeralUnitTest.java. The test results can be found in 
../PROJECT_ROOT/build/reports/tests/test/index.html

The test cases are designed to cover all scenarios in RomanNumeralServiceImpl.java. Each test case covers more than one scenarios in RomanNumeralServiceImpl.java. The intention is to keep the test cases small.

