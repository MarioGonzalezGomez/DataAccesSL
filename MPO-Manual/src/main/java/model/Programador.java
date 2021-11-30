package model;

import java.sql.Date;
import java.util.List;

public class Programador {
    private int id;
    private String name;
    private Date fechaAlta;
    private int departamento;
    private List<String> proyectos;
    private List<String> issues;
    private List<String> commits;
    private List<String> tecnologiasUsadas;
    private double salario;
    private String password;

    public Programador(int id, String name, Date fechaAlta, int departamento, List<String> proyectos, List<String> issues, List<String> commits, List<String> tecnologiasUsadas, double salario, String password) {
        this.id = id;
        this.name = name;
        this.fechaAlta = fechaAlta;
        this.departamento = departamento;
        this.proyectos = proyectos;
        this.issues = issues;
        this.commits = commits;
        this.tecnologiasUsadas = tecnologiasUsadas;
        this.salario = salario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public List<String> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<String> proyectos) {
        this.proyectos = proyectos;
    }

    public List<String> getIssues() {
        return issues;
    }

    public void setIssues(List<String> issues) {
        this.issues = issues;
    }

    public List<String> getCommits() {
        return commits;
    }

    public void setCommits(List<String> commits) {
        this.commits = commits;
    }

    public List<String> getTecnologiasUsadas() {
        return tecnologiasUsadas;
    }

    public void setTecnologiasUsadas(List<String> tecnologiasUsadas) {
        this.tecnologiasUsadas = tecnologiasUsadas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "name='" + name + '\'' +
                ", fecha_alta=" + fechaAlta +
                ", departamento=" + departamento +
                ", proyectos=" + proyectos +
                ", issues=" + issues +
                ", tecnologias_usadas='" + tecnologiasUsadas + '\'' +
                ", salario=" + salario +
                ", contraseña='" + password + '\'' +
                '}';
    }
}


