package com.coutodev.reservaApi.Service;



import com.coutodev.reservaApi.DTO.DtoAtualizarParcial;
import com.coutodev.reservaApi.DTO.DtoRequest;
import com.coutodev.reservaApi.Repository.ReservaRepository;
import com.coutodev.reservaApi.model.reserva;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private static final Logger log = LoggerFactory.getLogger(ReservaService.class);


    private final ReservaRepository repository;
    private final EmailService emailService;


    public ReservaService(ReservaRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public void CriaReserva(DtoRequest dto) {
        reserva reserva = new reserva();
        reserva.setNome(dto.nome());
        reserva.setEmail(dto.email());
        reserva.setDataDareserva(dto.DataDaReserva());
        reserva.setWhatsapp(dto.whatsapp());


        reserva reservaSalva = repository.save(reserva);

        log.info("Reserva ID {} criada com sucesso.", reservaSalva.getId());


        try {
            emailService.enviarConfirmacaoReserva(reservaSalva);
        } catch (Exception e) {

            log.error("Falha ao enviar e-mail de confirmação para reserva ID {}: {}",
                    reservaSalva.getId(), e.getMessage());
        }
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

    public void atualizarParcialmente(Integer id, DtoAtualizarParcial dto) {

        reserva exist = repository.findById(id).orElseThrow(()
                -> new RuntimeException("reserva não encontrada"));
        dto.nome().ifPresent(exist::setNome);
        dto.email().ifPresent(exist::setEmail);
        dto.dataDareserva().ifPresent(exist::setDataDareserva);
        dto.whatsapp().ifPresent(exist::setWhatsapp);

        repository.save(exist);
    }

    public List<reserva> listarReservas() {
        return repository.findAll();
    }
}
