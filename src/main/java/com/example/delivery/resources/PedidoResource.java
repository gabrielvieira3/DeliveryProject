package com.example.delivery.resources;

import com.example.delivery.dto.PedidoDTO;
import com.example.delivery.service.PedidoService;
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
@RequestMapping(value = "/pedidos")
@Api(value = "API REST Pedido")
@CrossOrigin(origins = "*")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna um pedido desejado")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
        PedidoDTO pedidoDTO = pedidoService.findById(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping
    @ApiOperation(value = "Retorna vários pedidos páginados")
    public ResponseEntity<Page<PedidoDTO>> findAll(Pageable pageable) {
        Page<PedidoDTO> list = pedidoService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ApiOperation(value = "Insere um pedido")
    public ResponseEntity<PedidoDTO> insert(@Valid @RequestBody PedidoDTO dto) {
        PedidoDTO newDto = pedidoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza o pedido desejado")
    public ResponseEntity<PedidoDTO> update(@PathVariable Long id,@Valid @RequestBody PedidoDTO dto) {
        PedidoDTO newDto = pedidoService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta o pedido desejado")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
