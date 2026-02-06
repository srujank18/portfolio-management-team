package com.portfolio.service;

import com.portfolio.dto.AiRequest;
import com.portfolio.dto.AiResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiServiceTest {

    @Test
    void testAiRequestCreation() {
        AiRequest request = new AiRequest("Test prompt", "test-model");

        assertNotNull(request);
        assertEquals("Test prompt", request.getPrompt());
        assertEquals("test-model", request.getModel());
    }

    @Test
    void testAiRequestDefaultConstructor() {
        AiRequest request = new AiRequest();
        request.setPrompt("Test");
        request.setModel("model");

        assertNotNull(request);
        assertEquals("Test", request.getPrompt());
        assertEquals("model", request.getModel());
    }

    @Test
    void testAiResponseCreation() {
        AiResponse response = new AiResponse("Test answer");

        assertNotNull(response);
        assertEquals("Test answer", response.getAnswer());
    }

    @Test
    void testAiResponseDefaultConstructor() {
        AiResponse response = new AiResponse();
        response.setAnswer("Answer");

        assertNotNull(response);
        assertEquals("Answer", response.getAnswer());
    }
}

