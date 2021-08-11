package repositorio.demo.proyecto;

import entity.demo.proyecto.Genero;
import entity.demo.proyecto.Genero_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


import java.util.List;

public class GeneroRepositorio {


    private final EntityManager entityManager;

    public GeneroRepositorio (EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    public List<Genero> buscarGeneros() {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Genero> generoQuery = builder.createQuery(Genero.class);

        generoQuery .from(Genero.class);

        return this.entityManager.createQuery(generoQuery ).getResultList();
    }

    public Genero buscarGenerosPorNombre(String nombre) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Genero> generoQuery = builder.createQuery(Genero.class);
        Root<Genero> root = generoQuery.from(Genero.class);

        generoQuery.where(
                builder.equal(root.get(Genero_.nombre), nombre)
        );

        try {
            return this.entityManager.createQuery(generoQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }
    public void crearOActualizarGeneros(Genero generoNuevo){

        Genero genero =  this.buscarGenerosPorNombre(generoNuevo.getNombre());

        if (genero == null) {
            this.entityManager.persist(generoNuevo);
        }else{

           genero.setDescripcion(generoNuevo.getDescripcion());
           this.entityManager.merge(genero);

        }
    }
}
