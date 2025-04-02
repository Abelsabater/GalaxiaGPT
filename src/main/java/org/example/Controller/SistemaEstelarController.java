package org.example.Controller;

import org.example.Entity.SistemaEstelar;
import org.example.Repository.SistemaEstelarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistema_estelar")
public class SistemaEstelarController {

    @Autowired
    private SistemaEstelarRepository sistemaEstelarRepository;

    @GetMapping
    public List<SistemaEstelar> listarSistemasEstelares() {
        return sistemaEstelarRepository.findAll();
    }

    @PostMapping
    public SistemaEstelar crearSistemaEstelar(@RequestBody SistemaEstelar sistema) {
        return sistemaEstelarRepository.save(sistema);
    }

    @DeleteMapping("/{id}")
    public void borrarSistemaEstelar(@PathVariable Long id) {
        sistemaEstelarRepository.deleteById(id);
    }
}