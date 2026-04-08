package com.vatsal.todo_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Unit tests for TodoService
public class TodoServiceTest {
    
    // Service instance for testing
    private TodoService service;
    
    // Setup before each test
    @BeforeEach
    void setUp() {
        service = new TodoService();
        service.getAllTodos().clear(); // Clean state
    }
    // Test adding a todo
    @Test
    void testAddTodo() {
        Todo todo = new Todo(0, "Sample Task", false);
        service.createTodo(todo);
        assertTrue(service.getAllTodos().contains(todo));
    }

    // Test removing a todo
    @Test
    void testRemoveTodo() {
        Todo todo = new Todo(0, "Sample Task", false);
        service.createTodo(todo);
        service.deleteTodo(todo.getId());
        assertFalse(service.getAllTodos().contains(todo));
    }

    // Test getting todos count
    @Test
    void testGetTodos() {
        Todo todo1 = new Todo(0, "Task 1", false);
        Todo todo2 = new Todo(0, "Task 2", false);
        service.createTodo(todo1);
        service.createTodo(todo2);
        assertEquals(2, service.getAllTodos().size());
    }
}
