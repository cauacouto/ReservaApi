package com.coutodev.reservaApi.Repository;

import com.coutodev.reservaApi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
