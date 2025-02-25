


package portalucas.portafolio.service;

import portalucas.portafolio.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
 
}
