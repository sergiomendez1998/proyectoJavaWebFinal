package entity.demo.proyecto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Entidad.class)
public abstract class Entidad_ {

	public static volatile SingularAttribute<Entidad, LocalDateTime> modificadoEl;
	public static volatile SingularAttribute<Entidad, LocalDateTime> creadoEL;

	public static final String MODIFICADO_EL = "modificadoEl";
	public static final String CREADO_EL = "creadoEL";

}

