package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "titulo")
@Data
@EqualsAndHashCode(of = "tituloId", callSuper = false)
@ToString(of = "tituloId")
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
public class Titulo extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titulo_id")
    private Long tituloId;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_original")
    private String nombreOriginal;

    @Column(name = "para_adultos")
    private boolean paraAdultos;

    @Column(name = "anyo_nacimiento")
    private String anyoInicio;

    @Column(name = "anyo_fin")
    private String anyoFin;

    @Column(name = "tiempo")
    private Integer tiempo;

    @OneToMany(mappedBy = "titulo")
    private List<PersonaTitulo> personaTituloList;

    @OneToOne(mappedBy = "ratingTitulo")
    private Rating rating;

   @OneToMany(mappedBy = "tituloSinonimos")
   private Set<TituloSinonimo> tituloSinonimoSet;

   @OneToMany(mappedBy = "episodioTitulo")
   private Set<Episodio> episodioTituloSet;

    @OneToMany(mappedBy = "episodioPadreTitulo")
    private Set<Episodio> episodioPadreTituloSet;


    @ManyToMany
    @JoinTable(
            name = "titulo_genero",
            joinColumns = @JoinColumn(name = "titulo_id", referencedColumnName = "titulo_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id", referencedColumnName = "genero_id")
    )
     private Set<Genero> generoSet;


    @ManyToOne
    @JoinColumn(name = "tipo_titulo_id")
    private TipoTitulo tipoTitulo;






}
