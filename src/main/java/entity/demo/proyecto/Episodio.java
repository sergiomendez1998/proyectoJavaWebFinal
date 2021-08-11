package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;



@Entity
@Table(name = "episodio")
@Data
@EqualsAndHashCode(of = "episodioId", callSuper = false)
@ToString(of = "episodioId")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Episodio extends Entidad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "episodio_id")
    private Long episodioId;

    @Column(name = "codigo_titulo")
    private String codigoTitulo;

    @Column(name = "codigo_padre_titulo_id")
    private String CodigoPadreTituloId;

    @Column(name = "numero_episodio")
    private int numeroEpisodio;

    @Column(name="numero_temporada")
    private int numeroTemporada;

    @ManyToOne
    @JoinColumn(name = "titulo_id")
    private Titulo episodioTitulo;

    @ManyToOne
    @JoinColumn(name = "titulo_id", insertable = false, updatable = false)
    private Titulo episodioPadreTitulo;




}
