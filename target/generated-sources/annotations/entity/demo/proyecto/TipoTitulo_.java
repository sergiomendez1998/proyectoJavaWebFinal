package entity.demo.proyecto;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoTitulo.class)
public abstract class TipoTitulo_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<TipoTitulo, String> descripcion;
	public static volatile ListAttribute<TipoTitulo, Titulo> tituloList;
	public static volatile SingularAttribute<TipoTitulo, Long> tipoTituloId;
	public static volatile SingularAttribute<TipoTitulo, String> nombre;

	public static final String DESCRIPCION = "descripcion";
	public static final String TITULO_LIST = "tituloList";
	public static final String TIPO_TITULO_ID = "tipoTituloId";
	public static final String NOMBRE = "nombre";

}

