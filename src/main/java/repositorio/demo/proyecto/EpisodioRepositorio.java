package repositorio.demo.proyecto;

import entity.demo.proyecto.Episodio;
import entity.demo.proyecto.Episodio_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EpisodioRepositorio {

    private final EntityManager entityManager;

    public EpisodioRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public Episodio buscarEpisodioPorId(Long episodioId) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Episodio> episodioQuery = builder.createQuery(Episodio.class);
        Root<Episodio> root = episodioQuery.from(Episodio.class);

        episodioQuery.where(
                builder.equal(root.get(Episodio_.episodioId), episodioId)
        );

        try {
            return this.entityManager.createQuery(episodioQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }


    public void crearOActualizarEpisodio(Episodio episodioNuevo){

       Episodio episodio = this.buscarEpisodioPorId(episodioNuevo.getEpisodioId());

        if (episodio == null){
            this.entityManager.persist(episodioNuevo);
        }else{
            episodio.setNumeroEpisodio(episodioNuevo.getNumeroEpisodio());
            episodio.setNumeroTemporada(episodioNuevo.getNumeroTemporada());
            this.entityManager.merge(episodio);
        }

    }


}
