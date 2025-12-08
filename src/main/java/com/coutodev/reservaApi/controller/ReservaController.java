package com.coutodev.reservaApi.controller;

import com.coutodev.reservaApi.DTO.DtoAtualizarParcial;
import com.coutodev.reservaApi.DTO.DtoRequest;
import com.coutodev.reservaApi.Service.ReservaService;
import com.coutodev.reservaApi.model.reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Void> criaReserva(@RequestBody DtoRequest dto) {
        reservaService.CriaReserva(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoRequest> atualizarReserva(@RequestBody @PathVariable(name = "id") Integer id, DtoRequest dto) {
        reservaService.atualizarReserva(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DtoAtualizarParcial> atualizarReservaParcial(@RequestBody @PathVariable(name = "id") Integer id, DtoAtualizarParcial dto) {
        reservaService.atualizarParcialmente(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<reserva>> listarReserva(){
        return ResponseEntity.ok(reservaService.listarReservas());
    }
}
