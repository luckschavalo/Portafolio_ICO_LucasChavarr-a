package portalucas.portafolio.controller;

// Correct import for Categoria
import portalucas.portafolio.domain.Categoria;

import portalucas.portafolio.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        model.addAttribute("categoria", new Categoria()); // Add empty categoria for the form
        return "categoria/listado"; // Remove leading slash
    }
    
    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria, @RequestParam("imagenFile") MultipartFile imagenFile) {
        // Add code to handle image upload and save categoria
        if (!imagenFile.isEmpty()) {
            // Process and save the image
            // Set categoria.rutaImagen to the saved file path
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String eliminarCategoria(@PathVariable Long idCategoria) {
        // Fix for the incompatible types error - we need to first get the Categoria object
        Categoria categoria = categoriaService.getCategoria(idCategoria);
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String modificarCategoria(Model model, @PathVariable Long idCategoria) {
        var categoria = categoriaService.getCategoria(idCategoria);
        model.addAttribute("categoria", categoria);
        return "categoria/modifica"; // You need to create this view
    }
}