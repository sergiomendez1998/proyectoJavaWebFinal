package repositorio.demo.proyecto;

import entity.demo.proyecto.Persona;
import entity.demo.proyecto.PersonaTitulo;
import entity.demo.proyecto.PersonaTitulo_;
import entity.demo.proyecto.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonaTituloRepositorio {

    private final PersonaRepositorio personaRepositorio;

    private final EntityManager entityManager;

    public PersonaTituloRepositorio(EntityManager entityManager, PersonaRepositorio personaRepositorio) {
        this.entityManager = entityManager;
        this.personaRepositorio = personaRepositorio;
    }


    private void actualizar(Titulo titulo, String[] codigos, int tipoRelacion) {
        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);

        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);

        query.where(
                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
                builder.equal(root.get(PersonaTitulo_.tipoRelacion), tipoRelacion)
        );
        this.entityManager.createQuery(query).executeUpdate();

        if (codigos != null) {

            List<Persona> directoresPersonaList = Stream.of(codigos)
                    .map(personaRepositorio::buscarPersonaPorCodigo)
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            directoresPersonaList.stream().forEach(director -> {

                PersonaTitulo personaTitulo = new PersonaTitulo();
                personaTitulo.setPersonaId(director.getPersonaId());
                personaTitulo.setTituloId(titulo.getTituloId());
                personaTitulo.setTipoRelacion(tipoRelacion);

                entityManager.persist(personaTitulo);
            });

        }
    }

    public void actualizarDirectores(Titulo titulo, String[] codigos) {
        this.actualizar(titulo, codigos, PersonaTitulo.DIRECTORES);
    }


    public void actualizarEscritores(Titulo titulo, String[] codigos) {
        this.actualizar(titulo, codigos, PersonaTitulo.ESCRITORES);
    }

    

}
