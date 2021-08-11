package entity.demo.proyecto;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Entidad implements Serializable {

    @Column(name = "creado_el")
    private LocalDateTime creadoEL;

    @Column(name = "modificado_el")
    private LocalDateTime modificadoEl;

    @PrePersist
    public void ejecutarAntesPersistir(){
        this.creadoEL = LocalDateTime.now();
    }

    @PreUpdate
    public  void ejecutarAntesDeActulizar(){
        this.modificadoEl = LocalDateTime.now();
    }

}
