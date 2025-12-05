package com.coutodev.reservaApi.Repository;

import com.coutodev.reservaApi.model.reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<reserva,Integer> {
}
