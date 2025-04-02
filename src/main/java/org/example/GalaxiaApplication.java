package org.example;
import org.example.Entity.Galaxia;
import org.example.Entity.Nave;
import org.example.Entity.Planeta;
import org.example.Entity.SistemaEstelar;
import org.example.Repository.GalaxiaRepository;
import org.example.Repository.NaveRepository;
import org.example.Repository.PlanetaRepository;
import org.example.Repository.SistemaEstelarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GalaxiaApplication implements CommandLineRunner {

    @Autowired
    private GalaxiaRepository galaxiaRepository;
    @Autowired
    private SistemaEstelarRepository sistemaEstelarRepository;
    @Autowired
    private PlanetaRepository planetaRepository;
    @Autowired
    private NaveRepository naveRepository;

    public static void main(String[] args) {
        SpringApplication.run(GalaxiaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Gestionar Galaxias");
            System.out.println("2. Gestionar Sistemas Estelares");
            System.out.println("3. Gestionar Planetas");
            System.out.println("4. Gestionar Naves");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1: gestionarGalaxias(scanner); break;
                case 2: gestionarSistemasEstelares(scanner); break;
                case 3: gestionarPlanetas(scanner); break;
                case 4: gestionarNaves(scanner); break;
                case 5: System.out.println("¡Adiós!"); return;
                default: System.out.println("Opción no válida");
            }
        }
    }

    private void gestionarGalaxias(Scanner scanner) {
        while (true) {
            System.out.println("1. Crear Galaxia");
            System.out.println("2. Listar Galaxias");
            System.out.println("3. Borrar Galaxia");
            System.out.println("4. Volver");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la galaxia: ");
                    String nombre = scanner.nextLine();
                    galaxiaRepository.save(new Galaxia(nombre));
                    break;
                case 2:
                    galaxiaRepository.findAll().forEach(g -> System.out.println(g.getId() + ": " + g.getNombre()));
                    break;
                case 3:
                    System.out.print("ID de la galaxia a borrar: ");
                    galaxiaRepository.deleteById(scanner.nextLong());
                    break;
                case 4:
                    return;
            }
        }
    }

    private void gestionarSistemasEstelares(Scanner scanner) {
        while (true) {
            System.out.println("1. Crear Sistema Estelar");
            System.out.println("2. Listar Sistemas Estelares");
            System.out.println("3. Borrar Sistema Estelar");
            System.out.println("4. Volver");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del sistema estelar: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID de la galaxia: ");
                    Long galaxiaId = scanner.nextLong();
                    Galaxia galaxia = galaxiaRepository.findById(galaxiaId).orElse(null);
                    if (galaxia != null) {
                        sistemaEstelarRepository.save(new SistemaEstelar(nombre, galaxia));
                    }
                    break;
                case 2:
                    sistemaEstelarRepository.findAll().forEach(s -> System.out.println(s.getId() + ": " + s.getNombre()));
                    break;
                case 3:
                    System.out.print("ID del sistema a borrar: ");
                    sistemaEstelarRepository.deleteById(scanner.nextLong());
                    break;
                case 4:
                    return;
            }
        }
    }

    private void gestionarPlanetas(Scanner scanner) {
        while (true) {
            System.out.println("1. Crear Planeta");
            System.out.println("2. Listar Planetas");
            System.out.println("3. Borrar Planeta");
            System.out.println("4. Volver");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del planeta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID del sistema estelar: ");
                    Long sistemaId = scanner.nextLong();
                    SistemaEstelar sistema = sistemaEstelarRepository.findById(sistemaId).orElse(null);
                    if (sistema != null) {
                        planetaRepository.save(new Planeta(nombre, sistema));
                    }
                    break;
                case 2:
                    planetaRepository.findAll().forEach(p -> System.out.println(p.getId() + ": " + p.getNombre()));
                    break;
                case 3:
                    System.out.print("ID del planeta a borrar: ");
                    planetaRepository.deleteById(scanner.nextLong());
                    break;
                case 4:
                    return;
            }
        }
    }

    private void gestionarNaves(Scanner scanner) {
        while (true) {
            System.out.println("1. Crear Nave");
            System.out.println("2. Listar Naves");
            System.out.println("3. Borrar Nave");
            System.out.println("4. Volver");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la nave: ");
                    naveRepository.save(new Nave(scanner.nextLine()));
                    break;
                case 2:
                    naveRepository.findAll().forEach(n -> System.out.println(n.getId() + ": " + n.getNombre()));
                    break;
                case 3:
                    System.out.print("ID de la nave a borrar: ");
                    naveRepository.deleteById(scanner.nextLong());
                    break;
                case 4:
                    return;
            }
        }
    }
}
