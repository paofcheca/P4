package com.idiomas.api.service;

import com.idiomas.api.model.CursoDeIdioma;
import com.idiomas.api.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDeIdioma> getAll() {
        return cursoRepository.findAll(); // 👈 corrección
    }
    public List<String> getIdiomasUnicos() {
        return cursoRepository.findAll().stream()
                .map(CursoDeIdioma::getIdioma)
                .distinct()
                .toList();
    }


    public Optional<CursoDeIdioma> getById(Long id) {
        return cursoRepository.findById(id); // 👈 corrección
    }

    public CursoDeIdioma create(CursoDeIdioma curso) {
        return cursoRepository.save(curso); // 👈 corrección
    }

    public CursoDeIdioma update(Long id, CursoDeIdioma nuevoCurso) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(nuevoCurso.getNombre());
            curso.setIdioma(nuevoCurso.getIdioma());
            curso.setNivel(nuevoCurso.getNivel());
            curso.setDescripcion(nuevoCurso.getDescripcion());
            curso.setImagenUrl(nuevoCurso.getImagenUrl());
            return cursoRepository.save(curso);
        }).orElse(null);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
