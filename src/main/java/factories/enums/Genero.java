package factories.enums;

public enum Genero {
    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private String descripcion;

    Genero(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
