package controllerCSV.demo.proyecto;


import dto.demo.proyecto.TitleCrewDTO;
import entity.demo.proyecto.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.PersonaRepositorio;
import repositorio.demo.proyecto.PersonaTituloRepositorio;
import repositorio.demo.proyecto.TituloRepositorio;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistirTituloPersona {

    EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
    Controlador.DTOParser dtoParser = new Controlador.DTOParser();

    public void ingresarDDBB(){

        try{
            entityManager.getTransaction().begin();


            File titleCrewOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.crew.tsv1");
            List<TitleCrewDTO> titleCrewDTOList = dtoParser.parse(TitleCrewDTO.class, titleCrewOutput);

            PersonaRepositorio personaRepositorio = new PersonaRepositorio(entityManager);
            TituloRepositorio tituloRepositorio = new TituloRepositorio(entityManager);
            PersonaTituloRepositorio personaTituloRepositorio = new PersonaTituloRepositorio(entityManager, personaRepositorio);

            titleCrewDTOList.stream().forEach(dto -> {
                Titulo titulo = tituloRepositorio.buscarTItuloPorCodigo(dto.getTconst());
                if (titulo != null) {
                    personaTituloRepositorio.actualizarDirectores(titulo, dto.directorsToArray());
                    personaTituloRepositorio.actualizarEscritores(titulo, dto.writersToArray());
                }
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





