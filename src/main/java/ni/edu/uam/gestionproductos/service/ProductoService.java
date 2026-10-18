package ni.edu.uam.gestionproductos.service;

import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.entity.Categoria;
import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.repository.CategoriaRepository;
import ni.edu.uam.gestionproductos.repository.EtiquetaRepository;
import ni.edu.uam.gestionproductos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, EtiquetaRepository etiquetaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto guardar(ProductoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, ProductoRequestDTO dto) {
        Producto producto = buscarPorId(id);

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> listarPorCategoria(Integer categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    private final EtiquetaRepository etiquetaRepository; // Inyectar en el constructor

    public Producto agregarEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));

        producto.getEtiquetas().add(etiqueta);
        return productoRepository.save(producto);
    }

    public Producto removerEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));

        producto.getEtiquetas().remove(etiqueta);
        return productoRepository.save(producto);
    }

    public List<Producto> listarPorEtiqueta(Integer etiquetaId) {
        return productoRepository.findByEtiquetasId(etiquetaId);
    }

}

