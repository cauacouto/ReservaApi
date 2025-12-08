package com.coutodev.reservaApi.Service;

import com.coutodev.reservaApi.DTO.DtoRequest;
import com.coutodev.reservaApi.Repository.ReservaRepository;
import com.coutodev.reservaApi.model.reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public void CriaReserva(DtoRequest dto){
        reserva reserva = new reserva();
       reserva.setNome(dto.nome());
        reserva.setEmail(dto.email());
        reserva.setDataDareserva(dto.DataDaReserva());
        reserva.setWhatsapp(dto.whatsapp());
        repository.save(reserva);
    }

    public void atualizarReserva(Integer id, DtoRequest dto) {
        reserva exist = repository.findById(id).orElseThrow(
                () -> new RuntimeException("reserva não encontrada"));
        exist.setNome(dto.nome());
        exist.setEmail(dto.email());
        exist.setDataDareserva(dto.DataDaReserva());
        exist.setWhatsapp(dto.whatsapp());
        repository.save(exist);

    }
}
