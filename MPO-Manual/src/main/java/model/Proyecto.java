package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
<<<<<<< HEAD
=======
import java.util.UUID;
>>>>>>> develop

@Data
@Builder
@AllArgsConstructor
public class Proyecto {
<<<<<<< HEAD
    private int id;
    private String nombre;
    private int idJefeProyecto;
    private double presupuesto;
    private Date fechaInicio;
    private Date fechaFin;
    private String tecnologias;
    private int repositorio;

    public Proyecto(String nombre, int idJefeProyecto, double presupuesto, Date fechaInicio, Date fechaFin, String tecnologias, int repositorio) {
        this.nombre = nombre;
        this.idJefeProyecto = idJefeProyecto;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.repositorio = repositorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdJefeProyecto() {
        return idJefeProyecto;
    }

    public void setIdJefeProyecto(int idJefeProyecto) {
        this.idJefeProyecto = idJefeProyecto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTecnologias() {
        return tecnologias;
    }
=======

   private UUID idProgramador;
   private UUID idProyecto;
   private Date fechaInicio;
   private Date fechaFin;

>>>>>>> develop


<<<<<<< HEAD
    public int getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(int repositorio) {
        this.repositorio = repositorio;
    }
}
=======

}
>>>>>>> develop
