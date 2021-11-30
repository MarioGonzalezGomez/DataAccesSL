package repository;

import database.DataBaseController;
import model.Commit;
import model.Issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommitsRepository implements CrudRepository<Commit, Long> {
    @Override
    public List<Commit> findAll() throws SQLException {
        String query = "SELECT * FROM commits";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error CommitRepository al consultar registros de commit"));
        ArrayList<Commit> list = new ArrayList<>();
        while (result.next()) {

            list.add(
                    //Se crea una lista con el contenido de la tabla issues.

                    new Commit(

                            result.getInt("id"),
                            result.getString("titulo"),
                            result.getString("texto"),
                            result.getDate("fecha"),
                            result.getInt("repositorio"),
                            result.getInt("proyecto"),
                            result.getInt("autor"),
                            result.getInt("issue")

                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Commit getById(Long ID) throws SQLException {
        String query = "SELECT * FROM commits WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error CommitRepository al consultar commit con ID " + ID));
        if (result.first()) {

            Commit commit = new Commit(
                    result.getInt("id"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getDate("fecha"),
                    result.getInt("repositorio"),
                    result.getInt("proyecto"),
                    result.getInt("autor"),
                    result.getInt("issue")
            );
            db.close();
            return commit;
        } else
            throw new SQLException("Error CommitRepository no existe commit con ID: " + ID);
    }

    @Override
    public Commit save(Commit commits) throws SQLException {
        String query = "INSERT INTO commits VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();

        //Si mantenemos el formato con ; transformar las listas al insertar
        ResultSet result = db.insert(query, commits.getTitulo(), commits.getTexto(),
                commits.getFecha(), commits.getRepositorio(), commits.getProyecto(), commits.getAutor(),
                commits.getIssue()
        ).orElseThrow(() ->
                new SQLException("Error CommitRepository al insertar commit"));
        if (result.first()) {
            commits.setId(result.getInt(1));

            db.close();
            return commits;
        } else
            throw new SQLException("Error CommitRepository al insertar commit en BBDD");
    }

    @Override
    public Commit update(Commit commits) throws SQLException {
        String query = "UPDATE commits titulo = ?, texto = ?, fecha = ?,  " +
                "repositorio = ?, proyecto = ?, autor = ?, issue = ? WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, commits.getTitulo(), commits.getTexto(),
                commits.getFecha(), commits.getRepositorio(), commits.getProyecto(), commits.getAutor(),
                commits.getIssue(), commits.getId()
        );
        db.close();
        if (res > 0)
            return commits;
        else
            throw new SQLException("Error CommitRepository al actualizar commit con id: " + commits.getId());
    }

    @Override
    public Commit delete(Commit commits) throws SQLException {
        String query = "DELETE FROM commits WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, commits.getId());
        db.close();
        if (res > 0)
            return commits;
        else
            throw new SQLException("Error CommitRepository al eliminar commit con id: " + commits.getId());
    }
}
