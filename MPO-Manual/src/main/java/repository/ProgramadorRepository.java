package repository;

import database.DataBaseController;
import model.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorRepository implements CrudRepository<Programador, Long> {

    @Override
    public List<Programador> findAll() throws SQLException {
        String query = "SELECT * FROM programadores";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar registros de programadores"));
        ArrayList<Programador> list = new ArrayList<>();
        while (result.next()) {
            List<String> issues = Arrays.stream(result.getString("issues").split(";")).collect(Collectors.toList());
            List<String> proyecto = Arrays.stream(result.getString("proyecto").split(";")).collect(Collectors.toList());
            List<String> commits = Arrays.stream(result.getString("commits").split(";")).collect(Collectors.toList());
            List<String> tecnologias = Arrays.stream(result.getString("tecnologias").split(";")).collect(Collectors.toList());

            list.add(
                    //Se crea una lista con el contenido de la tabla programadores.

                    new Programador(
                            result.getInt("id"),
                            result.getString("nombre"),
                            result.getDate("fechaAlta"),
                            result.getInt("departamento"),
                            proyecto,
                            commits,
                            issues,
                            tecnologias,
                            result.getDouble("salario"),
                            result.getString("password")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Programador getById(Long ID) throws SQLException {
        String query = "SELECT * FROM programadores WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar programador con ID " + ID));
        if (result.first()) {
            List<String> issues = Arrays.stream(result.getString("issues").split(";")).collect(Collectors.toList());
            List<String> proyecto = Arrays.stream(result.getString("proyecto").split(";")).collect(Collectors.toList());
            List<String> commits = Arrays.stream(result.getString("commits").split(";")).collect(Collectors.toList());
            List<String> tecnologias = Arrays.stream(result.getString("tecnologias").split(";")).collect(Collectors.toList());
            Programador programmer = new Programador(result.getInt("id"),
                    result.getString("nombre"),
                    result.getDate("fechaAlta"),
                    result.getInt("departamento"),
                    proyecto,
                    commits,
                    issues,
                    tecnologias,
                    result.getDouble("salario"),
                    result.getString("password"));
            db.close();
            return programmer;
        } else
            throw new SQLException("Error ProgramadorRepository no existe programador con ID: " + ID);
    }

    @Override
    public Programador save(Programador programador) throws SQLException {
        String query = "INSERT INTO programadores VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        // programador.getId(),
        ResultSet result = db.insert(query, programador.getName(), programador.getFechaAlta(),
                programador.getDepartamento(), programador.getProyectos(), programador.getCommits(), programador.getIssues(),
                programador.getTecnologiasUsadas(), programador.getSalario(), programador.getPassword()).orElseThrow(() ->
                new SQLException("Error ProgramadorRepository al insertar programador"));
        if (result.first()) {
            programador.setId(result.getInt(1));

            db.close();
            return programador;
        } else
            throw new SQLException("Error ProgramadorRepository al insertar programador en BBDD");
    }

    @Override
    public Programador update(Programador programador) throws SQLException {
        String query = "UPDATE programadores nombre = ?, fechaAlta = ?, departamento = ?,  " +
                "proyecto = ?, commits = ?, issues = ?, tecnologias = ?, salario = ?, password = ? WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, programador.getName(), programador.getFechaAlta(),
                programador.getDepartamento(), programador.getProyectos(), programador.getCommits(), programador.getIssues(),
                programador.getTecnologiasUsadas(), programador.getSalario(), programador.getPassword(), programador.getId());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al actualizar programador con id: " + programador.getId());
    }

    @Override
    public Programador delete(Programador programador) throws SQLException {
        String query = "DELETE FROM programadores WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, programador.getId());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al eliminar programador con id: " + programador.getId());
    }
}

