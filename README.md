# 🛒 Flipkart BDD Automation Framework

### Selenium + Cucumber + TestNG + Java + POM

A complete **Behavior Driven Development (BDD)** automation framework built for **Flipkart.com** using **Selenium WebDriver**, **Cucumber**, **TestNG**, and **Java**.

This framework follows industry best practices and is suitable for learning as well as real-time project implementation.

---

## 🚀 Features

- ✅ **Page Object Model (POM)** design pattern
- ✅ **Cucumber BDD** with Gherkin language
- ✅ **Data Driven Testing** using Scenario Outline
- ✅ **Cross Browser Testing** (Chrome & Firefox)
- ✅ **Parallel Execution** using TestNG
- ✅ **Logging** using Log4j2
- ✅ **Extent Reports** with screenshots on failure
- ✅ **Configuration driven** using properties file
- ✅ **Selenium Grid** support
- ✅ **Docker + Selenium Grid** integration
- ✅ **Jenkins CI/CD** ready (Jenkinsfile included)
- ✅ **Re-run failed tests** support
- ✅ Clean & beginner-friendly code structure

---

## 🛠️ Tech Stack

| Technology          | Purpose                        |
|---------------------|--------------------------------|
| Java 17             | Programming Language           |
| Selenium 4          | Browser Automation             |
| Cucumber            | BDD Framework                  |
| TestNG              | Test Execution & Parallelism   |
| Maven               | Build & Dependency Management  |
| WebDriverManager    | Automatic Driver Management    |
| Extent Reports      | Advanced Reporting             |
| Log4j2              | Logging                        |
| Docker              | Containerized Grid Execution   |
| Jenkins             | CI/CD Pipeline                 |

---

## 📁 Project Structure

```

CucumberSeleniumBDDFramework_Flipkart
│
├── src/test/java
│   └── com.automation
│       ├── hooks          → Before & After hooks
│       ├── pages          → Page Object classes
│       ├── runner         → TestNG Cucumber Runner
│       ├── stepdefs       → Step Definition classes
│       └── utils          → DriverManager, PropertiesReader, LoggerUtil
│
├── src/test/resources
│   ├── features           → Cucumber feature files
│   ├── config.properties  → Configuration file
│   ├── log4j2.xml
│   └── extent.properties
│
├── testng.xml             → TestNG suite for parallel execution
├── docker-compose.yml     → Selenium Grid with Docker
├── Jenkinsfile            → CI/CD Pipeline
└── pom.xml

```

---

```

## ⚙️ Prerequisites

- Java 17 or higher
- Maven 3.8+
- Git
- Chrome / Firefox browser
- Docker Desktop (optional - for Grid)
- Jenkins (optional - for CI/CD)

```

---

```
Run project by ways in terminal = 
1.mvn clean test -Dbrowser=chrome
2.mvn clean test -Dbrowser=firefox
3.mvn clean test
```
---

📊 Reports
After execution, reports are generated in the target folder:

```
Extent Report = target/ExtentReport/ExtentReport.html
Cucumber HTML = target/cucumber-reports.html
Logs = target/logs/automation.log

Open the Extent Report in any browser to view detailed results with screenshots.

```

---

🔧 Configuration

```
All configurations are managed in:
src/test/resources/config.properties

browser=chrome
url=https://www.flipkart.com/
grid=false
hub.url=http://localhost:4444
timeout=10

```

---

🏷️ Tags Support

```
You can run specific scenarios using tags:

mvn clean test -Dcucumber.filter.tags="@smoke"
mvn clean test -Dcucumber.filter.tags="@regression"

```

---

⭐ Support

```

If you like this project, please give it a ⭐ on GitHub!

```

---
