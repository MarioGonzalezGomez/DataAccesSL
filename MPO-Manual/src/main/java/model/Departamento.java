package model;


//Las clases model deben tener los atributos de la bbdd,luego en las clases DTO se mappearan y se crearan con objetos.
public class Departamento {
    private int id;
    private String nombre;
    private int idJefeActual;
    private double presupuesto;
    private String proyectosTerminados;
    private String proyectosDesarrollo;
    private double presupuestoAnual;
    private String historicoJefes;

    public Departamento(int id, String nombre, int idJefeActual, double presupuesto, String proyectosTerminados, String proyectosDesarrollo, double presupuestoAnual, String historicoJefes) {
        this.id = id;
        this.nombre = nombre;
        this.idJefeActual = idJefeActual;
        this.presupuesto = presupuesto;
        this.proyectosTerminados = proyectosTerminados;
        this.proyectosDesarrollo = proyectosDesarrollo;
        this.presupuestoAnual = presupuestoAnual;
        this.historicoJefes = historicoJefes;
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

    public int getIdJefeActual() {
        return idJefeActual;
    }

    public void setIdJefeActual(int idJefeActual) {
        this.idJefeActual = idJefeActual;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getProyectosTerminados() {
        return proyectosTerminados;
    }

    public void setProyectosTerminados(String proyectosTerminados) {
        this.proyectosTerminados = proyectosTerminados;
    }

    public String getProyectosDesarrollo() {
        return proyectosDesarrollo;
    }

    public void setProyectosDesarrollo(String proyectosDesarrollo) {
        this.proyectosDesarrollo = proyectosDesarrollo;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public String getHistoricoJefes() {
        return historicoJefes;
    }

    public void setHistoricoJefes(String historicoJefes) {
        this.historicoJefes = historicoJefes;
    }
}


