package com.portfolio.controller;

import com.portfolio.dto.AiRequest;
import com.portfolio.dto.AiResponse;
import com.portfolio.service.AiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AiControllerTest {

    @Mock
    private AiService aiService;

    @InjectMocks
    private AiController aiController;

    @Test
    void testAsk_Success() {
        AiRequest request = new AiRequest("Test prompt", "test-model");
        AiResponse mockResponse = new AiResponse("Test response");

        when(aiService.ask(request)).thenReturn(mockResponse);

        ResponseEntity<AiResponse> response = aiController.ask(request);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(aiService).ask(request);
    }

    @Test
    void testAsk_WithNullModel() {
        AiRequest request = new AiRequest("Test prompt", null);
        AiResponse mockResponse = new AiResponse("Response without model");

        when(aiService.ask(request)).thenReturn(mockResponse);

        ResponseEntity<AiResponse> response = aiController.ask(request);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(aiService).ask(request);
    }
}
