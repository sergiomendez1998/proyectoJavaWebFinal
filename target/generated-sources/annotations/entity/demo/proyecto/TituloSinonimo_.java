package entity.demo.proyecto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TituloSinonimo.class)
public abstract class TituloSinonimo_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<TituloSinonimo, Long> tituloSinonimoId;
	public static volatile SingularAttribute<TituloSinonimo, String> tipo;
	public static volatile SingularAttribute<TituloSinonimo, Boolean> original;
	public static volatile SingularAttribute<TituloSinonimo, String> leguaje;
	public static volatile SingularAttribute<TituloSinonimo, String> region;
	public static volatile SingularAttribute<TituloSinonimo, String> nombre;
	public static volatile SingularAttribute<TituloSinonimo, Integer> linea;
	public static volatile SingularAttribute<TituloSinonimo, String> atributos;
	public static volatile SingularAttribute<TituloSinonimo, Titulo> tituloSinonimos;

	public static final String TITULO_SINONIMO_ID = "tituloSinonimoId";
	public static final String TIPO = "tipo";
	public static final String ORIGINAL = "original";
	public static final String LEGUAJE = "leguaje";
	public static final String REGION = "region";
	public static final String NOMBRE = "nombre";
	public static final String LINEA = "linea";
	public static final String ATRIBUTOS = "atributos";
	public static final String TITULO_SINONIMOS = "tituloSinonimos";

}

