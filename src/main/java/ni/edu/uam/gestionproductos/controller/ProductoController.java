package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Integer id) {
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody ProductoRequestDTO dto) {
        return productoService.guardar(dto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody ProductoRequestDTO dto) {
        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> listarPorCategoria(@PathVariable Integer categoriaId) {
        return productoService.listarPorCategoria(categoriaId);
    }

    @DeleteMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto removerEtiqueta(@PathVariable Integer productoId, @PathVariable Integer etiquetaId) {
        return productoService.removerEtiqueta(productoId, etiquetaId);
    }

    @GetMapping("/etiqueta/{etiquetaId}")
    public List<Producto> listarPorEtiqueta(@PathVariable Integer etiquetaId) {
        return productoService.listarPorEtiqueta(etiquetaId);
    }

    @PostMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto agregarEtiqueta(@PathVariable Integer productoId, @PathVariable Integer etiquetaId) {
        return productoService.agregarEtiqueta(productoId, etiquetaId);
    }
}