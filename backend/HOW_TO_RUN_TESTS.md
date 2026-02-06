# 🚀 HOW TO RUN YOUR TESTS

## The Simple Way

### Step 1: Open Terminal
Open a terminal/command prompt in your project directory

### Step 2: Navigate to Backend
```bash
cd backend
```

### Step 3: Run Tests
```bash
mvn clean test
```

### Step 4: Watch Them Pass! ✅
You should see:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.portfolio.service.PortfolioServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.service.AiServiceTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.service.MarketDataServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.controller.PortfolioControllerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.controller.AiControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.controller.SentimentControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.controller.DebugControllerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.portfolio.controller.CategoryServiceTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] -------------------------------------------------------
[INFO] Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## Run Individual Tests

### Run One Test Class
```bash
mvn test -Dtest=PortfolioServiceTest
```

### Run One Specific Test Method
```bash
mvn test -Dtest=PortfolioServiceTest#testAddAsset
```

### Run Multiple Classes
```bash
mvn test -Dtest=PortfolioServiceTest,AiServiceTest
```

---

## Useful Commands

### Run Tests and See Detailed Output
```bash
mvn test -X
```

### Run Tests with Maven Debug
```bash
mvn -e test
```

### Skip Tests and Just Build
```bash
mvn clean install -DskipTests
```

### Run Tests Multiple Times
```bash
mvn test -Dtest=PortfolioServiceTest -Drepeat=3
```

---

## All Available Test Classes

Copy/paste any of these to run a specific class:

```bash
mvn test -Dtest=PortfolioServiceTest
mvn test -Dtest=AiServiceTest
mvn test -Dtest=MarketDataServiceTest
mvn test -Dtest=PortfolioControllerTest
mvn test -Dtest=AiControllerTest
mvn test -Dtest=SentimentControllerTest
mvn test -Dtest=DebugControllerTest
mvn test -Dtest=CategoryServiceTest
```

---

## All Available Test Methods

### PortfolioServiceTest
```bash
mvn test -Dtest=PortfolioServiceTest#testGetPortfolioSummary
mvn test -Dtest=PortfolioServiceTest#testAddAsset
mvn test -Dtest=PortfolioServiceTest#testRemoveAsset
```

### AiServiceTest
```bash
mvn test -Dtest=AiServiceTest#testAiRequestCreation
mvn test -Dtest=AiServiceTest#testAiRequestDefaultConstructor
mvn test -Dtest=AiServiceTest#testAiResponseCreation
mvn test -Dtest=AiServiceTest#testAiResponseDefaultConstructor
```

### MarketDataServiceTest
```bash
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_Apple
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_Google
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_Microsoft
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_Tesla
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_CaseInsensitive
mvn test -Dtest=MarketDataServiceTest#testGetCurrentPrice_Unknown
```

### PortfolioControllerTest
```bash
mvn test -Dtest=PortfolioControllerTest#testGetPortfolioSummary
mvn test -Dtest=PortfolioControllerTest#testAddAsset
mvn test -Dtest=PortfolioControllerTest#testDeleteAsset
```

### AiControllerTest
```bash
mvn test -Dtest=AiControllerTest#testAsk_Success
mvn test -Dtest=AiControllerTest#testAsk_WithNullModel
```

### SentimentControllerTest
```bash
mvn test -Dtest=SentimentControllerTest#testGetSentiment_Exists
mvn test -Dtest=SentimentControllerTest#testGetSentiment_NotExists
```

### DebugControllerTest
```bash
mvn test -Dtest=DebugControllerTest#testGetAllAssets
mvn test -Dtest=DebugControllerTest#testGetAllCategories
mvn test -Dtest=DebugControllerTest#testGetAllPortfolios
```

### CategoryServiceTest
```bash
mvn test -Dtest=CategoryServiceTest#testGetAllCategories
mvn test -Dtest=CategoryServiceTest#testGetAllCategories_Empty
```

---

## Troubleshooting

### "mvn: command not found"
Maven is not installed or not in PATH
- Install Maven: https://maven.apache.org/install.html
- Add to PATH

### "Tests are failing"
This shouldn't happen, but if it does:
- Make sure you're in the backend directory
- Run `mvn clean test` (not just `mvn test`)
- Check Java version: `java -version` (should be 17+)

### "Dependencies missing"
Run this to download all dependencies:
```bash
mvn dependency:resolve
```

### "Need to rebuild"
Use:
```bash
mvn clean install
```

---

## Expected Behavior

1. **mvn clean** - Cleans previous build
2. **mvn test** - Compiles test files
3. **mvn test** - Runs all 25 tests
4. **All tests pass** - BUILD SUCCESS

Total time: Usually < 30 seconds

---

## Quick Summary

| Command | What It Does |
|---------|-------------|
| `mvn clean test` | Run all tests |
| `mvn test -Dtest=ClassName` | Run one class |
| `mvn test -Dtest=ClassName#methodName` | Run one method |
| `mvn clean install -DskipTests` | Build without tests |
| `mvn -e test` | Show detailed errors |

---

## That's It!

Just run:
```bash
mvn clean test
```

And all 25 tests will pass! 🎉

---
