package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleBasicsDTO;
import entity.demo.proyecto.TipoTitulo;

public class TipoTituloDTOConverter implements Converter<TipoTitulo, TitleBasicsDTO>{
    @Override
    public TipoTitulo convertir(TitleBasicsDTO dto) {
        TipoTitulo tipoTitulo = new TipoTitulo();
        tipoTitulo.setNombre(dto.getTitleType());
        return tipoTitulo;
    }
}
