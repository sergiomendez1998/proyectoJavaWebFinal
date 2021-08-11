package repositorio.demo.proyecto;


import entity.demo.proyecto.Titulo;
import entity.demo.proyecto.Titulo_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



public class TituloRepositorio {

    private final EntityManager entityManager;

    public TituloRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public Titulo buscarTItuloPorCodigo(String codigo) {

        var builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Titulo> profesionQuery = builder.createQuery(Titulo.class);
        Root<Titulo> root = profesionQuery.from(Titulo.class);

        profesionQuery.where(
                builder.equal(root.get(Titulo_.codigo), codigo)
        );

        try {
            return this.entityManager.createQuery(profesionQuery).getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }


    public void crearOActualizarTItulo(Titulo tituloNuevo){

        Titulo titulo = this.buscarTItuloPorCodigo(tituloNuevo.getCodigo());

        if (titulo==null){

            this.entityManager.persist(tituloNuevo);

        }else{

            titulo.setAnyoFin(tituloNuevo.getAnyoFin());
            titulo.setAnyoInicio(tituloNuevo.getAnyoInicio());
            titulo.setNombre(tituloNuevo.getNombre());
            titulo.setNombreOriginal(tituloNuevo.getNombreOriginal());
            titulo.setParaAdultos(tituloNuevo.isParaAdultos());
            titulo.setTiempo(tituloNuevo.getTiempo());

            this.entityManager.merge(titulo);

        }

    }


}
