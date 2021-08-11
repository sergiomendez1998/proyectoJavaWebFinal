package repositorio.demo.proyecto;


import entity.demo.proyecto.TituloSinonimo;
import entity.demo.proyecto.TituloSinonimo_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class TituloSinonimoRepositorio {

    private final EntityManager entityManager;

    public TituloSinonimoRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public TituloSinonimo buscarTItuloSinonimoPorId(Long tituloSinonimoId) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TituloSinonimo> tituloSinonimoCriteriaQuery = builder.createQuery(TituloSinonimo.class);
        Root<TituloSinonimo> root = tituloSinonimoCriteriaQuery.from(TituloSinonimo.class);

        tituloSinonimoCriteriaQuery.where(
                builder.equal(root.get(TituloSinonimo_.tituloSinonimoId), tituloSinonimoId)
        );

        try {
            return this.entityManager.createQuery(tituloSinonimoCriteriaQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }


    public void crearOActualizarTItuloSinonimo(TituloSinonimo tituloSinonimoNuevo){

        TituloSinonimo tituloSinonimo = this.buscarTItuloSinonimoPorId(tituloSinonimoNuevo.getTituloSinonimoId());

        if (tituloSinonimo == null){
            this.entityManager.persist(tituloSinonimoNuevo);
        }else{
            tituloSinonimo.setLinea(tituloSinonimoNuevo.getLinea());
            tituloSinonimo.setNombre(tituloSinonimoNuevo.getNombre());
            tituloSinonimo.setRegion(tituloSinonimoNuevo.getRegion());
            tituloSinonimo.setLeguaje(tituloSinonimoNuevo.getLeguaje());
            tituloSinonimo.setTipo(tituloSinonimoNuevo.getTipo());
            tituloSinonimo.setAtributos(tituloSinonimoNuevo.getAtributos());
            tituloSinonimo.setOriginal(tituloSinonimoNuevo.isOriginal());
            this.entityManager.merge(tituloSinonimo);
        }

    }
}
