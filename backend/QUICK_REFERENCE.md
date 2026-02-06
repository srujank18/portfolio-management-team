# QUICK REFERENCE - Unit Tests

## One-Line Summary
**8 test classes, 25 test methods, all simple, all passing, ready to run**

---

## Test Files at a Glance

| File | Location | Tests | Purpose |
|------|----------|-------|---------|
| PortfolioServiceTest | service/ | 3 | CRUD operations |
| AiServiceTest | service/ | 4 | DTO creation |
| MarketDataServiceTest | service/ | 6 | Price lookups |
| PortfolioControllerTest | controller/ | 3 | REST endpoints |
| AiControllerTest | controller/ | 2 | AI requests |
| SentimentControllerTest | controller/ | 2 | Sentiment lookup |
| DebugControllerTest | controller/ | 3 | Debug endpoints |
| CategoryServiceTest | controller/ | 2 | Categories |
| **TOTAL** | | **25** | |

---

## Run Tests (3 ways)

```bash
# All tests
mvn clean test

# One class
mvn test -Dtest=PortfolioServiceTest

# One method
mvn test -Dtest=PortfolioServiceTest#testAddAsset
```

---

## What Each Test Tests

### PortfolioServiceTest
1. `testGetPortfolioSummary()` - Get summary
2. `testAddAsset()` - Add asset
3. `testRemoveAsset()` - Delete asset

### AiServiceTest
1. `testAiRequestCreation()` - Create request
2. `testAiRequestDefaultConstructor()` - Default constructor
3. `testAiResponseCreation()` - Create response
4. `testAiResponseDefaultConstructor()` - Response constructor

### MarketDataServiceTest
1. `testGetCurrentPrice_Apple()` - AAPL price
2. `testGetCurrentPrice_Google()` - GOOG price
3. `testGetCurrentPrice_Microsoft()` - MSFT price
4. `testGetCurrentPrice_Tesla()` - TSLA price
5. `testGetCurrentPrice_CaseInsensitive()` - Case handling
6. `testGetCurrentPrice_Unknown()` - Unknown symbols

### PortfolioControllerTest
1. `testGetPortfolioSummary()` - GET endpoint
2. `testAddAsset()` - POST endpoint
3. `testDeleteAsset()` - DELETE endpoint

### AiControllerTest
1. `testAsk_Success()` - Successful request
2. `testAsk_WithNullModel()` - No model

### SentimentControllerTest
1. `testGetSentiment_Exists()` - Existing data
2. `testGetSentiment_NotExists()` - Create mock

### DebugControllerTest
1. `testGetAllAssets()` - List assets
2. `testGetAllCategories()` - List categories
3. `testGetAllPortfolios()` - List portfolios

### CategoryServiceTest
1. `testGetAllCategories()` - Get categories
2. `testGetAllCategories_Empty()` - Empty list

---

## Test Pattern (All Tests Follow This)

```java
@Test
void testSomething() {
    // Arrange - setup
    Data data = new Data();
    
    // Act - execute
    Result result = service.doSomething(data);
    
    // Assert - verify
    assertNotNull(result);
    verify(mock).called();
}
```

---

## Key Points

✅ **Simple** - No complex logic  
✅ **Fast** - No database  
✅ **Mocked** - All dependencies mocked  
✅ **Clear** - Names explain what they test  
✅ **Passing** - All 25 tests pass  

❌ **No** Spring context  
❌ **No** database calls  
❌ **No** API calls  
❌ **No** file I/O  

---

## Documentation Files

1. **TEST_CASES_SUMMARY.md** - Full details
2. **TEST_REFERENCE_GUIDE.md** - Examples & patterns
3. **TEST_CHECKLIST.md** - Verification
4. **README_TESTS.md** - Quick start
5. **This file** - Quick reference

---

## Expected Results

```
mvn clean test

[INFO] Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Tests don't run | Check Java 17+ and Maven installed |
| Import errors | Ensure test dependencies in pom.xml |
| Mock errors | Verify @ExtendWith(MockitoExtension.class) |
| Assertion fails | Check test logic, not framework |

---

## Files Location

```
backend/
└── src/test/java/com/portfolio/
    ├── service/ (3 test files)
    └── controller/ (5 test files)
```

---

## That's It!

✅ Tests are ready  
✅ Just run: `mvn clean test`  
✅ All 25 should pass  

Enjoy! 🚀

