package factories.implementations.postgresql;

import connections.PostgreSQL;
import models.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonaDao implements factories.interfaces.PersonaDao {

    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override
    public void create(Persona obj) {
        try {
            PostgreSQL conexion = PostgreSQL.getInstance();
            ps = conexion.getConn().prepareStatement(Persona.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getDomicilio());
            ps.setInt(i++, obj.getTelefono());
            ps.setString(i++, obj.getEmail());
            ps.setDate(i++, (Date) obj.getFechaNacimiento());
            ps.setString(i++, obj.getGenero().getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Error al crear persona");
        }
    }

    @Override
    public List<Persona> read(String criteria) {
        List<Persona> personas = new ArrayList<>();
        try {
            PostgreSQL conexion = PostgreSQL.getInstance();
            st = conexion.getConn().createStatement();
            rs = st.executeQuery(String.format("%s %s", Persona.Q_ALL, criteria));
            while(rs.next()){
                personas.add(makePersona(rs));
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Error al leer personas");
        }
        return personas;
    }

    @Override
    public Persona read(Long id) {
        Persona persona = null;
        try {
            Connection conexion = PostgreSQL.getInstance().getConn();
            st = ((Connection) conexion).createStatement();
            rs = st.executeQuery(String.format("%s %s", Persona.Q_BY_ID, id));
        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Error al leer persona");
        }
        return persona;
    }

    @Override
    public void update(Persona obj) {
        try {
            PostgreSQL conexion = PostgreSQL.getInstance();
            ps = conexion.getConn().prepareStatement(String.format("%s, %s", Persona.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getDomicilio());
            ps.setInt(i++, obj.getTelefono());
            ps.setString(i++, obj.getEmail());
            ps.setDate(i++, (Date) obj.getFechaNacimiento());
            ps.setString(i++, obj.getGenero().getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Error al actualizar persona");
        }
    }

    @Override
    public void delete(Long id) {

    }

    private Persona makePersona(ResultSet rs) throws SQLException{
        Persona persona = new Persona();
        Integer i = 1;
        persona.getGenero().getDescripcion();
        persona.setId(rs.getLong(i++));
        persona.setNombre(rs.getString(i++));
        persona.setDomicilio(rs.getString(i++));
        persona.setTelefono(rs.getInt(i++));
        persona.setEmail(rs.getString(i++));
        persona.setFechaNacimiento(rs.getDate(i++));
        persona.setGeneroDescripcion(rs.getString(i++));
        return persona;
    }
}
