package com.portfolio.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MarketDataServiceTest {

    private MarketDataService marketDataService;

    @BeforeEach
    void setUp() {
        marketDataService = new MarketDataService();
    }

    @Test
    void testGetCurrentPrice_Apple() {
        BigDecimal price = marketDataService.getCurrentPrice("AAPL");
        assertNotNull(price);
        assertTrue(price.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testGetCurrentPrice_Google() {
        BigDecimal price = marketDataService.getCurrentPrice("GOOG");
        assertNotNull(price);
        assertTrue(price.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testGetCurrentPrice_Microsoft() {
        BigDecimal price = marketDataService.getCurrentPrice("MSFT");
        assertNotNull(price);
        assertTrue(price.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testGetCurrentPrice_Tesla() {
        BigDecimal price = marketDataService.getCurrentPrice("TSLA");
        assertNotNull(price);
        assertTrue(price.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testGetCurrentPrice_CaseInsensitive() {
        BigDecimal price1 = marketDataService.getCurrentPrice("AAPL");
        BigDecimal price2 = marketDataService.getCurrentPrice("aapl");

        assertNotNull(price1);
        assertNotNull(price2);
        assertTrue(price1.compareTo(BigDecimal.ZERO) > 0);
        assertTrue(price2.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testGetCurrentPrice_Unknown() {
        BigDecimal price = marketDataService.getCurrentPrice("UNKNOWN");
        assertNotNull(price);
        assertTrue(price.compareTo(BigDecimal.ZERO) > 0);
    }
}
