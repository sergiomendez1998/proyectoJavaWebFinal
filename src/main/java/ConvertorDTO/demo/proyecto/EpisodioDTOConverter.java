package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleEpisodeDTO;
import entity.demo.proyecto.Episodio;

import java.util.Optional;

public class EpisodioDTOConverter implements Converter<Episodio, TitleEpisodeDTO>  {
    @Override
    public Episodio convertir(TitleEpisodeDTO dto) {

        Episodio episodio = new Episodio();

        episodio.setCodigoTitulo(dto.getTconst());
        episodio.setCodigoPadreTituloId(dto.getParentTconst());

        Optional.ofNullable(this.convertirValor(dto.getSeasonNumber()))
                .map(Integer::valueOf)
                .ifPresent(episodio::setNumeroTemporada);

        Optional.ofNullable(this.convertirValor(dto.getEpisodeNumber()))
                .map(Integer::valueOf)
                .ifPresent(episodio::setNumeroEpisodio);

        return episodio;
    }
}
