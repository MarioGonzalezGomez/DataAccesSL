package repository;

import database.DataBaseController;
import model.Departamento;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoRepository implements CrudRepository<Departamento, Long> {
    @Override
    public List<Departamento> findAll() throws SQLException {
        String query = "SELECT *  FROM departamento";
        DataBaseController db = DataBaseController.getInstance();




        return null;
    }

    @Override
    public Departamento getById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public Departamento save(Departamento departamento) throws SQLException {
        return null;
    }

    @Override
    public Departamento update(Departamento departamento) throws SQLException {
        return null;
    }

    @Override
    public Departamento delete(Departamento departamento) throws SQLException {
        return null;
    }
}
