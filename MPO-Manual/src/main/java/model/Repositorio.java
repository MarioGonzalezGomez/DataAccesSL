package model;

import java.sql.Date;
import java.util.List;

public class Repositorio {
    private int id;
    private String nombre;
    private Date fechaCreacion;
    private Proyecto proyecto;
    private List<Commit> commits;
    private List<Issue> issues;

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "id=" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", fecha de creacion=" + fechaCreacion +
                ", proyecto=" + proyecto +
                ", commits=" + commits +
                ", issues=" + issues +
                '}';
    }
}
