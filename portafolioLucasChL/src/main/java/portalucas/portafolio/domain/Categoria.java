package portalucas.portafolio.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombre;
    private boolean activo;

    @OneToMany(mappedBy = "categoria") // Asegúrate de que "categoria" es el nombre correcto en Producto
    private List<Producto> productos; // Lista de productos en la categoría

    // Constructor vacío
    public Categoria() {}

    // Getters y Setters
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Producto> getProductos() {  // 🔹 ESTE MÉTODO ES CLAVE
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
