package obtenerarchivospequenos.demo.proyecto;

import controllerCSV.demo.proyecto.Controlador;

import java.io.File;
import java.io.IOException;

public class ManejoArchivo{
    public void generarArchivosCortos() {

        try {
            //generates small file for nameBasics
            File nameBasicsInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\name.basics.tsv");
            File nameBasicsOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\name.basics.tsv1");

            Controlador.ArchivoControlador nameBasicsArchivoControlador = new Controlador.ArchivoControlador();
            nameBasicsArchivoControlador.realizarLectura(nameBasicsInput);
            nameBasicsArchivoControlador.exportarDatos(nameBasicsOutput);
            //------------------------------------------------------------------------------------------------------------------
            //generates small file for titleAKAS
            File titleAKASInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.akas.tsv");
            File titleAKASOuput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.akas.tsv1");

            Controlador.ArchivoControlador titleAKASControlador = new Controlador.ArchivoControlador();
            titleAKASControlador.realizarLectura(titleAKASInput);
            titleAKASControlador.exportarDatos(titleAKASOuput);
            //--------------------------------------------------------------------------------------------------------------------


            //------------------------------------------------------------------------------------------------------------------
            //generates small file for titleBasics
            File titleBasicsInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.basics.tsv");
            File titleBasicsOuput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.basics.tsv1");

            Controlador.ArchivoControlador titleBasicsControlador = new Controlador.ArchivoControlador();
            titleBasicsControlador.realizarLectura(titleBasicsInput);
            titleBasicsControlador.exportarDatos( titleBasicsOuput);
            //--------------------------------------------------------------------------------------------------------------------


            //------------------------------------------------------------------------------------------------------------------
            //generates small file for titleCrew
            File titleCrewInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.crew.tsv");
            File titleCrewOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.crew.tsv1");

            Controlador.ArchivoControlador titleCrewControlador = new Controlador.ArchivoControlador();
            titleCrewControlador.realizarLectura(titleCrewInput);
            titleCrewControlador.exportarDatos( titleCrewOutput);
            //--------------------------------------------------------------------------------------------------------------------

            //------------------------------------------------------------------------------------------------------------------
            //generates small file for titleEpisode
            File titleEpisodeInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.episode.tsv");
            File titleEpisodeOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.episode.tsv1");

            Controlador.ArchivoControlador titleEpisodeControlador = new Controlador.ArchivoControlador();
            titleEpisodeControlador.realizarLectura(titleEpisodeInput);
            titleEpisodeControlador.exportarDatos( titleEpisodeOutput);
            //--------------------------------------------------------------------------------------------------------------------

            //------------------------------------------------------------------------------------------------------------------
            //generates small file for titlePrincipals
            File titlePrincipalsInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.principals.tsv");
            File titlePrincipalsOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.principals.tsv1");

            Controlador.ArchivoControlador titlePrincipalsControlador = new Controlador.ArchivoControlador();
            titlePrincipalsControlador.realizarLectura(titlePrincipalsInput);
            titlePrincipalsControlador.exportarDatos(titlePrincipalsOutput);
            //--------------------------------------------------------------------------------------------------------------------

            //generates small file for titleRatings
            File titleRatingInput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\unzipfile\\title.ratings.tsv");
            File titleRatingOutput = new File("C:\\Users\\Sergio_Mendez_G\\Documents\\newFiles\\title.ratings.tsv1");

            Controlador.ArchivoControlador titleRatingControlador = new Controlador.ArchivoControlador();
            titleRatingControlador.realizarLectura(titleRatingInput);
            titleRatingControlador.exportarDatos( titleRatingOutput);
            //--------------------------------------------------------------------------------------------------------------------

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
