package com.portfolio.controller;

import com.portfolio.model.Category;
import com.portfolio.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    void testGetAllCategories() {
        Category cat1 = new Category();
        cat1.setId(1L);
        cat1.setName("Stocks");

        when(categoryRepository.findAll()).thenReturn(List.of(cat1));

        ResponseEntity<List<Category>> response = categoryController.getAllCategories();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(categoryRepository).findAll();
    }

    @Test
    void testGetAllCategories_Empty() {
        when(categoryRepository.findAll()).thenReturn(List.of());

        ResponseEntity<List<Category>> response = categoryController.getAllCategories();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
        verify(categoryRepository).findAll();
    }
}
