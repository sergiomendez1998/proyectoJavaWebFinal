package ConvertorDTO.demo.proyecto;

import dto.demo.proyecto.TitleRatingDTO;
import entity.demo.proyecto.Rating;


public class RatingDTOConverter implements Converter<Rating, TitleRatingDTO>{


    @Override
    public Rating convertir(TitleRatingDTO dto) {

        Rating rating = new Rating();

    rating.setCodigo(dto.getTconst());
    rating.setPromedio(Double.parseDouble(dto.getAverageRating()));
    rating.setNumeroVotos(Integer.valueOf(dto.getNumVotes()));

        return  rating;
    }
}
