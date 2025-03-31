package com.idiomas.api.controller;

import com.idiomas.api.model.CursoDeIdioma;
import com.idiomas.api.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*") // Por si lo consumes desde el frontend
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoDeIdioma> getAll() {
        return cursoService.getAll();
    }

    //Listar todos los idiomas sin repetir
    @GetMapping("/idiomas")
    public List<String> getIdiomas() {
        return cursoService.getIdiomasUnicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDeIdioma> getById(@PathVariable Long id) {
        return cursoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CursoDeIdioma create(@RequestBody CursoDeIdioma curso) {
        return cursoService.create(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDeIdioma> update(@PathVariable Long id, @RequestBody CursoDeIdioma curso) {
        CursoDeIdioma actualizado = cursoService.update(id, curso);
        return (actualizado != null)
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
