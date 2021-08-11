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
@Table(name="profesion")
@Data
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@EqualsAndHashCode(of ="profesionId", callSuper = false)
@ToString(of = "profesionId")
public class Profesion extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profesion_id")
    private Long profesionId;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "profesionSet")
    private Set<Persona> personaSet;

}
