package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repo;

    public List<Todo> findAll() {
        return repo.findAll();
    }
    public Todo findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo not found"));
    }
    public Todo create(Todo todo) {
        return repo.save(todo);
    }
    public Todo update(Long id, Todo todo) {
        Todo existing = findById(id);
        existing.setTitle(todo.getTitle());
        existing.setDescription(todo.getDescription());
        existing.setCompleted(todo.isCompleted());
        return repo.save(existing);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
