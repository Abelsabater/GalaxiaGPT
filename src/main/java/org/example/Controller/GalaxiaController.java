package org.example.Controller;

import org.example.Entity.Galaxia;
import org.example.Repository.GalaxiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galaxia")
public class GalaxiaController {

    @Autowired
    private GalaxiaRepository galaxiaRepository;

    @PostMapping
    public Galaxia crearGalaxia(@RequestBody Galaxia galaxia) {
        return galaxiaRepository.save(galaxia);
    }

    @DeleteMapping("/{id}")
    public void borrarGalaxia(@PathVariable Long id) {
        galaxiaRepository.deleteById(id);
    }

    @GetMapping
    public List<Galaxia> listarGalaxias() {
        return galaxiaRepository.findAll();
    }
}