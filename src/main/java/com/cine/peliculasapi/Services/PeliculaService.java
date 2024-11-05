package com.cine.peliculasapi.Services;

import com.cine.peliculasapi.Repository.PeliculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cine.peliculasapi.Entities.Pelicula;
@Service
@RequiredArgsConstructor

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public void save(Pelicula pelicula){
        peliculaRepository.save(pelicula);
    }

    public void delete(Long id){
        peliculaRepository.deleteById(id);
    }

    public Pelicula findById(Long id){
        return peliculaRepository.findById(id).orElse(null);
    }

    public Iterable<Pelicula> findAll(){
        return peliculaRepository.findAll();
    }

    public void update(Pelicula pelicula){
        peliculaRepository.save(pelicula);
    }

    public void deleteAll(){
        peliculaRepository.deleteAll();
    }

    public boolean existsById(Long id){
        return peliculaRepository.existsById(id);
    }

    public long count(){
        return peliculaRepository.count();
    }

}
