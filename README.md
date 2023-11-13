# taf-bremboparts-com
"This repository contains automated UI and API tests for the web resource www.bremboparts.com. This web resource is intended for searching and selecting brake components of the BREMBO brand. In this framework, the selection of brake system components for cars and motorcycles was carried out using UI tests, a check was made UI search in the section: "support" and checked the login form using UI tests for various scenarios. Checked the search page API to return the request body with the data we need and checked the status of the code when opening the home page. The project includes the following patterns: Page object, Page Factory, Singleton.

## Content
- [Technologies](#technologies)
- [Getting started](#getting_started)
- [Testing](#testing)
- [Reporting](#reporting)
- [Result](#result)

  ## Technologies
- [Java](https://www.java.com/)
- [Maven](https://maven.apache.org/)
- [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Log4j2](https://logging.apache.org/log4j/2.x/)
- [Allure](https://allurereport.org/)
- [Selenium](https://www.selenium.dev/)

  ## Getting started
To start testing, you need to install the following dependencies:
```
 <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.15.0</version>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.20.0</version>
        </dependency>
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-junit5</artifactId>
            <version>2.24.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.20.0</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.16.1</version>
        </dependency>
```
And Bild configuration in project:
```
<build>
        <plugins>
            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.10.0</version>
                <configuration>
                    <reportVersion>2.23.0</reportVersion>
                    <resultsDirectory>${project.build.directory}/allure-results</resultsDirectory>
                    <allureDownloadUrl>
                        https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/${allure.version}/allure-commandline-${allure.version}.zip
                    </allureDownloadUrl>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>${aspectj.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.0</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
## Testing

After setting pom.xml, page objects are created and the driver is connected using the singleton pattern. Locators for all pages are filled in, methods for working with pages and auxiliary methods are written in a separate class, a layer of steps for executing tests is created, and the tests themselves are described. All tests are logged using Log4j2 technology. Afterwards the tests can be run. More details can be seen in the project code.

## Reporting

After the tests are completed, an Allure Report is created through which we can view information about our tests; it opens in a browser window.

## Result

The result of our tests will be the Allure Report in the browser window where we will see that our tests are running and checks are passing


