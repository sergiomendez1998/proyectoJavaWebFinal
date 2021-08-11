package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.Set;


@Entity
@Table(name = "genero")
@Data
@EqualsAndHashCode(of = "generoId", callSuper = false)
@ToString(of = "generoId")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Genero extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Long generoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "generoSet")
    private Set<Titulo> tituloset;


}
