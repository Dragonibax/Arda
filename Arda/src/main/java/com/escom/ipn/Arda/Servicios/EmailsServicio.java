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
        // 0 para todo bien
        // 1 para temperatura muy alta
        // 2 Para humedad muy alta
        // 3 Temperatura muy baja
        // 4 Humedad muy baja
        // 5 la medicion de temperatura vario mucho
        // 6 la medicion de humedad vario mucho
            
            case 1:
                message = MESSAGES.DESCRIPCION_TEMPERATURA_ALTA;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_TEMPERATURA_A);                
                correo.setText(message);
                break;
                
            case 2:
                message = MESSAGES.DESCRIPCION_HUMEDAD_ALTA;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_HUMEDAD_A);                
                correo.setText(message);
                break;
                
            case 3:
                message = MESSAGES.DESCRIPCION_TEMPERATURA_BAJA;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_TEMPERATURA_B);                
                correo.setText(message);
                break;
                
            case 4:
                message = MESSAGES.DESCRIPCION_HUMEDAD_BAJA;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_HUMEDAD_B);                
                correo.setText(message);
                break;
            
            case 5:
                message = MESSAGES.DESCRIPCION_TEMPERATURA_SENSOR;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_TEMPERATURA_C);                
                correo.setText(message);
                break;
                
            case 6:
                message = MESSAGES.DESCRIPCION_HUMEDAD_SENSOR;
                message = String.format(message,nombre);
                correo.setFrom(from);
                correo.setTo(user.get().getCorreo());
                correo.setSubject(MESSAGES.ALERTA_HUMEDAD_C);                
                correo.setText(message);
                break;    
        }
        mailSender.send(correo);
    }
}
