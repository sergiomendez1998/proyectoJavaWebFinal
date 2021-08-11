package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity
@Table(name = "titulo_sinonimo")
@Data
@EqualsAndHashCode(of = "tituloSinonimoId", callSuper = false)
@ToString(of = "tituloSinonimoId")
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
public class TituloSinonimo extends Entidad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titulo_sinonimo_id")
    private Long tituloSinonimoId;

    @Column(name = "linea")
    private Integer linea;


    @Column(name = "nombre")
    private String nombre;

    @Column(name = "region")
    private String region;

    @Column(name = "lenguaje")
    private String leguaje;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "atributos")
    private String atributos;

    @Column(name = "original")
    private boolean original;

    @ManyToOne
    @JoinColumn(name = "titulo_id")
    private Titulo tituloSinonimos;

}
