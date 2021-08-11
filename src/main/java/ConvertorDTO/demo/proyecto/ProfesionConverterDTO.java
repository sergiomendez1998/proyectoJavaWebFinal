package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.NameBasicsDTO;
import entity.demo.proyecto.Profesion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfesionConverterDTO implements Converter<List<Profesion>, NameBasicsDTO> {

    @Override
    public List<Profesion> convertir(NameBasicsDTO dto){

        List<Profesion> profesionList = Stream.of(dto.getPrimaryProfession().split(","))
                .map(nombresProfesiones ->{
                    Profesion profesion = new Profesion();
                    profesion.setNombre(nombresProfesiones);
                    return profesion;
                }).collect(Collectors.toList());
        
        return profesionList;
    }
}
