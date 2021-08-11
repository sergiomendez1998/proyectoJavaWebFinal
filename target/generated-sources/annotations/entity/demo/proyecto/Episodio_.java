package entity.demo.proyecto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Episodio.class)
public abstract class Episodio_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Episodio, Integer> numeroEpisodio;
	public static volatile SingularAttribute<Episodio, String> codigoTitulo;
	public static volatile SingularAttribute<Episodio, Long> episodioId;
	public static volatile SingularAttribute<Episodio, String> CodigoPadreTituloId;
	public static volatile SingularAttribute<Episodio, Integer> numeroTemporada;
	public static volatile SingularAttribute<Episodio, Titulo> episodioTitulo;
	public static volatile SingularAttribute<Episodio, Titulo> episodioPadreTitulo;

	public static final String NUMERO_EPISODIO = "numeroEpisodio";
	public static final String CODIGO_TITULO = "codigoTitulo";
	public static final String EPISODIO_ID = "episodioId";
	public static final String CODIGO_PADRE_TITULO_ID = "CodigoPadreTituloId";
	public static final String NUMERO_TEMPORADA = "numeroTemporada";
	public static final String EPISODIO_TITULO = "episodioTitulo";
	public static final String EPISODIO_PADRE_TITULO = "episodioPadreTitulo";

}

