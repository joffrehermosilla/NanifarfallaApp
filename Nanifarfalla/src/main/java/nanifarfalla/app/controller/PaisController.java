package nanifarfalla.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nanifarfalla.app.model.Pais;
import nanifarfalla.app.service.IPaisService;

@RestController
@RequestMapping(path="/pais")
public class PaisController {

	@Autowired
	private IPaisService paisService;
	
    @GetMapping(value="/consultarTodo")
    public List<Pais> consultarTodo(){
          return paisService.buscarTodas();
    }	
    
    @PostMapping(value="/guardar")
    public Pais guardar(@RequestBody Pais pais){
          return paisService.save(pais);
    }	
    
    @DeleteMapping(value="/eliminar")
    public void eliminar(@PathVariable Integer id){
           paisService.delete(id);
    }	
}
