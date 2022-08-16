package com.example.delivery.resources;

import com.example.delivery.dto.UserDTO;
import com.example.delivery.dto.UserInsertDTO;
import com.example.delivery.dto.UserUpdateDTO;
import com.example.delivery.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/users")
@Api(value = "API REST User")
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna o usuário desejado")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO userDTO = service.findById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping(value = "/profile")
    @ApiOperation(value = "Retorna o usuário logado")
    public ResponseEntity<UserDTO> findByUser(){
        UserDTO userDTO = service.getUserAuth();
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    @ApiOperation(value = "Retorna os usuários páginados")
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ApiOperation(value = "Insere o usuário")
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza o usuário desejado")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,@Valid @RequestBody UserUpdateDTO dto) {
        UserDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta o usuário desejado")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
