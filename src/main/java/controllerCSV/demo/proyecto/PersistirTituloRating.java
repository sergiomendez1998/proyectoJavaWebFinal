package controllerCSV.demo.proyecto;


import ConvertorDTO.demo.proyecto.RatingDTOConverter;
import dto.demo.proyecto.TitleRatingDTO;
import entity.demo.proyecto.Rating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.RatingRepositorio;
import repositorio.demo.proyecto.TituloRepositorio;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistirTituloRating {
    EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
    Controlador.DTOParser dtoParser = new Controlador.DTOParser();
    public  void ingresarTituloDDBB(){
        File titleRatingOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.ratings.tsv1");
try{

        entityManager.getTransaction().begin();
        TituloRepositorio tituloRepositorio = new TituloRepositorio(entityManager);
        RatingDTOConverter ratingDTOConverter = new RatingDTOConverter();
        RatingRepositorio ratingRepositorio = new RatingRepositorio(entityManager);
        List<TitleRatingDTO> ratingDTOList = dtoParser.parse(TitleRatingDTO.class, titleRatingOutput);

         ratingDTOList.stream()
            .forEach(ratingNuevo->{
                Rating rating = ratingDTOConverter.convertir(ratingNuevo);
                rating.setRatingTitulo(tituloRepositorio.buscarTItuloPorCodigo(ratingNuevo.getTconst()));
                ratingRepositorio.crearOActualizarRating(rating);
            });

    entityManager.getTransaction().commit();
    }catch (Exception ex) {
        Logger.getLogger("Main").log(Level.SEVERE, "Error", ex);
        entityManager.getTransaction().rollback();
    } finally {
        entityManager.close();
    }

    }
}


