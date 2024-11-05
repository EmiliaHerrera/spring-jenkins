package com.cine.peliculasapi.Repository;

import com.cine.peliculasapi.Entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

}
