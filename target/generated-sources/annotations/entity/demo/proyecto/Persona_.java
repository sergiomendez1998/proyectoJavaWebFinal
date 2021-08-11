package entity.demo.proyecto;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Persona, String> codigo;
	public static volatile SingularAttribute<Persona, String> anyoNacimiento;
	public static volatile SingularAttribute<Persona, String> anyoFallecimiento;
	public static volatile SetAttribute<Persona, Profesion> profesionSet;
	public static volatile ListAttribute<Persona, PersonaTitulo> personaTituloList;
	public static volatile SingularAttribute<Persona, Long> personaId;
	public static volatile SingularAttribute<Persona, String> nombre;

	public static final String CODIGO = "codigo";
	public static final String ANYO_NACIMIENTO = "anyoNacimiento";
	public static final String ANYO_FALLECIMIENTO = "anyoFallecimiento";
	public static final String PROFESION_SET = "profesionSet";
	public static final String PERSONA_TITULO_LIST = "personaTituloList";
	public static final String PERSONA_ID = "personaId";
	public static final String NOMBRE = "nombre";

}

