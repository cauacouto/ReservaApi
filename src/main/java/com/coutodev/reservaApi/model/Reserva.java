package com.coutodev.reservaApi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity()
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true,nullable = false)
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDareserva;
    @Column(nullable = false)
    private String whatsapp;

}
