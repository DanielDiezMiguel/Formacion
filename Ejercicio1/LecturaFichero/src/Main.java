import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //Path path = Paths.get("src/DatosPersona.txt");
        //Stream<String> ficheroTXT = Files.lines(path);
        List<Persona> personaList = new ArrayList<>();
        File ruta = new File("src/DatosPersona.txt");
        String lineasFichero = "";
        String[] infoSplit;

        BufferedReader br = new BufferedReader(new FileReader(ruta));
        try {
            while ((lineasFichero = br.readLine()) != null) {
                infoSplit = lineasFichero.split(":");
                Persona persona = new Persona();
                //Optional<String> name = Optional.ofNullable(infoSplit[0]);
                //Optional<String> location = Optional.ofNullable(infoSplit[1]);
                //Optional<String> age = Optional.ofNullable(infoSplit[2]);

                if (infoSplit[0].isEmpty() || infoSplit[0] != null && infoSplit.length < 2) {
                    persona.setNombre(infoSplit[0]);

                } else {
                    persona.setNombre("Desconocida");

                } if (infoSplit[1].isEmpty() || infoSplit[1] != null && infoSplit.length < 2) {
                    persona.setPoblacion(infoSplit[1]);

                } else {
                    persona.setPoblacion("Desconocida");

                } if (infoSplit.length >= 2) {
                    if (infoSplit[2].isEmpty() || infoSplit[2] != null)
                        persona.setEdad(infoSplit[2]);

                } else {
                    persona.setEdad("Desconocida");
                }
                personaList.add(persona);
                System.out.println(persona.getNombre());
            }
        } catch (IOException e){
            System.out.println(e);
            
        }





/*
        personaList.add(new Persona(
                String.valueOf(lecturaFichero.map(name -> name.split(":")[0]).collect(Collectors.toList())),
                String.valueOf(lecturaFichero.map(location -> location.split(":")[1]).collect(Collectors.toList())),
                Integer.parseInt(String.valueOf((lecturaFichero.map(age -> age.split(":")[2]).collect(Collectors.toList()))))
    )
        );


        persona1.setNombre(name
                .map(n -> n.split(":")[0])
                .collect(Collectors.toList())
                .get(0)
        );

        persona1.setPoblacion(poblacion
                .map(e -> e.split(":")[1])
                .collect(Collectors.toList())
                .get(0));

        System.out.println(persona1.getNombre().stream().toList());
        System.out.println(persona1.getPoblacion().stream().toList());

                personaConstructor = new Persona(
                name
                        .map(n -> n.split(":")[0])
                        .toList()
                        .get(0),
                poblacion
                        .map(p -> p.split(":")[1])
                        .toList()
                        .get(0),
               Integer.parseInt(edad
                       .map(e -> e.split(":")[2])
                       .toList()
                       .get(0)
               )
        );

        System.out.println(personaConstructor.getNombre());
        System.out.println(edad
                .map(e -> e.split(":")[2])
                .collect(Collectors.toList())
                .get(0)
        );

 */



   //     name.forEach(System.out::println);


        //System.out.println(lecturaFichero
        //      .map(location -> location.split(":")[1])
        //    .collect(Collectors.toList())
        //);
    }
}