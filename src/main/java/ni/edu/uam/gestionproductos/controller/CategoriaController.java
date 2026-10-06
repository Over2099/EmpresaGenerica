package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.entity.Categoria;
import ni.edu.uam.gestionproductos.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}