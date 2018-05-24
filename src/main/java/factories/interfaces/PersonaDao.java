package factories.interfaces;

import models.Persona;

import java.util.List;

public interface PersonaDao {

    public void create(Persona obj);

    public List<Persona> read(String criteria);

    public Persona read(Long id);

    public void update(Persona obj);

    public void delete(Long id);

}
