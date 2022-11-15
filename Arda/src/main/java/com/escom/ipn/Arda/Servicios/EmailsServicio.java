package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.DTO.MESSAGES;
import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Repositorios.IUsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmailsServicio {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IUsuariosRepositorio repositorioUsuarios;
    @Value("${email.username}")
    private String from;

    public void sendAlert(String alertTypeS, Terrarios terrario) {
        
        int alertType=Integer.parseInt(alertTypeS);
        if(alertType==0){
            return;
        }
        Optional<Usuarios> user = repositorioUsuarios.findById(terrario.getUsuarios_id());
        String nombre = user.get().getNombre();
        SimpleMailMessage correo = new SimpleMailMessage();
        String message = "";
        switch (alertType) {
            case 1:
                message = MESSAGES.DESCRIPCION_TEMPERATURA_ALTA;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_TEMPERATURA);
                
                correo.setText(message);
                break;
            case 2:
                break;
        }
        mailSender.send(correo);
    }
}
