package entity.demo.proyecto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="rating")
@Data
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@EqualsAndHashCode(of ="iD", callSuper = false)
@ToString(of = "iD")
public class Rating extends  Entidad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long iD;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "promedio")
    private Double promedio;

    @Column(name = "numero_votos")
    private Integer numeroVotos;

    @OneToOne
    @JoinColumn(name = "titulo_id")
    private Titulo ratingTitulo;

}
