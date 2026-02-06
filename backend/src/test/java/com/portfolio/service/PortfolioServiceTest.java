package com.portfolio.service;

import com.portfolio.dto.AssetDTO;
import com.portfolio.dto.PortfolioSummaryDTO;
import com.portfolio.model.Asset;
import com.portfolio.model.Category;
import com.portfolio.model.Portfolio;
import com.portfolio.repository.AssetRepository;
import com.portfolio.repository.CategoryRepository;
import com.portfolio.repository.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PortfolioServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @Mock
    private CategoryRepository categoryRepository;
    
    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private MarketDataService marketDataService;

    @InjectMocks
    private PortfolioService portfolioService;

    @Test
    void testGetPortfolioSummary() {
        when(assetRepository.findByPortfolio_Id(1L)).thenReturn(Collections.emptyList());

        PortfolioSummaryDTO summary = portfolioService.getPortfolioSummary();

        assertNotNull(summary);
        verify(assetRepository).findByPortfolio_Id(1L);
    }

    @Test
    void testAddAsset() {
        AssetDTO dto = new AssetDTO();
        dto.setSymbol("AAPL");
        dto.setCategoryName("Stocks");

        Portfolio portfolio = new Portfolio();
        portfolio.setId(1L);

        Category category = new Category();
        category.setId(1L);
        category.setName("Stocks");

        when(portfolioRepository.findById(1L)).thenReturn(Optional.of(portfolio));
        when(categoryRepository.findByName("Stocks")).thenReturn(category);
        when(assetRepository.save(any(Asset.class))).thenAnswer(i -> {
            Asset a = (Asset) i.getArguments()[0];
            a.setId(1L);
            return a;
        });

        Asset result = portfolioService.addAsset(dto);

        assertNotNull(result);
        assertEquals("AAPL", result.getSymbol());
        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void testRemoveAsset() {
        portfolioService.removeAsset(1L);
        verify(assetRepository).deleteById(1L);
    }
}
