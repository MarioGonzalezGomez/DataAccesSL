package model;

import java.sql.Date;
import java.util.List;

public class Proyecto {
    private int id;
    private String nombre;
    private int id_jefeProyecto;
    private double presupuesto;
    private Date fechaInicio;
    private Date fechaFin;
    private String tecnologias;
    private String repositorio;

    public Proyecto(String nombre, int id_jefeProyecto, double presupuesto, Date fechaInicio, Date fechaFin, String tecnologias, String repositorio) {
        this.nombre = nombre;
        this.id_jefeProyecto = id_jefeProyecto;
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

    public int getId_jefeProyecto() {
        return id_jefeProyecto;
    }

    public void setId_jefeProyecto(int id_jefeProyecto) {
        this.id_jefeProyecto = id_jefeProyecto;
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

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }
}
