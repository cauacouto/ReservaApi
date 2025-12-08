package com.coutodev.reservaApi.DTO;

import java.time.LocalDate;
import java.util.Optional;

public record DtoAtualizarParcial(Optional<String> nome,
                                  Optional<String> email,
                                  Optional<LocalDate>  dataDareserva,
                                  Optional<String> whatsapp) {
}
