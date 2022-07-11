package org.refactor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Persona> personaList = new ArrayList<>();
        File ruta = new File("C:\\Users\\daniel.diez\\Documents\\GitHub\\Formacion\\Ejercicio2\\RefactorJV2\\src\\main\\java\\org\\refactor\\DatosPersona.txt");
        Stream<String> infoPersona;
        String lineasFichero = "";
        String[] infoSplit;

        BufferedReader br = new BufferedReader(new FileReader(ruta));
        try {
            while ((lineasFichero = br.readLine()) != null) {
                infoSplit = lineasFichero.split(":");
                Persona persona = new Persona();

                if (infoSplit.length <= 3) {
                    persona.setNombre(infoSplit[0]);

                } else {
                    persona.setNombre("Desconocida");

                }

                if (infoSplit.length >= 2) {
                    if (infoSplit[1].isEmpty())
                        persona.setPoblacion("Desconocida");
                    else
                        persona.setPoblacion(infoSplit[1]);
                }

                if (infoSplit.length > 2) {
                    persona.setEdad(infoSplit[2]);

                } else {
                    persona.setEdad("Desconocida");
                }

                personaList.add(persona);
            }
        } catch (IOException e) {
            System.out.println(e);

        }

        personaList.stream()
                .filter(p -> p.getNombre() != null && p.getPoblacion() != null && p.getPoblacion() != null
                        && p.getEdad().get() != "Desconocida" && Integer.parseInt(p.getEdad().get()) < 25)
                .forEach(p -> System.out.println("Nombre: " + p.getNombre().get() + " Poblacion: " +
                        p.getPoblacion().get() + " Edad: " + p.getEdad().get()));

    }
}