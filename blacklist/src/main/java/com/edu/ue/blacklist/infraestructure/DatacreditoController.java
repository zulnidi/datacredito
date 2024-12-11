package com.edu.ue.blacklist.infraestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edu.ue.blacklist.Datacredito;
import com.edu.ue.blacklist.DatacreditoService;
import java.util.List;
  
    @RestController
    @RequestMapping("/datacredito")
    public class DatacreditoController {
    
        @Autowired
        private DatacreditoService service;
    
        @GetMapping("/listar")
        public List<Datacredito> listar() {
            return service.listar();
        }
    
        @GetMapping("/listar/{id}")
        public ResponseEntity<Datacredito> listarId(@PathVariable int id) {
            Datacredito datacredito = service.listarId(id);
            if (datacredito != null) {
                return new ResponseEntity<>(datacredito, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
        @PostMapping("/add")
        public ResponseEntity<Datacredito> add(@RequestBody Datacredito datacredito) {
            Datacredito nuevo = service.add(datacredito);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        }
    
        @PutMapping("/edit")
        public ResponseEntity<Datacredito> edit(@RequestBody Datacredito datacredito) {
            Datacredito actualizado = service.edit(datacredito);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }
    
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            Datacredito eliminado = service.delete(id);
            if (eliminado != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
