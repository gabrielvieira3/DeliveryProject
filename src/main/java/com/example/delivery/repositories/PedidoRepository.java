package com.example.delivery.repositories;

import com.example.delivery.entities.Pedido;
import com.example.delivery.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
