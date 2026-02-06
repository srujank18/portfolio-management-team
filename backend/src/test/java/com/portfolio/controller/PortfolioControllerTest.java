package com.portfolio.controller;

import com.portfolio.dto.AssetDTO;
import com.portfolio.dto.PortfolioSummaryDTO;
import com.portfolio.model.Asset;
import com.portfolio.model.Category;
import com.portfolio.model.Portfolio;
import com.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PortfolioControllerTest {

    @Mock
    private PortfolioService portfolioService;

    @InjectMocks
    private PortfolioController portfolioController;

    @Test
    void testGetPortfolioSummary() {
        PortfolioSummaryDTO summaryDTO = new PortfolioSummaryDTO();
        summaryDTO.setAssets(new ArrayList<>());
        summaryDTO.setTotalValue(new BigDecimal("1000.00"));

        when(portfolioService.getPortfolioSummary()).thenReturn(summaryDTO);

        ResponseEntity<PortfolioSummaryDTO> response = portfolioController.getPortfolioSummary();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(portfolioService).getPortfolioSummary();
    }

    @Test
    void testAddAsset() {
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setSymbol("AAPL");

        Asset asset = new Asset();
        asset.setId(1L);
        asset.setSymbol("AAPL");

        when(portfolioService.addAsset(any())).thenReturn(asset);

        ResponseEntity<?> response = portfolioController.addAsset(assetDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(portfolioService).addAsset(any());
    }

    @Test
    void testDeleteAsset() {
        ResponseEntity<Void> response = portfolioController.deleteAsset(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(portfolioService).removeAsset(1L);
    }
}
