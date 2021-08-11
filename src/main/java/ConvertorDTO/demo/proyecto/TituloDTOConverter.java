package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleBasicsDTO;
import entity.demo.proyecto.Titulo;

import java.util.Optional;

public class TituloDTOConverter implements Converter<Titulo, TitleBasicsDTO> {


    @Override
    public Titulo convertir(TitleBasicsDTO dto) {


        Titulo titulo = new Titulo();

        titulo.setCodigo(dto.getTconst());
        titulo.setNombre(dto.getPrimaryTitle());
        titulo.setNombreOriginal(dto.getOriginalTitle());
        titulo.setAnyoInicio(dto.getStartYear());
        titulo.setAnyoFin(dto.getEndYear());

        Optional.ofNullable(dto.getIsAdult())
                .map(Integer::valueOf)
                .map(paraAdultos -> paraAdultos == 1)
                .ifPresentOrElse(titulo::setParaAdultos, () -> titulo.setParaAdultos(false));

        Optional.ofNullable(this.convertirValor(dto.getRuntimeMinutes()))
                .map(Integer::valueOf)
                .ifPresent(titulo::setTiempo);

        return titulo;
    }
}
