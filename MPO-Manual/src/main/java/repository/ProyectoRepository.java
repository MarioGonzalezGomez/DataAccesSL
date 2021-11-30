package repository;

import database.DataBaseController;
import model.Departamento;
import model.Proyecto;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoRepository implements CrudRepository<Proyecto, Long> {


    @Override
    public List<Proyecto> findAll() throws SQLException {
        String query = "SELECT *  FROM proyectos";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar registros de Proyectos"));
        ArrayList<Proyecto> list = new ArrayList<Proyecto>();
        while (result.next()) {
            list.add(
                    //Se crea una lista con el contenido de la tabla proyecto.
                    new Proyecto( //sintaxis de la bbdd
                            result.getString("nombre"),
                            result.getInt("jefeProyecto"),
                            result.getDouble("presupuesto"),
                            result.getDate("fechaInicio"),
                            result.getDate("fechaFin"),
                            result.getString("tecnologias"),
                            result.getInt("repositorio")
                    )
            );
        }
        db.close();
        return list;

    }

    @Override
    public Proyecto getById(Long ID) throws SQLException {
        String query = "SELECT * FROM proyectos WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar proyecto con ID " + ID));
        if (result.first()) {
            Proyecto proyecto = new Proyecto(
                    result.getString("nombre"),
                    result.getInt("jefeProyecto"),
                    result.getDouble("presupuesto"),
                    result.getDate("fechaInicio"),
                    result.getDate("fechaFin"),
                    result.getString("tecnologias"),
                    result.getInt("repositorio")
            );
            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoRepository no existe proyecto con ID: " + ID);
    }

    @Override
    public Proyecto save(Proyecto proyecto) throws SQLException {
        String query = "INSERT INTO proyectos VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();

        //Si mantenemos el formato con ; transformar las listas al insertar
        ResultSet result = db.insert(query, proyecto.getNombre(), proyecto.getIdJefeProyecto(),
                proyecto.getPresupuesto(), proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getTecnologias()
                , proyecto.getRepositorio()).orElseThrow(() ->
                new SQLException("Error ProyectoRepository al proyecto issue"));
        if (result.first()) {
            proyecto.setId(result.getInt(1));

            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoRepository al insertar proyecto en BBDD");
    }

    @Override
    public Proyecto update(Proyecto proyecto) throws SQLException {
        String query = "UPDATE proyectos nombre = ?, idJefeProyecto = ?, presupuesto = ?,  " +
                "fechaInicio = ?, fechaFin = ?, tecnologias = ?, repositorio = ? WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, proyecto.getNombre(), proyecto.getIdJefeProyecto(),
                proyecto.getPresupuesto(), proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getTecnologias(), proyecto.getRepositorio()
        );
        db.close();
        if (res > 0)
            return proyecto;
        else
            throw new SQLException("Error ProyectoRepository al actualizar proyecto con id: " + proyecto.getId());
    }


    @Override
    public Proyecto delete(Proyecto proyecto) throws SQLException {
        String query = "DELETE FROM proyectos WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, proyecto.getId());
        db.close();
        if (res > 0)
            return proyecto;
        else
            throw new SQLException("Error ProyectoRepository al eliminar proyecto con id: " + proyecto.getId());
    }
}
