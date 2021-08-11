package controllerCSV.demo.proyecto;

import ConvertorDTO.demo.proyecto.PersonaDTOConverter;
import ConvertorDTO.demo.proyecto.ProfesionConverterDTO;
import dto.demo.proyecto.NameBasicsDTO;
import entity.demo.proyecto.Persona;
import entity.demo.proyecto.Profesion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import repositorio.demo.proyecto.PersonaRepositorio;
import repositorio.demo.proyecto.ProfesionRepositorio;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersisitirPersonaProfesion {


   EntityManager entityManager = Persistence.createEntityManagerFactory("myPersistence")
            .createEntityManager();
   Controlador.DTOParser dtoParser = new Controlador.DTOParser();

    public void ingresarPesonasDDBB(){
        try {
            entityManager.getTransaction().begin();
            File nameBasicsOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\name.basics.tsv1");
            List<NameBasicsDTO> nameBasicsDTOList = dtoParser.parse(NameBasicsDTO.class, nameBasicsOutput);

            //DTOPersona
            PersonaRepositorio personaRepositorio = new PersonaRepositorio(entityManager);
            PersonaDTOConverter personaDTOConverter = new PersonaDTOConverter();
            //DTOprofesion
            ProfesionRepositorio profesionRepositorio = new ProfesionRepositorio(entityManager);
            ProfesionConverterDTO profesionConverterDTO = new ProfesionConverterDTO();
            List<Profesion> profesionList = profesionRepositorio.buscarProfesiones();

            nameBasicsDTOList.stream()
                            .forEach(dto -> {
                                List<Profesion> profesionListDTO = profesionConverterDTO.convertir(dto);
                                 Set<Profesion> personaProfesionSet = new HashSet<>();

                               profesionListDTO.stream().forEach(profesionNuevo ->{

                                   profesionList.stream()
                                           .filter(p-> p.getNombre().equalsIgnoreCase(profesionNuevo.getNombre()))
                                           .findFirst()
                                           .ifPresentOrElse(p ->{
                                               personaProfesionSet.add(p);
                                           },() ->{
                                               profesionRepositorio.crearOActualizarProfesion(profesionNuevo);
                                               profesionList.add(profesionNuevo);
                                               personaProfesionSet.add(profesionNuevo);
                                   });
                               });
                               Persona persona = personaDTOConverter.convertir(dto);
                               persona.setProfesionSet(personaProfesionSet);
                               personaRepositorio.crearOActualizarPersona(persona);

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
