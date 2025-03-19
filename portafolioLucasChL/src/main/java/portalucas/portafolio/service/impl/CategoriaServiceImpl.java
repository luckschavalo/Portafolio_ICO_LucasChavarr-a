


package portalucas.portafolio.service.impl;


import portalucas.portafolio.dao.CategoriaDao;
import portalucas.portafolio.domain.Categoria;
import portalucas.portafolio.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public abstract class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
}
