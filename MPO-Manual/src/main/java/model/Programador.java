package model;

import java.sql.Date;
import java.util.List;

public class Programador {
    private String name;
    private Date fecha_alta;
    private Departamento departamento;
    private List<Proyecto> proyectos;
    private List<Issue> issues;
    private String tecnologias_usadas;
    private double salario;
    private String contraseña;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getTecnologias_usadas() {
        return tecnologias_usadas;
    }

    public void setTecnologias_usadas(String tecnologias_usadas) {
        this.tecnologias_usadas = tecnologias_usadas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "name='" + name + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", departamento=" + departamento +
                ", proyectos=" + proyectos +
                ", issues=" + issues +
                ", tecnologias_usadas='" + tecnologias_usadas + '\'' +
                ", salario=" + salario +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}


