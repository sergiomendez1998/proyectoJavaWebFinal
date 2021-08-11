package entity.demo.proyecto;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Profesion.class)
public abstract class Profesion_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Profesion, String> descripcion;
	public static volatile SingularAttribute<Profesion, Long> profesionId;
	public static volatile SingularAttribute<Profesion, String> nombre;
	public static volatile SetAttribute<Profesion, Persona> personaSet;

	public static final String DESCRIPCION = "descripcion";
	public static final String PROFESION_ID = "profesionId";
	public static final String NOMBRE = "nombre";
	public static final String PERSONA_SET = "personaSet";

}

