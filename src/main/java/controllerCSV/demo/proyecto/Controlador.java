/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerCSV.demo.proyecto;


import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author Sergio_Mendez_G
 */
public class Controlador {
    
     public static class ArchivoControlador {

        private static final int MAX = 1000;

        private int intLine = 0;

        private final StringBuilder stringBuilder;

        public ArchivoControlador() {
            this.stringBuilder = new StringBuilder();
        }

        public boolean esLineaValidaDeLectura() {
            return intLine <= MAX;
        }

        private void sumarLinea() {
            this.intLine++;
        }

        private void agregarLinea(String linea) {
            this.stringBuilder.append(linea).append("\n");
            this.sumarLinea();
        }

        public void exportarDatos(File path) throws IOException {

            try (FileOutputStream outputStream = new FileOutputStream(path)) {
                outputStream.write(this.stringBuilder.toString().getBytes());
            }
        }

        public void realizarLectura(File input) throws IOException {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {

                bufferedReader
                        .lines()
                        .takeWhile(p -> this.esLineaValidaDeLectura())
                        .forEach(this::agregarLinea);
            }
        }
    }

    public static class DTOParser {

        private InputStream getInputStream(InputStream in) throws IOException {

            PushbackInputStream testin = new PushbackInputStream(in);
            int ch = testin.read();
            if (ch != 0xEF) {
                testin.unread(ch);
            } else if ((ch = testin.read()) != 0xBB) {
                testin.unread(ch);
                testin.unread(0xef);
            } else if (testin.read() != 0xBF) {
                throw new IOException("Bad UTF-8 format file");
            } else {
            }
            return testin;
        }

        public <T> List<T> parse(Class<T> clazz, File input) throws IOException {

            try (FileInputStream bais = new FileInputStream(input)) {
                try (Reader reader = new InputStreamReader(this.getInputStream(bais), Charset.forName("UTF-8"))) {
                    return new CsvToBeanBuilder<T>(reader)
                            .withType(clazz)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator('\t')
                            .build()
                            .parse();
                }
            }

        }
    }
    
}
