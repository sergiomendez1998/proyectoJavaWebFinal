package entity.demo.proyecto;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genero.class)
public abstract class Genero_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Genero, String> descripcion;
	public static volatile SetAttribute<Genero, Titulo> tituloset;
	public static volatile SingularAttribute<Genero, Long> generoId;
	public static volatile SingularAttribute<Genero, String> nombre;

	public static final String DESCRIPCION = "descripcion";
	public static final String TITULOSET = "tituloset";
	public static final String GENERO_ID = "generoId";
	public static final String NOMBRE = "nombre";

}

