package main.demo.proyecto;

import controllerCSV.demo.proyecto.*;

public class MainProject {

    public static void main(String[] args) {


        PersistirTituloGeneroTipoTitulo persistirTituloGenero = new PersistirTituloGeneroTipoTitulo();
        persistirTituloGenero.ingresarDDBB();

        PersisitirPersonaProfesion persisitirPersonaProfesion = new PersisitirPersonaProfesion();
        persisitirPersonaProfesion.ingresarPesonasDDBB();

        PersistirTituloRating persistirTituloRating = new PersistirTituloRating();
        persistirTituloRating.ingresarTituloDDBB();

        PersistirTituloPersona tituloPersona = new PersistirTituloPersona();
        tituloPersona.ingresarDDBB();

        PersistirTituloSinonimo persistirTituloSinonimo = new PersistirTituloSinonimo();
        persistirTituloSinonimo.ingresarTituloDDBB();

        PersistirEpisodioTitulos persistirEpisodioTitulos = new PersistirEpisodioTitulos();
        persistirEpisodioTitulos.ingresarTituloDDBB();
        
//        ManejoArchivo manejoArchivo = new ManejoArchivo();
//        manejoArchivo.generarArchivosCortos();


    }
}
