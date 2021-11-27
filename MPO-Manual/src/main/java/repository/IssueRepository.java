package repository;

import model.Repositorio;

import java.sql.SQLException;
import java.util.List;

public class IssueRepository implements CrudRepository<Repositorio,Long> {
    @Override
    public List<Repositorio> findAll() throws SQLException {
        return null;
    }

    @Override
    public Repositorio getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Repositorio save(Repositorio repositorio) throws SQLException {
        return null;
    }

    @Override
    public Repositorio update(Repositorio repositorio) throws SQLException {
        return null;
    }

    @Override
    public Repositorio delete(Repositorio repositorio) throws SQLException {
        return null;
    }
}
