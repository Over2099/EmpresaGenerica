package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.repository.EtiquetaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetaController {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaController(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    @GetMapping
    public List<Etiqueta> listar() {
        return etiquetaRepository.findAll();
    }

    @PostMapping
    public Etiqueta guardar(@RequestBody Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }
}