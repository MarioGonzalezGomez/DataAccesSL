package repository;

import database.DataBaseController;
import model.Proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProyectoRepository implements CrudRepository <Proyecto,String> {
    @Override
    public List<Proyecto> findAll() throws SQLException {
        String query = "SELECT *  FROM proyecto";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar registros de Proyectos"));
        ArrayList<Proyecto> list = new ArrayList<Proyecto>();
        while (result.next()) {
            list.add(
                    new Proyecto(
                            UUID.fromString(result.getString("id")),
                            result.getString("nombre"),
                            UUID.fromString(result.getString("jefeProyecto")),
                            result.getDouble("presupuesto"),
                            result.getDate("fechaInicio"),
                            result.getDate("fechaFin")
                    )
            );
        }
        db.close();
        return list;

    }

    @Override
    public Proyecto getById(String ID) throws SQLException {
        String query = "SELECT * FROM proyecto WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar proyecto con ID " + ID));
        if (result.first()) {
            Proyecto proyecto = new Proyecto(
                    UUID.fromString(result.getString("id")),
                    result.getString("nombre"),
                    UUID.fromString(result.getString("jefeProyecto")),
                    result.getDouble("presupuesto"),
                    result.getDate("fechaInicio"),
                    result.getDate("fechaFin")
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
