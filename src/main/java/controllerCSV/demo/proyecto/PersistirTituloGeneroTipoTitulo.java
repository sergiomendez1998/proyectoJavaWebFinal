package controllerCSV.demo.proyecto;

import ConvertorDTO.demo.proyecto.*;
import dto.demo.proyecto.TitleBasicsDTO;
import entity.demo.proyecto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.*;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistirTituloGeneroTipoTitulo {

    EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
    Controlador.DTOParser dtoParser = new Controlador.DTOParser();

    public void ingresarDDBB(){
        try {
            entityManager.getTransaction().begin();
           File titleBasicsOuput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.basics.tsv1");
            List<TitleBasicsDTO> titleBasicsDTOList = dtoParser.parse(TitleBasicsDTO.class, titleBasicsOuput);

            TituloRepositorio  tituloRepositorio = new TituloRepositorio(entityManager);
            TituloDTOConverter tituloDTOConverter = new TituloDTOConverter();

            GeneroRepositorio generoRepositorio = new GeneroRepositorio(entityManager);
            GeneroDTOConverter generoDTOConverter = new GeneroDTOConverter();

            TipoTituloRepositorio tipoTituloRepositorio = new TipoTituloRepositorio(entityManager);
            TipoTituloDTOConverter tipoTituloDTOConverter = new TipoTituloDTOConverter();

            List<Genero> generoList = generoRepositorio.buscarGeneros();

            titleBasicsDTOList.stream()
                    .forEach(dto -> {
                        List<Genero> generoListDTO = generoDTOConverter.convertir(dto);
                        Set<Genero> generoTituloSet = new HashSet<>();
                        generoListDTO.stream().forEach(generoNuevo->{
                            generoList.stream()
                                    .filter(g -> g.getNombre().equalsIgnoreCase(generoNuevo.getNombre()))
                                    .findFirst()
                                    .ifPresentOrElse(g->{
                                        generoTituloSet.add(g);
                                    },()->{
                                        generoRepositorio.crearOActualizarGeneros(generoNuevo);
                                        generoList.add(generoNuevo);
                                        generoTituloSet.add(generoNuevo);
                                    });
                        });
                        //we create a titleType
                        TipoTitulo tipoTitulo = tipoTituloDTOConverter.convertir(dto);
                        tipoTituloRepositorio.crearOActualizarTipoTitulo(tipoTitulo);

                        Titulo titulo = tituloDTOConverter.convertir(dto);
                        titulo.setGeneroSet(generoTituloSet);
                        titulo.setTipoTitulo(tipoTituloRepositorio.buscarTituloPorPorNombre(dto.getTitleType()));
                        tituloRepositorio.crearOActualizarTItulo(titulo);
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
