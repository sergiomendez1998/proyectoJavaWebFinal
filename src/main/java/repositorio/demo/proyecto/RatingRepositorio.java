package repositorio.demo.proyecto;

import entity.demo.proyecto.Rating;
import entity.demo.proyecto.Rating_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RatingRepositorio {


    private final EntityManager entityManager;

    public RatingRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public Rating buscarRatingPorCodigo(String codigo) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Rating> ratingQuery = builder.createQuery(Rating.class);
        Root<Rating> root = ratingQuery.from(Rating.class);

        ratingQuery.where(
                builder.equal(root.get(Rating_.codigo), codigo)
        );

        try {
            return this.entityManager.createQuery(ratingQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }


    public void crearOActualizarRating(Rating ratingNuevo){

        Rating rating =this.buscarRatingPorCodigo(ratingNuevo.getCodigo());
        if (rating==null){
            this.entityManager.persist(ratingNuevo);
        }else{
            rating.setPromedio(ratingNuevo.getPromedio());
            rating.setNumeroVotos(ratingNuevo.getNumeroVotos());
            this.entityManager.merge(rating);
        }

    }

}
