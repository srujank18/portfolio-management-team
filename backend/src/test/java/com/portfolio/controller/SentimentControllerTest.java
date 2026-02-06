package com.portfolio.controller;

import com.portfolio.model.NewsSentiment;
import com.portfolio.repository.NewsSentimentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SentimentControllerTest {

    @Mock
    private NewsSentimentRepository newsSentimentRepository;

    @InjectMocks
    private SentimentController sentimentController;

    @Test
    void testGetSentiment_Exists() {
        NewsSentiment sentiment = new NewsSentiment();
        sentiment.setId(1L);
        sentiment.setTicker("AAPL");
        sentiment.setSentimentScore(new BigDecimal("0.75"));

        when(newsSentimentRepository.findByTicker("AAPL")).thenReturn(Optional.of(sentiment));

        ResponseEntity<NewsSentiment> response = sentimentController.getSentiment("AAPL");

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("AAPL", response.getBody().getTicker());
        verify(newsSentimentRepository).findByTicker("AAPL");
    }

    @Test
    void testGetSentiment_NotExists() {
        NewsSentiment mockSentiment = new NewsSentiment();
        mockSentiment.setTicker("TSLA");
        mockSentiment.setSentimentScore(new BigDecimal("0.50"));

        when(newsSentimentRepository.findByTicker("TSLA")).thenReturn(Optional.empty());
        when(newsSentimentRepository.save(any(NewsSentiment.class))).thenReturn(mockSentiment);

        ResponseEntity<NewsSentiment> response = sentimentController.getSentiment("TSLA");

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(newsSentimentRepository).findByTicker("TSLA");
        verify(newsSentimentRepository).save(any(NewsSentiment.class));
    }
}
