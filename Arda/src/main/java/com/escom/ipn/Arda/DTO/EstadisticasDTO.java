package com.escom.ipn.Arda.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstadisticasDTO {
    private String terrario_id;
    private String humedad;
    private String hora;
    private String temperatura;
    private String tipo_alerta;
}
