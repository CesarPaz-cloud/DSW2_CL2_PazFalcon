package pe.edu.cibertec.DSW2_CL2_PazFalcon.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSW2_CL2_PazFalcon.model.bd.Producto;
import pe.edu.cibertec.DSW2_CL2_PazFalcon.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos().forEach(productoList::add);
        if (productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Integer id) {
        Producto producto = productoService.obtenerProductoPorId(id).orElseThrow(() -> new ResourceNotFoundException("El Producto con el Id Nro."+ id+ " no existe."));

        return new ResponseEntity<>(Producto, HttpStatus.OK);
    }
    @GetMapping("/descripcion/{filtro}")
    public ResponseEntity<List<Producto>> filtrarCategoriasPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

}
