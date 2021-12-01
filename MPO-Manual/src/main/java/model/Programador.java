package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Programador {
    private UUID id;
    private String nombre;
    private Date fechaAlta;
    private String contraseña;
    private Double salario;
    private UUID idDepartamento;

}