## UI Automation for SauceDemo

This project has the UI Automation test for SauceDemo. 

### Frameworks used

Java/TestNG 
WebDriver

###How to run tests?
```
git clone https://github.com/thenmozhikaliyamurthy/SauceDemoUITest.git
cd SauceDemoUITest
mvn clean install 
```

###Important things to remember:

Required config or constants are in config.properties.
Test suite is configured to run during buid phase
Test Suite run in chrome. Can be extended for different browser. 
Implementaion is already done for other browser. we just need to download driver and use it for execution.

Test Reports are generated under target/surefre-reports. Reports will have details of all the test scenario.
