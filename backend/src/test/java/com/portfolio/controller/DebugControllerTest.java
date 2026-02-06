package com.portfolio.controller;

import com.portfolio.model.Asset;
import com.portfolio.model.Category;
import com.portfolio.model.Portfolio;
import com.portfolio.repository.AssetRepository;
import com.portfolio.repository.CategoryRepository;
import com.portfolio.repository.PortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DebugControllerTest {

    @Mock
    private AssetRepository assetRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private DebugController debugController;

    @BeforeEach
    void setUp() {
        // Test setup
    }

    @Test
    void testGetAllAssets() {
        Asset asset = new Asset();
        asset.setId(1L);
        asset.setSymbol("AAPL");

        when(assetRepository.findAll()).thenReturn(List.of(asset));

        ResponseEntity<List<Asset>> response = debugController.getAllAssets();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(assetRepository).findAll();
    }

    @Test
    void testGetAllCategories() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Tech");

        when(categoryRepository.findAll()).thenReturn(List.of(category));

        ResponseEntity<List<Category>> response = debugController.getAllCategories();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(categoryRepository).findAll();
    }

    @Test
    void testGetAllPortfolios() {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(1L);
        portfolio.setName("Main Portfolio");

        when(portfolioRepository.findAll()).thenReturn(List.of(portfolio));

        ResponseEntity<List<Portfolio>> response = debugController.getAllPortfolios();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(portfolioRepository).findAll();
    }
}
