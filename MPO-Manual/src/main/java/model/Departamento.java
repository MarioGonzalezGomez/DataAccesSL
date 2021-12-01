package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Departamento {
    private UUID id;
    private String name;
    private UUID idJefeDepartamento;
    private Double presupuesto;
    private Double presupuestoAnual;


}


