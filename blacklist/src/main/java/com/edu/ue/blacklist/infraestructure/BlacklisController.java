package com.edu.ue.blacklist.infraestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.edu.ue.blacklist.Blacklis;
import com.edu.ue.blacklist.BlacklisServices;

import java.util.List;

@RestController
@RequestMapping("/api/blacklists")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BlacklisController {

    @Autowired
    private BlacklisServices service;

    @Autowired
    private RestTemplate restTemplate;

    private final String API_BASE_URL = "http://external-api-url.com";

    @GetMapping
    public ResponseEntity<List<Blacklis>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blacklis> listarPorId(@PathVariable int id) {
        Blacklis blacklist = service.listarId(id);
        return blacklist != null
                ? new ResponseEntity<>(blacklist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Blacklis> agregar(@RequestBody Blacklis blacklist) {
        return new ResponseEntity<>(service.add(blacklist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blacklis> editar(@PathVariable int id, @RequestBody Blacklis blacklist) {
        blacklist.setId(id);
        return new ResponseEntity<>(service.edit(blacklist), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/consulta/{userId}")
    public ResponseEntity<String> consultarUsuario(@PathVariable int userId) {
        String usuarioUrl = API_BASE_URL + "/usuarios/" + userId;
        String productoUrl = API_BASE_URL + "/productos/" + userId;
        String solicitudUrl = API_BASE_URL + "/solicitudes/" + userId;

        try {
            // Consultar usuario
            ResponseEntity<String> usuarioResponse = restTemplate.getForEntity(usuarioUrl, String.class);
            String usuario = usuarioResponse.getBody();
               // Consultar producto
               ResponseEntity<String> productoResponse = restTemplate.getForEntity(productoUrl, String.class);
               String producto = productoResponse.getBody();
   
               // Consultar solicitud
               ResponseEntity<String> solicitudResponse = restTemplate.getForEntity(solicitudUrl, String.class);
               String solicitud = solicitudResponse.getBody();
   
               // Validar Blacklist y Datacrédito (simulado)
               boolean enBlacklist = service.listar().stream().anyMatch(b -> b.getEstado().equalsIgnoreCase("restringido"));
               boolean enDatacredito = Math.random() > 0.5; // Simulación de validación externa
   
               if (enBlacklist || enDatacredito) {
                   return new ResponseEntity<>("Préstamo rechazado por historial negativo.", HttpStatus.OK);
               }
   
               return new ResponseEntity<>("Préstamo aprobado para usuario: " + usuario, HttpStatus.OK);
   
           } catch (Exception e) {
               return new ResponseEntity<>("Error en la consulta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
           }
       }
   }
   