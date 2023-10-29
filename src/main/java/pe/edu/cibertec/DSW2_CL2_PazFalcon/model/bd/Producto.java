package pe.edu.cibertec.DSW2_CL2_PazFalcon.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Producto")
public class Producto {
    private Integer idproducto;
    private String descripcion;
    private Integer cantidad;
    private Date fechavencimiento;
}
