package controllerCSV.demo.proyecto;

import ConvertorDTO.demo.proyecto.TipoTituloDTOConverter;
import ConvertorDTO.demo.proyecto.TituloDTOConverter;
import ConvertorDTO.demo.proyecto.TituloSinonimoDTOConverter;
import dto.demo.proyecto.TitleAkasDTO;
import dto.demo.proyecto.TitleBasicsDTO;
import entity.demo.proyecto.TipoTitulo;
import entity.demo.proyecto.Titulo;
import entity.demo.proyecto.TituloSinonimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.TipoTituloRepositorio;
import repositorio.demo.proyecto.TituloRepositorio;
import repositorio.demo.proyecto.TituloSinonimoRepositorio;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistirTituloSinonimo {

    EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
    Controlador.DTOParser dtoParser = new Controlador.DTOParser();


    public  void ingresarTituloDDBB(){
        try{
            entityManager.getTransaction().begin();
            File titleBasicsOuput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.basics.tsv1");
            File titleAKASOuput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.akas.tsv1");

            TituloRepositorio tituloRepositorio = new TituloRepositorio(entityManager);
            TituloSinonimoRepositorio tituloSinonimoRepositorio = new TituloSinonimoRepositorio(entityManager);
            TituloSinonimoDTOConverter tituloSinonimoDTOConverter = new TituloSinonimoDTOConverter();

            List<TitleAkasDTO> titleAkasDTOList = dtoParser.parse(TitleAkasDTO.class, titleAKASOuput);

            titleAkasDTOList.stream()
                    .forEach(tituloSinonimoNuevo->{
                        TituloSinonimo tituloSinonimo = tituloSinonimoDTOConverter.convertir(tituloSinonimoNuevo);
                        tituloSinonimo.setTituloSinonimos(tituloRepositorio.buscarTItuloPorCodigo(tituloSinonimoNuevo.getTitleId()));
                        tituloSinonimoRepositorio.crearOActualizarTItuloSinonimo(tituloSinonimo);
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
