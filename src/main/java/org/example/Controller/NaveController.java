package org.example.Controller;

import org.example.Entity.Nave;
import org.example.Repository.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nave")
public class NaveController {

    @Autowired
    private NaveRepository naveRepository;

    @PostMapping
    public Nave crearNave(@RequestBody Nave nave) {
        return naveRepository.save(nave);
    }

    @DeleteMapping("/{id}")
    public void borrarNave(@PathVariable Long id) {
        naveRepository.deleteById(id);
    }

    @GetMapping
    public List<Nave> listarNaves() {
        return naveRepository.findAll();
    }
}