package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Task;
import com.example.repository.TaskRepository;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    
    // Display list of all tasks
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "task-list";
    }
    
    // Display form to create a new task
    @GetMapping("/new")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("isNew", true);
        return "task-form";
    }
    
    // Save new task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }
    
    // Display form to update a task
    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable(value = "id") Long id, Model model) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        
        model.addAttribute("task", task);
        model.addAttribute("isNew", false);
        return "task-form";
    }
    
    // Delete a task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        
        taskRepository.delete(task);
        return "redirect:/tasks";
    }
    
    // Toggle task completion status
    @GetMapping("/toggle/{id}")
    public String toggleTaskStatus(@PathVariable(value = "id") Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
