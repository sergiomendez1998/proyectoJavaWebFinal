package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serializable;
import jakarta.persistence.Entity;

@Entity
@Table(name = "persona_titulo")
@Data
@EqualsAndHashCode(of = "tituloId", callSuper = false)
@ToString(of = "tituloId")
public class PersonaTitulo implements Serializable {

    public static final int ACTORES_ACTRICES = 1;
    public static final int DIRECTORES = 2;
    public static final int ESCRITORES = 3;

    @Id
    @Column(name = "persona_id")
    private Long personaId;

    @Id
    @Column(name = "titulo_id")
    private Long tituloId;

    @Id
    @Column(name = "tipo_relacion")
    private Integer tipoRelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo_id", referencedColumnName = "titulo_id", insertable = false, updatable = false)
    private Titulo titulo;
}
