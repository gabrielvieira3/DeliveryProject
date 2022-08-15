package com.example.delivery.dto;

import com.example.delivery.entities.Pedido;
import com.example.delivery.entities.enums.PedidoStatus;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Objects;

public class PedidoDTO {

    private Long id;
    private String name;

    private Instant moment;

    private PedidoStatus status;
    private String feedback;
    private Integer correctCount;

    public PedidoDTO(){
    }

    public PedidoDTO(Long id, String name, Instant moment, PedidoStatus status, String feedback, Integer correctCount) {
        this.id = id;
        this.name = name;
        this.moment = moment;
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
    }


    public PedidoDTO(Pedido entity) {
        id = entity.getId();
        name = entity.getName();
        moment = entity.getMoment();
        status = entity.getStatus();
        feedback = entity.getFeedback();
        correctCount = entity.getCorrectCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDTO pedidoDTO = (PedidoDTO) o;
        return Objects.equals(id, pedidoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
