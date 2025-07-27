# 🧪 SauceDemoSelenium

Automated UI Testing with Selenium WebDriver, TestNG, and the Page Object Model

## 📋 Overview

This project demonstrates automated testing of the [SauceDemo](https://www.saucedemo.com/) web app using Selenium WebDriver in Java. It follows the Page Object Model (POM) for modular architecture and integrates with TestNG for flexible test execution. Ideal for showcasing QA skills and automation principles.

## ⚙️ Technologies Used

- Java 11+  
- Selenium WebDriver  
- TestNG  
- Maven  
- IntelliJ IDEA  
- Git & GitHub  

## 📁 Project Structure
SauceDemoSelenium/ ├── src/ │   ├── main/ │   │   └── java/ │   │       └── Pages/          # Page objects (Login, Inventory, Cart, etc.) │   ├── test/ │   │   └── java/ │   │       └── Tests/          # Test classes organized by features ├── pom.xml                     # Maven dependencies and config └── README.md                   # Project documentation


## 🚀 Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/svarog84/SauceDemoSelenium.git

2. Install Dependencies
   
mvn clean install

4. Run Test Suite

mvn test

🧪 Key Test Scenarios- Valid and invalid login attempts
- Inventory visibility and product interactions
- Cart functionality and item removal
- Checkout process and order completion
- UI element presence and behavior validation
- Negative testing for edge cases
📌 Highlights- ✅ Page Object Model for organized structure
- 🔁 Reusable methods for scalability
- 🧼 Setup/Teardown for clean test flow
- 📊 Ready for CI/CD integration (e.g. GitHub Actions)
- ✨ Easy to expand for data-driven testing via @DataProvider
🧩 Contributing
Feel free to fork this repository or submit pull requests. Suggestions and improvements are always welcome!
📄 License
This project is licensed under the MIT License. Free to use and modify for learning and development.

Let the bugs beware—automation is coming for them! 🔍💥
