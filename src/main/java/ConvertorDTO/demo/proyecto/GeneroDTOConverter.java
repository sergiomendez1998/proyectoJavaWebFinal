package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleBasicsDTO;
import entity.demo.proyecto.Genero;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneroDTOConverter implements Converter<List<Genero>, TitleBasicsDTO> {
    @Override
    public List<Genero> convertir(TitleBasicsDTO dto) {
        List<Genero> generoList = Stream.of(dto.getGenres().split(","))
                .map(nombresGeneros ->{
                    Genero genero = new Genero();
                    genero.setNombre(nombresGeneros);
                    return genero;
                }).collect(Collectors.toList());
        return generoList;
    }
}
