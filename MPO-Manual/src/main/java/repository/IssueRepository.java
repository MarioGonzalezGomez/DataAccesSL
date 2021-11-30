package repository;

import database.DataBaseController;
import model.Issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IssueRepository implements CrudRepository<Issue, Long> {

    @Override
    public List<Issue> findAll() throws SQLException {
        String query = "SELECT * FROM issues";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error IssueRepository al consultar registros de issues"));
        ArrayList<Issue> list = new ArrayList<>();
        while (result.next()) {
            List<String> programadores = Arrays.stream(result.getString("programadores").split(";")).collect(Collectors.toList());

            list.add(
                    //Se crea una lista con el contenido de la tabla issues.

                    new Issue(
                            result.getInt("id"),
                            result.getString("titulo"),
                            result.getString("texto"),
                            result.getDate("fecha"),
                            programadores,
                            result.getInt("proyecto"),
                            result.getInt("repositorio")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Issue getById(Long ID) throws SQLException {
        String query = "SELECT * FROM issues WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error IssueRepository al consultar issue con ID " + ID));
        if (result.first()) {
            List<String> programadores = Arrays.stream(result.getString("programadores").split(";")).collect(Collectors.toList());

            Issue issue = new Issue(
                    result.getInt("id"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getDate("fecha"),
                    programadores,
                    result.getInt("proyecto"),
                    result.getInt("repositorio")
            );
            db.close();
            return issue;
        } else
            throw new SQLException("Error IssueRepository no existe issue con ID: " + ID);
    }

    @Override
    public Issue save(Issue issue) throws SQLException {
        String query = "INSERT INTO issues VALUES (null, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        //issue.getId()
        //Si mantenemos el formato con ; transformar las listas al insertar
        ResultSet result = db.insert(query, issue.getTitulo(), issue.getTexto(),
                issue.getFecha(), issue.getProgramadores(), issue.getProyecto(), issue.getRepositorio()
        ).orElseThrow(() ->
                new SQLException("Error IssueRepository al insertar issue"));
        if (result.first()) {
            issue.setId(result.getInt(1));

            db.close();
            return issue;
        } else
            throw new SQLException("Error IssueRepository al insertar issue en BBDD");
    }

    @Override
    public Issue update(Issue issue) throws SQLException {
        String query = "UPDATE issues titulo = ?, texto = ?, fecha = ?,  " +
                "programadores = ?, proyecto = ?, repositorio = ? WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, issue.getTitulo(), issue.getTexto(),
                issue.getFecha(), issue.getProgramadores(), issue.getProyecto(), issue.getRepositorio(), issue.getId()
        );
        db.close();
        if (res > 0)
            return issue;
        else
            throw new SQLException("Error IssueRepository al actualizar issue con id: " + issue.getId());
    }

    @Override
    public Issue delete(Issue issue) throws SQLException {
        String query = "DELETE FROM issues WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, issue.getId());
        db.close();
        if (res > 0)
            return issue;
        else
            throw new SQLException("Error IssueRepository al eliminar issue con id: " + issue.getId());
    }
}
