package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.List;


@Entity
@Table(name = "tipo_titulo")
@Data
@EqualsAndHashCode(of = "tipoTituloId", callSuper = false)
@ToString(of = "tipoTituloId")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class TipoTitulo extends Entidad  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_titulo_id")
    private  Long tipoTituloId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoTitulo")
    private List<Titulo> tituloList;

}
