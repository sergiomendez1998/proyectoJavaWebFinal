package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.NameBasicsDTO;
import entity.demo.proyecto.Persona;

public class PersonaDTOConverter implements Converter<Persona, NameBasicsDTO> {

    @Override
    public  Persona convertir(NameBasicsDTO dto){
        Persona persona = new Persona();
        persona.setCodigo(dto.getNconst());
        persona.setNombre(dto.getPrimaryName());
        persona.setAnyoNacimiento(this.convertirValor(dto.getBirthYear()));
        persona.setAnyoFallecimiento(this.convertirValor(dto.getDeathYear()));
        return persona;
    }
}
