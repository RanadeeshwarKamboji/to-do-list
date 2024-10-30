package com.rk_group.springboot.to_do_list.controllers;

import com.rk_group.springboot.to_do_list.models.Todo;
import com.rk_group.springboot.to_do_list.services.LoginAuthenticationService;
import com.rk_group.springboot.to_do_list.services.Status;
import com.rk_group.springboot.to_do_list.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    private static final String HOME = "redirect:/home";

    private static String userName;

    private final LoginAuthenticationService loginService;

    private final TodoService todoService;

    @Autowired
    public TodoController(LoginAuthenticationService loginService, TodoService todoService){
        this.loginService = loginService;
        this.todoService = todoService;
    }

    @GetMapping(value = "/login")
    public String loginPage(){
        return "Login";
    }
    @PostMapping(value ="/login")
    public String welcomePage(@RequestParam(required = false) String userName,
                              @RequestParam String password,
                              ModelMap mapper
    ){
        logger.info("The name of the user is {}", userName);
        if(loginService.AuthenticateUserNameAndPassword(userName, password)){
            setUserName(userName);
            mapper.addAttribute("name", userName);
            return HOME;
        }
        mapper.addAttribute("error", "Invalid credentials, Please enter valid details");
        return "Login";
    }

    @GetMapping("/home")
    public String homePage(ModelMap mapper){
        mapper.addAttribute("name", userName);
        mapper.addAttribute("todos", todoService.findAll());
        return "Home";
    }

    @GetMapping(value ="/add-todo")
    public String addTodoPage(ModelMap mapper){
        mapper.addAttribute("statuses", Status.values());
        Todo todo = new Todo(userName, "", LocalDate.now(),LocalDate.now(), Status.NOT_YET_STARTED);
        mapper.addAttribute("todo", todo);
        return "AddTodo";
    }

//    @PostMapping(value ="/add-todo")
//    public String addTodo(@RequestParam String taskName,
//                          @RequestParam LocalDate startDate,
//                          @RequestParam LocalDate finishDate,
//                          @RequestParam Status status
//    ){
//        logger.info("Status Value {}", status);
//        Todo todo = new Todo(userName, taskName, startDate, finishDate, status);
//        todoService.addTodo(todo);
//        return HOME;
//    }

    @PostMapping(value = "/add-todo")
    public String addTodo(Todo todo){
        logger.info("Task Name: {}", todo.getTaskName());
        todoService.addTodo(todo);
        return HOME;
    }

    @GetMapping(value ="/update-todo")
    public String updateTodoPage(@RequestParam long id,ModelMap mapper){
        mapper.addAttribute("statuses", Status.values());
        List<Todo> todos = todoService.findAll();
        Optional<Todo> t = todos.stream().filter(n-> n.getId()==id).findFirst();
        if(t.isPresent()){
            mapper.addAttribute("todo", t.get());
            return "UpdateTodo";
        }
        return HOME;
    }

    @PostMapping(value ="/update-todo")
    public String updateTodo(@RequestParam long id,
                            @RequestParam String taskName,
                            @RequestParam LocalDate startDate,
                            @RequestParam LocalDate finishDate,
                            @RequestParam Status status
    ){
        logger.info("Status Value {}", status);
        for (Todo t:todoService.findAll()){
            if(t.getId() == id){
                t.setStatus(status);
                t.setStartDate(startDate);
                t.setFinishDate(finishDate);
                t.setTaskName(taskName);
            }
        }
        return HOME;
    }

    @GetMapping(value ="/delete-todo")
    public String deleteTodo(@RequestParam long id){
        List<Todo> todos = todoService.findAll();
        Optional<Todo> t = todos.stream().filter(n-> n.getId()==id).findFirst();
        t.ifPresent(todo -> todoService.findAll().remove(todo));
        return HOME;
    }

    public static void setUserName(String name){
        TodoController.userName = name;
    }
}
