package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "sistema_estelar_id")
    private SistemaEstelar sistemaEstelar;

    @ManyToMany
    @JoinTable(
            name = "nave_planeta",
            joinColumns = @JoinColumn(name = "planeta_id"),
            inverseJoinColumns = @JoinColumn(name = "nave_id"))
    private List<Nave> naves;

    // Getters y Setters
    public Planeta() {}
    public Planeta(String nombre, SistemaEstelar sistemaEstelar) {
        this.nombre = nombre;
        this.sistemaEstelar = sistemaEstelar;
        this.naves = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public SistemaEstelar getSistemaEstelar() {
        return sistemaEstelar;
    }

    public List<Nave> getNaves() {
        return naves;
    }
    public void addNave(Nave nave) {
        this.naves.add(nave);
    }
}
