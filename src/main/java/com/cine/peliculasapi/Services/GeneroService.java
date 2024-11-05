package com.cine.peliculasapi.Services;

import com.cine.peliculasapi.Entities.Genero;
import com.cine.peliculasapi.Repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class GeneroService {
    private final GeneroRepository generoRepository;

    public void save(Genero genero){
        generoRepository.save(genero);
    }

    public void delete(Long id){
        generoRepository.deleteById(id);
    }

    public Genero findById(Long id){
        return generoRepository.findById(id).orElse(null);
    }

    public Iterable<Genero> findAll(){
        return generoRepository.findAll();
    }

    public void update(Genero genero){
        generoRepository.save(genero);
    }

    public void deleteAll(){
        generoRepository.deleteAll();
    }

    public boolean existsById(Long id){
        return generoRepository.existsById(id);
    }

    public long count(){
        return generoRepository.count();
    }
}

