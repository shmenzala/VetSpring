/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.ClienteDto;
import com.pe.sh.Veterinaria.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<ClienteDto> listarClientes(){
        return clienteService.listarClientes();
    }
    
    @PostMapping("/persona/{codigope}")
    public ResponseEntity<ClienteDto> crearCliente(@PathVariable(value = "codigope") String id, @RequestBody ClienteDto cliDto){
        return new ResponseEntity<>(clienteService.crearCliente(id, cliDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/persona/{codigope}")
    public ResponseEntity<ClienteDto> obtenerClientePorId(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope){
        ClienteDto cliDto = clienteService.obtenerClientePorId(id, codigope);
        
        return new ResponseEntity<>(cliDto, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/persona/{codigope}")
    public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope, @RequestBody ClienteDto cliDto){
        ClienteDto clienteActualizado = clienteService.actualizarCliente(cliDto, id, codigope);
        
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}/persona/{codigope}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope) {
        clienteService.eliminarCliente(id, codigope);
        return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.OK);
    }
    
}
