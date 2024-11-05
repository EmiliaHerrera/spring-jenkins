package com.cine.peliculasapi.Controllers;

import com.cine.peliculasapi.Entities.Genero;
import com.cine.peliculasapi.Services.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/genero")
@RequiredArgsConstructor

public class GeneroController {

    private final GeneroService generoService;

    @PostMapping("/save")
    public void save(@RequestBody Genero genero){
        generoService.save(genero);
    }

    @PostMapping("/delete/{id}")
    public void delete(Long id){
        generoService.delete(id);
    }

    @PostMapping("/findById/{id}")
    public Genero findById(Long id){
        return generoService.findById(id);
    }

    @PostMapping("/findAll")
    public Iterable<Genero> findAll(){
        return generoService.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Genero genero){
        generoService.update(genero);
    }

    @PostMapping("/deleteAll")
    public void deleteAll(){
        generoService.deleteAll();
    }

    @PostMapping("/existsById/{id}")
    public boolean existsById(Long id){
        return generoService.existsById(id);
    }

    @PostMapping("/count")
    public long count(){
        return generoService.count();
    }

}
