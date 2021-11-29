package repository;

import model.Commits;

import java.sql.SQLException;
import java.util.List;

public class CommitsRepository implements CrudRepository<Commits,Long>{
    @Override
    public List<Commits> findAll() throws SQLException {
        return null;
    }

    @Override
    public Commits getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Commits save(Commits commits) throws SQLException {
        return null;
    }

    @Override
    public Commits update(Commits commits) throws SQLException {
        return null;
    }

    @Override
    public Commits delete(Commits commits) throws SQLException {
        return null;
    }
}
