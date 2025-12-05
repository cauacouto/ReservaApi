package com.coutodev.reservaApi.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@NotBlank(message = "o nome não pode ser nulo")
public record DtoRequest(String nome,
                         @NotBlank(message = "o email não pode ser nulo")
                         String email,
                         @NotNull
                         @JsonFormat(pattern = "dd/MM/yyyy")
                         LocalDate DataDaReserva,
                         @NotNull
                         @Pattern(regexp = "\\d{9}",message = "informe um número de telefone válido")
                         String whatsapp) {
}
