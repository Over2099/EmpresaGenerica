package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.entity.Proveedor;
import ni.edu.uam.gestionproductos.repository.ProveedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorRepository repository;

    public ProveedorController(ProveedorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return repository.save(proveedor);
    }
}