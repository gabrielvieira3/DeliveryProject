package com.example.delivery.service;

import com.example.delivery.dto.EntregaDTO;
import com.example.delivery.entities.Entrega;
import com.example.delivery.repositories.EntregaRepository;
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
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional(readOnly = true)
    public EntregaDTO findById(Long id) {
        Optional<Entrega> obj = entregaRepository.findById(id);
        Entrega entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new EntregaDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<EntregaDTO> findAllPaged(Pageable pageable) {
        Page<Entrega> list = entregaRepository.findAll(pageable);
        return list.map(EntregaDTO::new);
    }

    @Transactional
    public EntregaDTO insert(EntregaDTO dto) {
        Entrega entity = new Entrega();
        copyDtoToEntity(dto, entity);
        entity = entregaRepository.save(entity);
        return new EntregaDTO(entity);
    }

    @Transactional
    public EntregaDTO update(Long id, EntregaDTO dto) {
        try {
            Entrega entity = entregaRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = entregaRepository.save(entity);
            return new EntregaDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            entregaRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(EntregaDTO dto, Entrega entity) {

        entity.setPrice(dto.getPrice());
        entity.setProduto(dto.getProduto());
        entity.setDescricao(dto.getDescricao());
    }
}
