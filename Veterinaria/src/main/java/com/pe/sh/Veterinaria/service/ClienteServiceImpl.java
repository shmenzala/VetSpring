/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.ClienteDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.exceptions.VetAppException;
import com.pe.sh.Veterinaria.model.Cliente;
import com.pe.sh.Veterinaria.model.Persona;
import com.pe.sh.Veterinaria.repository.ClienteRepository;
import com.pe.sh.Veterinaria.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public ClienteDto crearCliente(String codigope, ClienteDto cliDto) {
        Cliente cliente = mapearEntidad(cliDto);

        Persona persona = personaRepository.findById(codigope)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", codigope));
        
        long coincidencia = clienteRepository.coincidenciaPersonaVeterinario(codigope);
        
        if(coincidencia > 0){
            return mapearDto(cliente);
        }
        
        cliente.setPersonacli(persona);

        Cliente nuevoCliente = clienteRepository.save(cliente);

        return mapearDto(nuevoCliente);
    }

    @Override
    public List<ClienteDto> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> mapearDto(cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteDto obtenerClientePorId(String id, String codigope) {
        Persona persona = personaRepository.findById(codigope)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", codigope));

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

        if (!cliente.getPersonacli().getCodigope().equals(persona.getCodigope())) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "La persona no tiene relacion con el cliente");
        }

        return mapearDto(cliente);
    }

    @Override
    public ClienteDto actualizarCliente(ClienteDto cliDto, String id, String codigope) {
        Persona persona = personaRepository.findById(codigope)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", codigope));

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

        if (!cliente.getPersonacli().getCodigope().equals(persona.getCodigope())) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "La persona no tiene relacion con el cliente");
        }

        cliente.setDireccion(cliDto.getDireccion());

        Cliente cliActualizado = clienteRepository.save(cliente);

        return mapearDto(cliActualizado);
    }

    @Override
    public void eliminarCliente(String id, String codigope) {
        Persona persona = personaRepository.findById(codigope)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", codigope));

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

        if (!cliente.getPersonacli().getCodigope().equals(persona.getCodigope())) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "La persona no tiene relacion con el cliente");
        }

        clienteRepository.delete(cliente);
    }

    @Override
    public List<ClienteDto> listarClientesPorMascotaId(String codigoma) {
        List<Cliente> clientes = clienteRepository.findByMascotasId(codigoma);
        return clientes.stream().map(cliente -> mapearDto(cliente)).collect(Collectors.toList());
    }

    //La ENTIDAD setea los datos provenientes del DTO
    private Cliente mapearEntidad(ClienteDto cliDto) {
        Cliente cli = modelMapper.map(cliDto, Cliente.class);
        return cli;
    }

    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private ClienteDto mapearDto(Cliente cli) {
        ClienteDto cliDto = modelMapper.map(cli, ClienteDto.class);
        return cliDto;
    }

    /*@Override
    public List<ClienteDto> obtenerClientePorPersonaId(String id) {
        List<Cliente> clientes = clienteRepository.findByPersonacliId(id);
        return clientes.stream().map(cliente -> mapearDto(cliente)).collect(Collectors.toList());
    }*/
}
