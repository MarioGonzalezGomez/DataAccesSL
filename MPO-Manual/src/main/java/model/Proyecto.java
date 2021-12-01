package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Proyecto {
    private UUID idProyecto;
    private String nombre;
    private UUID idjefeProyecto;
    private double presupuesto;
    private Date fechaInicio;
    private Date fechaFin;

}
