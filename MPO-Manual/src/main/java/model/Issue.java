package model;

import java.sql.Date;
import java.util.List;

public class Issue {
    private int id;
    private String titulo;
    private String texto;
    private Date fecha;
    private List<String> programadores;
    private int proyecto;
    private int repositorio;

    public Issue(int id, String titulo, String texto, Date fecha, List<String> programadores, int proyecto, int repositorio) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.programadores = programadores;
        this.proyecto = proyecto;
        this.repositorio = repositorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<String> programadores) {
        this.programadores = programadores;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(int repositorio) {
        this.repositorio = repositorio;
    }
}
