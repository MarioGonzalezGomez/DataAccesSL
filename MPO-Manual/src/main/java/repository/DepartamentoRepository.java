package repository;

import database.DataBaseController;
import model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepository implements CrudRepository<Departamento, Long> {
    @Override
    public List<Departamento> findAll() throws SQLException {
        String query = "SELECT *  FROM departamento";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error DepartamentoRepository al consultar registros de Departamentos"));
        ArrayList<Departamento> list = new ArrayList<Departamento>();
        while (result.next()) {
            list.add(
                    //Se crea una lista con todo el contenido de la tabla departamento.
                    new Departamento( //sintaxis de la bbdd
                            result.getInt("id"),
                            result.getString("nombre"),
                            result.getInt("jefeActual"),
                            result.getDouble("presupuesto"),
                            result.getString("proyectosTerminados"),
                            result.getString("proyectosEnDesarrollo"),
                            result.getDouble("presupuestoAnual"),
                            result.getString("historicoJefes")
                    )
            );
        }
        db.close();
        return list;
    }


    @Override
    public Departamento getById(Long ID) throws SQLException {
        String query = "SELECT * FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error PostRepository al consultar post con ID " + ID));
        if (result.first()) {
            Departamento departamento = new Departamento(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getInt("jefeActual"),
                    result.getDouble("presupuesto"),
                    result.getString("proyectosTerminados"),
                    result.getString("proyectosEnDesarrollo"),
                    result.getDouble("presupuestoAnual"),
                    result.getString("historicoJefes")
            );
            db.close();
            return departamento;
        } else
            throw new SQLException("Error DepartamentoRepository no existe departamento con ID: " + ID);
    }

    @Override
    public Departamento save(Departamento departamento) throws SQLException {
        String query = "INSERT INTO departamento VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        // departamento.getId(),
        ResultSet result = db.insert(query, departamento.getNombre(), departamento.getIdJefeActual(),
                departamento.getPresupuesto(), departamento.getProyectosTerminados(),
                departamento.getProyectosDesarrollo(), departamento.getPresupuestoAnual(), departamento.getHistoricoJefes()).orElseThrow(() -> new SQLException("Error DepartamentoRepository al insertar Departamento"));
        // Para obtener su ID
        if (result.first()) {
            departamento.setId(result.getInt(1));
            // una vez insertado comprobamos que está correcto para devolverlo
            db.close();
            return departamento;
        } else
            throw new SQLException("Error DepartamentoRepository al insertar Departamento en BBDD");
    }


    @Override
    public Departamento update(Departamento departamento) throws SQLException {
        String query = "UPDATE departamento nombre = ?, idJefeActual = ?, presupuesto = ?,  " +
                "proyectosTerminados = ?, proyectosDesarrollo = ?, presupuestoAnual = ?, historicoJefes = ?  WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, departamento.getNombre(), departamento.getIdJefeActual(),
                departamento.getPresupuesto(), departamento.getProyectosTerminados(),
                departamento.getProyectosDesarrollo(), departamento.getPresupuestoAnual(), departamento.getHistoricoJefes(), departamento.getId());
        db.close();
        if (res > 0)
            return departamento;
        else
            throw new SQLException("Error DepartamentoRepository al actualizar departamento con id: " + departamento.getId());
    }

    @Override
    public Departamento delete(Departamento departamento) throws SQLException {
        String query = "DELETE FROM departamento WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, departamento.getId());
        db.close();
        if (res > 0)
            return departamento;
        else
            throw new SQLException("Error DepartamentoRepository al eliminar departamento con id: " + departamento.getId());
    }
}
