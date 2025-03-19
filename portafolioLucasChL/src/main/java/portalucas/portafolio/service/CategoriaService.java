


package portalucas.portafolio.service;

import portalucas.portafolio.domain.Categoria;
import portalucas.portafolio.domain.Producto;
import java.util.List;


public interface CategoriaService {
  
    // Se obtiene un listado de categorías en un List
    public List<Categoria> getCategorias(boolean activos);
    
    // Guarda o actualiza una categoría
    public void save(Categoria categoria);
    
    // Elimina una categoría
    public void delete(Categoria categoria);
    
    // Obtiene una categoría por su id
    public Categoria getCategoria(Long idCategoria);
    
    // Obtiene los productos de una categoría específica
     public List<Producto> getProductos(Long idCategoria);
}
