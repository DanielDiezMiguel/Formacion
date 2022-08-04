package com.bosonit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jva2Application {
    public static void main(String[] args) throws IOException {
        List<Persona> personaList = new ArrayList<>();
        File ruta = new File("src/main/java/com/bosonit/DatosPersona.txt");
        String lineasFichero = "";
        String[] infoSplit;
        String nombre = "";
        String poblacion = "";
        String edad = "";

        BufferedReader br = new BufferedReader(new FileReader(ruta));
        try {
            while ((lineasFichero = br.readLine()) != null) {
                infoSplit = lineasFichero.split(":");

                if (infoSplit.length <= 3) nombre = infoSplit[0];
                else nombre = "Desconocida";

                if (infoSplit.length >= 2)
                    if (infoSplit[1].isEmpty()) poblacion = "Desconocida";
                    else poblacion = infoSplit[1];

                if (infoSplit.length > 2) edad = infoSplit[2];
                else edad = "Desconocida";

                personaList.add(new Persona(nombre, poblacion, edad));
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        personaList.stream()
                .filter(persona -> persona != null
                        && !persona.edad().equals("Desconocida")
                        && Integer.parseInt(persona.edad()) < 25)
                .forEach(persona -> System.out.println(persona));
    }
}