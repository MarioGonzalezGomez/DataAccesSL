package repository;

import database.DataBaseController;
import model.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ProgramadorRepository implements CrudRepository<Programador, String> {

    @Override
    public List<Programador> findAll() throws SQLException {
        String query = "SELECT * FROM programador";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar registros de programadores"));
        ArrayList<Programador> list = new ArrayList<>();
        while (result.next()) {
            list.add(
                    //Se crea una lista con el contenido de la tabla programadores.

                    new Programador(
                            UUID.fromString(result.getString("id")),
                            result.getString("nombre"),
                            result.getDate("fechaAlta"),
                            result.getString("password"),
                            result.getDouble("salario"),
                            UUID.fromString(result.getString("departamento"))
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Programador getById(String ID) throws SQLException {
        String query = "SELECT * FROM programador WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, ID).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar programador con ID " + ID));
        if (result.first()) {

            Programador programmer = new Programador(
                    UUID.fromString(result.getString("id")),
                    result.getString("nombre"),
                    result.getDate("fechaAlta"),
                    result.getString("password"),
                    result.getDouble("salario"),
                    UUID.fromString(result.getString("departamento")));
            db.close();
            return programmer;
        } else
            throw new SQLException("Error ProgramadorRepository no existe programador con ID: " + ID);
    }

    @Override
    public Programador save(Programador programador) throws SQLException {
        String query = "INSERT INTO programador VALUES (?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.insert(query, programador.getId().toString(), programador.getNombre(), programador.getFechaAlta(),
                programador.getContraseña(), programador.getSalario(), programador.getIdDepartamento().toString()).orElseThrow(() ->
                new SQLException("Error ProgramadorRepository al insertar programador"));
        if (result.first()) {
            programador.setId(UUID.fromString(result.getString(1)));

            db.close();
            return programador;
        } else
            throw new SQLException("Error ProgramadorRepository al insertar programador en BBDD");
    }

    @Override
    public Programador update(Programador programador) throws SQLException {
        String query = "UPDATE programador SET nombre = ?, fechaAlta = ?, contraseña = ?,  " +
                "salario = ?, idDepartamento = ? WHERE id = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, programador.getNombre(), programador.getFechaAlta(),
                programador.getContraseña(), programador.getSalario(), programador.getIdDepartamento().toString(), programador.getId().toString());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al actualizar programador con id: " + programador.getId().toString());
    }

    @Override
    public Programador delete(Programador programador) throws SQLException {
        String query = "DELETE FROM programador WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, programador.getId().toString());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al eliminar programador con id: " + programador.getId().toString());
    }
}

