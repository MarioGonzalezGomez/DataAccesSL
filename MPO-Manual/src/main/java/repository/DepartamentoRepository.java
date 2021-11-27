package repository;

import model.Departamento;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoRepository implements CrudRepository<Departamento, Long> {
    @Override
    public List<Departamento> findAll() throws SQLException {
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
