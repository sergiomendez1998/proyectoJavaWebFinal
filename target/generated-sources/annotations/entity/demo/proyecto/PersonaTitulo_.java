package entity.demo.proyecto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonaTitulo.class)
public abstract class PersonaTitulo_ {

	public static volatile SingularAttribute<PersonaTitulo, Integer> tipoRelacion;
	public static volatile SingularAttribute<PersonaTitulo, Persona> persona;
	public static volatile SingularAttribute<PersonaTitulo, Long> tituloId;
	public static volatile SingularAttribute<PersonaTitulo, Titulo> titulo;
	public static volatile SingularAttribute<PersonaTitulo, Long> personaId;

	public static final String TIPO_RELACION = "tipoRelacion";
	public static final String PERSONA = "persona";
	public static final String TITULO_ID = "tituloId";
	public static final String TITULO = "titulo";
	public static final String PERSONA_ID = "personaId";

}

