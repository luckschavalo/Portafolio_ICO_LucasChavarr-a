package portalucas.portafolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portalucas.portafolio.dao.CategoriaDao;
import portalucas.portafolio.domain.Categoria;
import portalucas.portafolio.service.CategoriaService;
import portalucas.portafolio.domain.Producto; // 🔹 Agrega esta línea

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(categoria -> !categoria.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Long idCategoria) {
        return categoriaDao.findById(idCategoria).orElse(null);
       
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(Long idCategoria) {
        Categoria categoria = getCategoria(idCategoria);
        return (categoria != null) ? categoria.getProductos() : List.of(); // Retorna lista vacía si no encuentra la categoría
    }
}
