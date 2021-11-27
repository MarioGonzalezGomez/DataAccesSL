package model;

import java.sql.Date;
import java.util.List;

public class Proyecto {
    private Programador jefe_proyecto;
    private String nombre;
    private double presupuesto;
    private Date fecha_inicio;
    private Date fecha_fin;
    private List<String>tecnologias;
    private Repositorio repositorio;


    public Programador getJefe_proyecto() {
        return jefe_proyecto;
    }

    public void setJefe_proyecto(Programador jefe_proyecto) {
        this.jefe_proyecto = jefe_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "jefe_proyecto=" + jefe_proyecto +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", tecnologias=" + tecnologias +
                ", repositorio=" + repositorio +
                '}';
    }
}
