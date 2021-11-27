package dao;

import java.util.List;
import java.util.Objects;

public class Departamento {
    private String nombre;
    private Programador jefeDepartamento;
    private double presupuesto;
    private List<Proyecto> proyectos_desarrollo;
    private List<Proyecto>proyectos_terminados;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Programador getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Programador jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Proyecto> getProyectos_desarrollo() {
        return proyectos_desarrollo;
    }

    public void setProyectos_desarrollo(List<Proyecto> proyectos_desarrollo) {
        this.proyectos_desarrollo = proyectos_desarrollo;
    }

    public List<Proyecto> getProyectos_terminados() {
        return proyectos_terminados;
    }

    public void setProyectos_terminados(List<Proyecto> proyectos_terminados) {
        this.proyectos_terminados = proyectos_terminados;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", jefeDepartamento=" + jefeDepartamento +
                ", presupuesto=" + presupuesto +
                ", proyectos_desarrollo=" + proyectos_desarrollo +
                ", proyectos_terminados=" + proyectos_terminados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Double.compare(that.presupuesto, presupuesto) == 0 && nombre.equals(that.nombre) && jefeDepartamento.equals(that.jefeDepartamento) && proyectos_desarrollo.equals(that.proyectos_desarrollo) && proyectos_terminados.equals(that.proyectos_terminados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, jefeDepartamento, presupuesto, proyectos_desarrollo, proyectos_terminados);
    }
}
