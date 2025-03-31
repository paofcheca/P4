package com.idiomas.api.repository;

import com.idiomas.api.model.CursoDeIdioma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoDeIdioma, Long> {


}
