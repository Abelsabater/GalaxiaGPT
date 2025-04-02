package org.example.Controller;
import org.example.Entity.Planeta;
import org.example.Repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaRepository planetaRepository;

    @GetMapping
    public List<Planeta> listarPlanetas() {
        return planetaRepository.findAll();
    }

    @PostMapping
    public Planeta crearPlaneta(@RequestBody Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    @DeleteMapping("/{id}")
    public void borrarPlaneta(@PathVariable Long id) {
        planetaRepository.deleteById(id);
    }
}
