package repositorio.demo.proyecto;

import entity.demo.proyecto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TipoTituloRepositorio {

    private final EntityManager entityManager;

    public TipoTituloRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public List<TipoTitulo> buscarTipoTitulos() {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<TipoTitulo> tipoTituloQuery = builder.createQuery(TipoTitulo.class);

        tipoTituloQuery.from(TipoTitulo.class);

        return this.entityManager.createQuery(tipoTituloQuery).getResultList();
    }

    public TipoTitulo buscarTituloPorPorNombre(String nombre) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoTitulo> TipoTiuloQuery = builder.createQuery(TipoTitulo.class);
        Root<TipoTitulo> root = TipoTiuloQuery.from(TipoTitulo.class);

        TipoTiuloQuery.where(
                builder.equal(root.get(TipoTitulo_.nombre), nombre)
        );
        try {
            return this.entityManager.createQuery(TipoTiuloQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }


    public void crearOActualizarTipoTitulo(TipoTitulo tipoTituloNuevo){

        TipoTitulo tipoTitulo = this.buscarTituloPorPorNombre(tipoTituloNuevo.getNombre());

        if (tipoTitulo==null){
            this.entityManager.persist(tipoTituloNuevo);
        }else{

            tipoTitulo.setDescripcion(tipoTituloNuevo.getDescripcion());
            this.entityManager.merge(tipoTitulo);

        }

    }
}
