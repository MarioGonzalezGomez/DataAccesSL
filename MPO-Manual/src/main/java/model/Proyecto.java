package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Builder
@AllArgsConstructor
public class Proyecto {
    private UUID idProgramador;
    private UUID idProyecto;
    private Date fechaInicio;
    private Date fechaFin;

}
