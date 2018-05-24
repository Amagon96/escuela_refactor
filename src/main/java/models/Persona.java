package models;

import factories.enums.Genero;

import java.util.Date;

public class Persona {

    public static final String FIELDS = "persona_id, nombre, domicilio, telefono, email, fechaNacimiento, genero";

    private Long id;
    private String nombre;
    private String domicilio;
    private Integer telefono;
    private String email;
    private Date fechaNacimiento;
    private Genero genero;
}
