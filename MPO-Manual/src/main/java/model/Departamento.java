package model;

import java.util.List;
import java.util.Objects;


//Las clases model deben tener los atributos de la bbdd,luego en las clases DTO se mappearan y se crearan con objetos.
public class Departamento {
    private int id;
    private String nombre;
    private int id_jefeActual;
    private double presupuesto;
    private String proyectos_terminados;
    private String getProyectos_desarrollo;
    private double presupuesto_anual;
    private String historico_jefes;

    public Departamento(int id, String nombre, int id_jefeActual, double presupuesto, String proyectos_terminados, String getProyectos_desarrollo, double presupuesto_anual, String historico_jefes) {
        this.id = id;
        this.nombre = nombre;
        this.id_jefeActual = id_jefeActual;
        this.presupuesto = presupuesto;
        this.proyectos_terminados = proyectos_terminados;
        this.getProyectos_desarrollo = getProyectos_desarrollo;
        this.presupuesto_anual = presupuesto_anual;
        this.historico_jefes = historico_jefes;
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

    public int getId_jefeActual() {
        return id_jefeActual;
    }

    public void setId_jefeActual(int id_jefeActual) {
        this.id_jefeActual = id_jefeActual;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getProyectos_terminados() {
        return proyectos_terminados;
    }

    public void setProyectos_terminados(String proyectos_terminados) {
        this.proyectos_terminados = proyectos_terminados;
    }

    public String getGetProyectos_desarrollo() {
        return getProyectos_desarrollo;
    }

    public void setGetProyectos_desarrollo(String getProyectos_desarrollo) {
        this.getProyectos_desarrollo = getProyectos_desarrollo;
    }

    public double getPresupuesto_anual() {
        return presupuesto_anual;
    }

    public void setPresupuesto_anual(double presupuesto_anual) {
        this.presupuesto_anual = presupuesto_anual;
    }

    public String getHistorico_jefes() {
        return historico_jefes;
    }

    public void setHistorico_jefes(String historico_jefes) {
        this.historico_jefes = historico_jefes;
    }
}


