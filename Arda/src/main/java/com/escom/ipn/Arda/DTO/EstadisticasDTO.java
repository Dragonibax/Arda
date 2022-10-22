package com.escom.ipn.Arda.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstadisticasDTO {
    private String terrario_id;
    private float humedad;
    private String hora;
    private float temperatura;
    private int tipo_alerta;
}
