package entity.demo.proyecto;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Titulo.class)
public abstract class Titulo_ extends entity.demo.proyecto.Entidad_ {

	public static volatile SingularAttribute<Titulo, String> codigo;
	public static volatile SingularAttribute<Titulo, String> anyoInicio;
	public static volatile SingularAttribute<Titulo, String> anyoFin;
	public static volatile SetAttribute<Titulo, Episodio> episodioTituloSet;
	public static volatile SingularAttribute<Titulo, Rating> rating;
	public static volatile SingularAttribute<Titulo, TipoTitulo> tipoTitulo;
	public static volatile SingularAttribute<Titulo, String> nombre;
	public static volatile SetAttribute<Titulo, Genero> generoSet;
	public static volatile SingularAttribute<Titulo, Boolean> paraAdultos;
	public static volatile SingularAttribute<Titulo, Integer> tiempo;
	public static volatile SetAttribute<Titulo, TituloSinonimo> tituloSinonimoSet;
	public static volatile SetAttribute<Titulo, Episodio> episodioPadreTituloSet;
	public static volatile SingularAttribute<Titulo, String> nombreOriginal;
	public static volatile SingularAttribute<Titulo, Long> tituloId;
	public static volatile ListAttribute<Titulo, PersonaTitulo> personaTituloList;

	public static final String CODIGO = "codigo";
	public static final String ANYO_INICIO = "anyoInicio";
	public static final String ANYO_FIN = "anyoFin";
	public static final String EPISODIO_TITULO_SET = "episodioTituloSet";
	public static final String RATING = "rating";
	public static final String TIPO_TITULO = "tipoTitulo";
	public static final String NOMBRE = "nombre";
	public static final String GENERO_SET = "generoSet";
	public static final String PARA_ADULTOS = "paraAdultos";
	public static final String TIEMPO = "tiempo";
	public static final String TITULO_SINONIMO_SET = "tituloSinonimoSet";
	public static final String EPISODIO_PADRE_TITULO_SET = "episodioPadreTituloSet";
	public static final String NOMBRE_ORIGINAL = "nombreOriginal";
	public static final String TITULO_ID = "tituloId";
	public static final String PERSONA_TITULO_LIST = "personaTituloList";

}

