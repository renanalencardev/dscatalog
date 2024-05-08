package com.renanalencar.aula.Controller;

import com.renanalencar.aula.Entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Livros"));
        list.add(new Category(2L, "Eletrônicos"));
        return ResponseEntity.ok().body(list);
    }
}
