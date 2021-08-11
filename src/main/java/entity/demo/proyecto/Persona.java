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
@Table(name = "persona")
@EqualsAndHashCode(of = "personaId", callSuper = false)
@ToString(of = "personaId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
@Data
public class Persona extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long personaId;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anyo_nacimiento")
    private String anyoNacimiento;
    
    @Column(name = "anyo_fallecimiento")
    private String anyoFallecimiento;

    @ManyToMany
    @JoinTable(
            name = "persona_profesion",
            joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "profesion_id", referencedColumnName = "profesion_id")
    )
    private Set<Profesion> profesionSet;

    @OneToMany(mappedBy = "persona")
    private List<PersonaTitulo> personaTituloList;


}
