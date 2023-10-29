package pe.edu.cibertec.DSW2_CL2_PazFalcon.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSW2_CL2_PazFalcon.model.bd.Producto;
import pe.edu.cibertec.DSW2_CL2_PazFalcon.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){return  productoRepository.findAll();}

    public Producto guardar(Producto producto) {return  productoRepository.save(producto);}
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty())
            return Optional.empty();
        else
            return producto;
    }
    public Optional<Producto> obtenerProductoPorNombre(String descripcion){
        Optional<Producto> producto = productoRepository.findByProductoname(descripcion);
        if (producto.isEmpty())
            return Optional.empty();
        else
            return producto;
    }
    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }
}
