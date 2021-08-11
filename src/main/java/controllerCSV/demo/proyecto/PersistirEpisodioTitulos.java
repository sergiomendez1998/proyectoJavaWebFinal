package controllerCSV.demo.proyecto;

import ConvertorDTO.demo.proyecto.EpisodioDTOConverter;
import dto.demo.proyecto.TitleEpisodeDTO;
import entity.demo.proyecto.Episodio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.EpisodioRepositorio;
import repositorio.demo.proyecto.TituloRepositorio;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistirEpisodioTitulos {

    EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
    Controlador.DTOParser dtoParser = new Controlador.DTOParser();
    public  void ingresarTituloDDBB(){
        File titleEpisodeOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.episode.tsv1");
        try{
            entityManager.getTransaction().begin();
              TituloRepositorio tituloRepositorio = new TituloRepositorio(entityManager);
              EpisodioDTOConverter episodioDTOConverter = new EpisodioDTOConverter();
              EpisodioRepositorio episodioRepositorio = new EpisodioRepositorio(entityManager);

              List<TitleEpisodeDTO> titleEpisodeDTOList = dtoParser.parse(TitleEpisodeDTO.class, titleEpisodeOutput);

              titleEpisodeDTOList.stream()
                    .forEach(episodioNuevo->{
                        Episodio episodio = episodioDTOConverter.convertir(episodioNuevo);
                        episodio.setEpisodioTitulo(tituloRepositorio.buscarTItuloPorCodigo(episodioNuevo.getTconst()));
                        episodio.setEpisodioPadreTitulo(tituloRepositorio.buscarTItuloPorCodigo(episodioNuevo.getParentTconst()));
                        episodioRepositorio.crearOActualizarEpisodio(episodio);
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
