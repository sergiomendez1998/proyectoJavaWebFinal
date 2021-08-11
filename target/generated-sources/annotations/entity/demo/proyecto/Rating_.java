package entity.demo.proyecto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rating.class)
public abstract class Rating_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Rating, String> codigo;
	public static volatile SingularAttribute<Rating, Titulo> ratingTitulo;
	public static volatile SingularAttribute<Rating, Double> promedio;
	public static volatile SingularAttribute<Rating, Long> iD;
	public static volatile SingularAttribute<Rating, Integer> numeroVotos;

	public static final String CODIGO = "codigo";
	public static final String RATING_TITULO = "ratingTitulo";
	public static final String PROMEDIO = "promedio";
	public static final String I_D = "iD";
	public static final String NUMERO_VOTOS = "numeroVotos";

}

