
package com.vatsal.todo_app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private int nextId = 6;

    // Initializing with 5 sample data
    public TodoService() {
        todos.add(new Todo(1, "Buy groceries", false));
        todos.add(new Todo(2, "Walk the dog", true));
        todos.add(new Todo(3, "Read a book", false));
        todos.add(new Todo(4, "Write code", true));
        todos.add(new Todo(5, "Exercise", false));
    }

    // Service to GET all todos
    public List<Todo> getAllTodos() {
        return todos;
    }

    // Service to GET single todo by ID
    public Todo getById(int id) {
        return todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Service to CREATE new todo - auto generates the new ID (last ID + 1)
    public Todo createTodo(Todo todo) {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    // Service to UPDATE existing todo
    public Todo updateTodo(int id, Todo updatedTodo) {
        for (Todo t : todos) {
            if (t.getId() == id) {
                t.setTitle(updatedTodo.getTitle());
                t.setCompleted(updatedTodo.isCompleted());
                return t;
            }
        }
        return null;
    }

    // Service to DELETE todo
    public boolean deleteTodo(int id) {
        Iterator<Todo> it = todos.iterator();
        while (it.hasNext()) {
            Todo t = it.next();
            if (t.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
