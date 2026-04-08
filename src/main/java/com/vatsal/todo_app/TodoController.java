package com.vatsal.todo_app;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET all todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // GET single todo by ID 
    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        Todo todo = todoService.getById(id);
        if (todo == null) {
            return "Error: Todo with id " + id + " not found";
        }
        return todo;
    }

    // CREATE new todo - auto generates the new ID (last ID + 1)
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // UPDATE existing todo
    @PutMapping("/{id}")
    public Object updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
        Todo todo = todoService.updateTodo(id, updatedTodo);
        if (todo == null) {
            return "Error: Cannot update - Todo with id " + id + " not found";
        }
        return todo;
    }

    // DELETE todo 
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        boolean deleted = todoService.deleteTodo(id);
        if (deleted) {
            return "Success: Todo with id " + id + " deleted successfully";
        } else {
            return "Error: Todo with id " + id + " not found";
        }
    }

    // Error handling for PUT without ID
    @PutMapping
    public String updateTodoError() {
        return "Error: PUT request requires an ID. Use /todos/{id} format";
    }
}