package repositorio.demo.proyecto;

import entity.demo.proyecto.Persona;
import entity.demo.proyecto.Persona_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class PersonaRepositorio {
    private final EntityManager entityManager;

    public PersonaRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public Persona buscarPersonaPorCodigo(String codigo) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);
        Root<Persona> root = personaQuery.from(Persona.class);

        personaQuery.where(
                builder.equal(root.get(Persona_.codigo), codigo)
        );

        try {
          return this.entityManager.createQuery(personaQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }

    public void crearOActualizarPersona(Persona personaNuevo){
        Persona persona = this.buscarPersonaPorCodigo(personaNuevo.getCodigo());

        if (persona==null){
            this.entityManager.persist(personaNuevo);
        }else {
            persona.setNombre(personaNuevo.getNombre());
            persona.setAnyoNacimiento(personaNuevo.getAnyoNacimiento());
            persona.setAnyoFallecimiento(personaNuevo.getAnyoFallecimiento());
            persona.setProfesionSet(persona.getProfesionSet());
            this.entityManager.merge(persona);
        }
        
    }
}