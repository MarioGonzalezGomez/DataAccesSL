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
        String query = "SELECT *  FROM proyecto";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar registros de Proyectos"));
        ArrayList<Proyecto> list = new ArrayList<Proyecto>();
        while (result.next()) {
            list.add(
                    //Se crea una lista con todo el contenido de la tabla proyecto.
                    new Proyecto( //sintaxis de la bbdd
                            result.getString("nombre"),
                            result.getInt("jefeProyecto"),
                            result.getDouble("presupuesto"),
                            result.getDate("fechaInicio"),
                            result.getDate("fechaFin"),
                            result.getString("tecnologias"),
                            result.getString("historicoJefes")
                    )
            );
        }
        db.close();
        return list;

    }

    @Override
    public Proyecto getById(Long ID) throws SQLException {
        String query = "SELECT * FROM proyecto WHERE id = ?";
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
                    result.getString("historicoJefes")
            );
            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoRepository no existe proyecto con ID: " + ID);
    }

    @Override
    public Proyecto save(Proyecto proyecto) throws SQLException {
        return null;
    }

    @Override
    public Proyecto update(Proyecto proyecto) throws SQLException {
        return null;
    }

    @Override
    public Proyecto delete(Proyecto proyecto) throws SQLException {
        return null;
    }
}
