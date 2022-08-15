package com.example.delivery.dto;

import com.example.delivery.entities.Entrega;

import java.io.Serializable;
import java.util.Objects;

public class EntregaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double price;
    private String produto;
    private String descricao;

    public EntregaDTO(){
    }

    public EntregaDTO(Long id, Double price, String produto, String descricao) {
        this.id = id;
        this.price = price;
        this.produto = produto;
        this.descricao = descricao;
    }

    public EntregaDTO(Entrega entity){
        id = entity.getId();
        price = entity.getPrice();
        produto = entity.getProduto();
        descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntregaDTO that = (EntregaDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
