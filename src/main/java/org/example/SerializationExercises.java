package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.model.Movie;
import org.model.Session;
import org.model.Theater;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */

    public static class Exercise1 {
        public static void main(String[] args) {

            Movie movie1 = new Movie("Movie1", 100);
            Movie movie2 = new Movie("Movie2", 120);

            Theater theater1 = new Theater("Theater1", "Las Canteras");
            Theater theater2 = new Theater("Theater2", "Triana");

            Session session1 = new Session(movie1, theater1, "2023-10-01 19:00");
            Session session2 = new Session(movie2, theater2, "2023-10-02 15:30");


            Gson gson = new Gson();
            String movie1Json = gson.toJson(movie1); //Cadena como en los ficheros json
            String theater1Json = gson.toJson(theater1);
            String session1Json = gson.toJson(session1);

            String movie2Json = gson.toJson(movie2);
            String theater2Json = gson.toJson(theater2);
            String session2Json = gson.toJson(session2);


            saveToJsonFile(movie1Json, "movie1.json");
            saveToJsonFile(theater1Json, "theater1.json");
            saveToJsonFile(session1Json, "session1.json");
            saveToJsonFile(movie2Json, "movie2.json");
            saveToJsonFile(theater2Json, "theater2.json");
            saveToJsonFile(session2Json, "session2.json");
        }

        private static void saveToJsonFile(String json, String fileName) {
            try (/*Crear el objeto */ FileWriter writer = new FileWriter(fileName) /*Crear el fichero */) {
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream */

        public static class Exercise2 {

            public static void main(String[] args) {

                Gson gson = new Gson();


                try (FileReader reader = new FileReader("movie1.json")) {
                    /*Deserializar Json*/
                    Movie movie1 = gson.fromJson(reader, Movie.class);
                    System.out.println("Movie1 deserializada:\n" + movie1.getTitle() + ", " + movie1.getDuration() + " minutos");

                    /*Serializar con Streams*/
                    FileOutputStream fileOutputStream = new FileOutputStream("movie1_serialized.obj"); //Abrir un archivo de escritura para escribir datos binarios.
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //Abres un flujo de salida

                    objectOutputStream.writeObject(movie1); //Escribir los objetos en el flujo. Para serializar los objetos en Java en un formato binario.
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

            }

        }

        /*
           Deserialize the objects from the binary files created in exercise 2.

            */
        public static class Exercise3 {

             public static void main(String[] args) {

                try {
                    // Abre el archivo binario creado en el ejercicio 2
                    FileInputStream fileInputStream = new FileInputStream("movie1_serialized.obj");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    // Deserializa el objeto Movie desde el archivo binario
                    Movie deserializedMovie1 = (Movie) objectInputStream.readObject(); //Utilizamos typeCasting para pasar de binario a Movie

                    // Cierra el flujo de entrada
                    objectInputStream.close();

                    // Imprime la información del objeto deserializado
                    System.out.println("Movie1 deserializada desde archivo binario:\n" + deserializedMovie1.getTitle() + ", " + deserializedMovie1.getDuration() + " minutos");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }}