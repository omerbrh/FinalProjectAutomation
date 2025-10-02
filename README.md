# 🛒 Final Project Automation – Selenium & Java

<p align="center">
  <img alt="Automation Banner" src="https://img.shields.io/badge/Automation-QA%2FAutomation-orange?style=for-the-badge" />
</p>

<p align="center">
  <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html"><img alt="Java" src="https://img.shields.io/badge/Java-11-informational?style=for-the-badge&logo=java" /></a>
  <a href="https://www.selenium.dev/"><img alt="Selenium" src="https://img.shields.io/badge/Selenium-4.12-blue?style=for-the-badge&logo=selenium" /></a>
  <a href="https://testng.org/"><img alt="TestNG" src="https://img.shields.io/badge/TestNG-7.8-brightgreen?style=for-the-badge" /></a>
  <a href="https://docs.qameta.io/allure/"><img alt="Allure" src="https://img.shields.io/badge/Allure-2.27-purple?style=for-the-badge" /></a>
</p>

---
## 🎯 Project Overview

**Final Project** from a Selenium Automation course — a robust, modular end-to-end automation suite for the demo e-commerce application:

https://demo.cart2quote.com/what-is-new.html

**Key capabilities**
- 🧑‍💼 Men’s sportswear flows  
- 👩‍💼 Women’s sportswear flows  
- 🎒 Bags & gear flows  
- ⌚ Watches flows  
- 🏋️ Sports equipment flows  
- ✅ Select product variants (size, color)  
- ✅ Add to cart & validate cart contents  
- ✅ Sign-in / authentication checks  
- ✅ Full checkout flow (end-to-end)

> Tests follow Page Object Model (POM) and are designed to be modular, maintainable and data-driven ready.
## 🏗 Project Structure (POM)

magento.com.pageobject
│── BasePage.java
│── BagsPage.java
│── EquipmentPage.java
│── MenTanksPage.java
│── MenuToolBar.java
│── SignInPage.java
│── WomenHoodiesPage.java
│── GearPage.java
│── PaymentsPage.java
│── MenShortsPage.java

magento.com.tests
│── BaseTest.java
│── AddToCartTest.java
│── BuyingMensClothesTest.java
│── BuyingWomenClothesTest.java
│── SignInTest.java

## 🚀 How to Run

### Prerequisites
- Java 11 (JDK)  
- Maven  
- Browser driver (ChromeDriver/GeckoDriver) OR WebDriverManager configured in project  
- (Optional) Allure CLI for local report serving

### Run tests
From the project root run:
```bash
mvn clean test
 ```

---

### Part 5 — Test Reporting (Allure) Visual Placeholders  

```markdown
## 📊 Test Reporting (Allure) — Visuals

<div align="center">
  <img src="assets/allure-diagram-1.png" alt="Allure Diagram 1" width="420" style="border:3px solid #4CAF50; border-radius:10px; padding:6px; margin:6px;" />
  <img src="assets/allure-diagram-2.png" alt="Allure Diagram 2" width="420" style="border:3px solid #4CAF50; border-radius:10px; padding:6px; margin:6px;" />
</div>

**Demo Recording / GIF**

<div align="center">
  <img src="assets/demo-run.gif" alt="Demo Run GIF" width="760" style="border:3px solid #FF9800; border-radius:12px; padding:6px; margin:6px;" />
</div>


## 🖼 Website Screenshots (Coverage)

<div align="center">

| Men’s Sportswear | Women’s Sportswear | Bags & Gear | Sports Equipment | Watches |
|---:|:---:|:---:|:---:|:---:|
| <img src="assets/men_sportswear.png" alt="Men" width="220" style="border:2px solid #2196F3; border-radius:10px; padding:4px;" /> | <img src="assets/women_sportswear.png" alt="Women" width="220" style="border:2px solid #2196F3; border-radius:10px; padding:4px;" /> | <img src="assets/bags.png" alt="Bags" width="220" style="border:2px solid #2196F3; border-radius:10px; padding:4px;" /> | <img src="assets/equipment.png" alt="Equipment" width="220" style="border:2px solid #2196F3; border-radius:10px; padding:4px;" /> | <img src="assets/watches.png" alt="Watches" width="220" style="border:2px solid #2196F3; border-radius:10px; padding:4px;" /> |

</div>


