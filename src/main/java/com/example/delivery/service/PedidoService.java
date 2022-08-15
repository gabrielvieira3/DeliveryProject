package com.example.delivery.service;

import com.example.delivery.dto.*;
import com.example.delivery.entities.Pedido;
import com.example.delivery.repositories.PedidoRepository;
import com.example.delivery.service.exceptions.DatabaseException;
import com.example.delivery.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Transactional(readOnly = true)
    public PedidoDTO findById(Long id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PedidoDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<PedidoDTO> findAllPaged(Pageable pageable) {
        Page<Pedido> list = pedidoRepository.findAll(pageable);
        return list.map(PedidoDTO::new);
    }

    @Transactional
    public PedidoDTO insert(PedidoDTO dto) {
        Pedido entity = new Pedido();
        copyDtoToEntity(dto, entity);
        entity = pedidoRepository.save(entity);
        return new PedidoDTO(entity);
    }

    @Transactional
    public PedidoDTO update(Long id, PedidoDTO dto) {
        try {
            Pedido entity = pedidoRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = pedidoRepository.save(entity);
            return new PedidoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            pedidoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(PedidoDTO dto, Pedido entity) {

        entity.setName(dto.getName());
        entity.setMoment(dto.getMoment());
        entity.setCorrectCount(dto.getCorrectCount());
        entity.setFeedback(dto.getFeedback());
        entity.setStatus(dto.getStatus());
    }
}
