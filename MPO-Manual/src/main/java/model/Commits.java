package model;

import java.sql.Date;

public class Commits {
    private String titulo;
    private String texto;
    private Date fecha;
    private Repositorio repositorio;
    private Proyecto proyecto;
    private Programador autor;
    private Issue issue;


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

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Programador getAutor() {
        return autor;
    }

    public void setAutor(Programador autor) {
        this.autor = autor;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Commits{" +
                "titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", repositorio=" + repositorio +
                ", proyecto=" + proyecto +
                ", autor=" + autor +
                ", issue=" + issue +
                '}';
    }
}
