package model;

import java.sql.Date;

public class Commit {
    private int id;
    private String titulo;
    private String texto;
    private Date fecha;
    private int repositorio;
    private int proyecto;
    private int autor;
    private int issue;

    public Commit(int id, String titulo, String texto, Date fecha, int repositorio, int proyecto, int autor, int issue) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.repositorio = repositorio;
        this.proyecto = proyecto;
        this.autor = autor;
        this.issue = issue;
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

    public int getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(int repositorio) {
        this.repositorio = repositorio;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Commits{" +
                "id=" + id + '\'' +
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
