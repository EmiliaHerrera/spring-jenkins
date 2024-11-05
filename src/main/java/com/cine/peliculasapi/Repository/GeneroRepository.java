package com.cine.peliculasapi.Repository;

import com.cine.peliculasapi.Entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
