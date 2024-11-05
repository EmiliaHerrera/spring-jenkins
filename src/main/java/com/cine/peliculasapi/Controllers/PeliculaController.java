package com.cine.peliculasapi.Controllers;

import com.cine.peliculasapi.Entities.Pelicula;
import com.cine.peliculasapi.Services.PeliculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/pelicula")
@RequiredArgsConstructor

public class PeliculaController {
    private final PeliculaService peliculaService;

    @PostMapping("/save")
    public void save(@RequestBody Pelicula pelicula){
        peliculaService.save(pelicula);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        peliculaService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Pelicula findById(@PathVariable Long id){
        return peliculaService.findById(id);
    }

    @GetMapping("/findAll")
    public Iterable<Pelicula> findAll(){
        return peliculaService.findAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody Pelicula pelicula){
        peliculaService.update(pelicula);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        peliculaService.deleteAll();
    }

    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable Long id){
        return peliculaService.existsById(id);
    }

    @GetMapping("/count")
    public long count(){
        return peliculaService.count();
    }
}
