package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleAkasDTO;
import entity.demo.proyecto.TituloSinonimo;

import java.util.Optional;

public class TituloSinonimoDTOConverter implements Converter<TituloSinonimo, TitleAkasDTO> {
    @Override
    public TituloSinonimo convertir(TitleAkasDTO dto) {

        TituloSinonimo tituloSinonimo = new TituloSinonimo();
        tituloSinonimo.setLinea(Integer.valueOf(dto.getOrdering()));
        tituloSinonimo.setNombre(dto.getTitle());

        Optional.ofNullable(this.convertirValor(dto.getRegion()))
                .ifPresent(tituloSinonimo::setRegion);

        Optional.ofNullable(this.convertirValor(dto.getLanguage()))
                .ifPresent(tituloSinonimo::setLeguaje);

        Optional.ofNullable(this.convertirValor(dto.getTypes()))
                .ifPresent(tituloSinonimo::setTipo);

        Optional.ofNullable(this.convertirValor(dto.getAttributes()))
                .ifPresent(tituloSinonimo::setAtributos);

        Optional.ofNullable(dto.getIsOriginalTitle())
                .map(Integer::valueOf)
                .map(esOriginal -> esOriginal == 1)
                .ifPresentOrElse(tituloSinonimo::setOriginal, () -> tituloSinonimo.setOriginal(false));

        return tituloSinonimo;

    }
}
