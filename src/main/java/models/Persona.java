package models;

import factories.enums.Genero;

import java.util.Date;

public class Persona extends Model{

    public static final String FIELDS = "persona_id, nombre, domicilio, telefono, email, fechaNacimiento, genero";
    public static final String TABLE = "personas";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE persona_id = ", Q_ALL);
    public  static final String INSERT = String.format("INSERT INTO %s (%s) VALUES%s", TABLE, FIELDS, fieldsToInsert(7));
    public static final String UPDATE = String.format("UPDATE %s SET persona_id = ?, nombre = ?, domicilio = ?, telefono = ?, email = ?, fechaNacimiento = ?, genero = ? WHERE persona_id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE country_id = ?", TABLE);

    private Long id;
    private String nombre;
    private String domicilio;
    private Integer telefono;
    private String email;
    private Date fechaNacimiento;
    private Genero genero;
    private String generoDescripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getGeneroDescripcion() {
        return genero.getDescripcion();
    }

    public void setGeneroDescripcion(String generoDescripcion) {
        this.generoDescripcion = genero.getDescripcion();
    }
}
