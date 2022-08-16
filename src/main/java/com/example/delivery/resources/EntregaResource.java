package com.example.delivery.resources;

import com.example.delivery.dto.EntregaDTO;
import com.example.delivery.service.EntregaService;
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
@RequestMapping(value = "/entregas")
@Api(value = "API REST Entregas")
@CrossOrigin(origins = "*")
public class EntregaResource {

    @Autowired
    private EntregaService entregaService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna a entrega desejada")
    public ResponseEntity<EntregaDTO> findById(@PathVariable Long id){
        EntregaDTO entregaDTO = entregaService.findById(id);
        return ResponseEntity.ok(entregaDTO);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma pagina de entregas")
    public ResponseEntity<Page<EntregaDTO>> findAll(Pageable pageable) {
        Page<EntregaDTO> list = entregaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ApiOperation(value = "Insere uma entrega")
    public ResponseEntity<EntregaDTO> insert(@Valid @RequestBody EntregaDTO dto) {
        EntregaDTO newDto = entregaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza uma entrega")
    public ResponseEntity<EntregaDTO> update(@PathVariable Long id,@Valid @RequestBody EntregaDTO dto) {
        EntregaDTO newDto = entregaService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma entrega")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entregaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
