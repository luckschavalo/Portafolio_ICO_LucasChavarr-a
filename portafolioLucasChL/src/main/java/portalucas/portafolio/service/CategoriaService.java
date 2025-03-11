


package portalucas.portafolio.service;

import portalucas.portafolio.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
    
    // aqui se ponen los metodos que ocupa la pagina 
    
    public void save (Categoria categoria);
    
    public void delete (Categoria categoria);
 
}
