package model;

import java.sql.Date;
import java.util.List;

public class Repositorio {
    private String nombre;
    private Date fecha_creacion;
    private Proyecto proyecto;
    private List<Commits> commits;
    private List<Issue>issues;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Commits> getCommits() {
        return commits;
    }

    public void setCommits(List<Commits> commits) {
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
                "nombre='" + nombre + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", proyecto=" + proyecto +
                ", commits=" + commits +
                ", issues=" + issues +
                '}';
    }
}
