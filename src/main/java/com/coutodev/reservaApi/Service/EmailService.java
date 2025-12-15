package com.coutodev.reservaApi.Service;

import com.coutodev.reservaApi.model.reserva;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class EmailService {


    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public EmailService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }
    public void enviarConfirmacaoReserva(reserva reserva){
        String destinatario = reserva.getEmail();
        String nomeCliente = reserva.getNome();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = reserva.getDataDareserva().format(formatter);


        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(remetente);
        message.setTo(destinatario);
        message.setSubject("[Reserva Confirmada] Obrigado por reservar, #" + reserva.getId());

        String corpo = String.format(
                "Olá %s,\n\nSua reserva de ID #%d foi confirmada com sucesso!\n\nDetalhes da sua reserva:\n" +
                        "Data da Reserva: %s\n" +
                        "WhatsApp para contato: %s\n\n" +
                        "Aguardamos você!\n\nAtenciosamente,\nEquipe ReservaApi",
                nomeCliente,
                reserva.getId(),
                dataFormatada,
                reserva.getWhatsapp()
        );
        message.setText(corpo);

        try {
            mailSender.send(message);
            log.info("E-mail de confirmação enviado com sucesso para: {}", destinatario);
        }catch (Exception e){
            log.error("Falha ao enviar e-mail de confirmação para {}: {}", destinatario, e.getMessage(), e);
        }



    }
}
