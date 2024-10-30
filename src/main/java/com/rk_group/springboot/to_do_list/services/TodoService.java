package com.rk_group.springboot.to_do_list.services;

import com.rk_group.springboot.to_do_list.models.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> list = new ArrayList<>();

    static {
        list.add(new Todo("Rana", "Learn Java",
                LocalDate.now(),LocalDate.now().plusMonths(2), Status.STARTED));
        list.add(new Todo("Rana", "Learn Spring Framework",
                LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(3), Status.NOT_YET_STARTED));
        list.add(new Todo("Rana", "Learn Spring boot",
                LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(5),Status.NOT_YET_STARTED));
    }

    public List<Todo> findAll(){
        return list;
    }

    public void addTodo(Todo t){
        list.add(t);
    }

}
