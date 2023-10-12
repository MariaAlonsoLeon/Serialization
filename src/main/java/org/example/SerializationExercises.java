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
            String movie1Json = gson.toJson(movie1);
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
            try (FileWriter writer = new FileWriter(fileName)) {
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
                    Movie movie1 = gson.fromJson(reader, Movie.class);
                    System.out.println("Movie1 deserializada: " + movie1.getTitle() + ", " + movie1.getDuration() + " minutos");

                    FileOutputStream fileOutputStream = new FileOutputStream("movie1_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(movie1);
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

                try (FileReader reader = new FileReader("movie2.json")) {
                    Movie movie2 = gson.fromJson(reader, Movie.class);
                    System.out.println("Movie2 deserializada: " + movie2.getTitle() + ", " + movie2.getDuration() + " minutos");

                    FileOutputStream fileOutputStream = new FileOutputStream("movie2_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(movie2);
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

                try (FileReader reader = new FileReader("theater1.json")) {
                    Theater theater1 = gson.fromJson(reader, Theater.class);
                    System.out.println("Teatro1 deserializado: " + theater1.getName() + ", " + theater1.getLocation());

                    FileOutputStream fileOutputStream = new FileOutputStream("theater1_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(theater1);
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

                try (FileReader reader = new FileReader("theater2.json")) {
                    Theater theater2 = gson.fromJson(reader, Theater.class);
                    System.out.println("Teatro2 deserializado: " + theater2.getName() + ", " + theater2.getLocation());

                    FileOutputStream fileOutputStream = new FileOutputStream("theater2_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(theater2);
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

                try (FileReader reader = new FileReader("session1.json")) {
                    Session sesion1 = gson.fromJson(reader, Session.class);
                    System.out.println("Sesión1 deserializada: " + sesion1.getMovie() + ", " + sesion1.getTheater() + ", " + sesion1.getTime());

                    FileOutputStream fileOutputStream = new FileOutputStream("session1_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(sesion1);
                    objectOutputStream.close();
                } catch (IOException | JsonSyntaxException e) {
                    e.printStackTrace();
                }

                try (FileReader reader = new FileReader("session2.json")) {
                    Session sesion2 = gson.fromJson(reader, Session.class);
                    System.out.println("Sesión2 deserializada: " + sesion2.getMovie() + ", " + sesion2.getTheater() + ", " + sesion2.getTime());

                    FileOutputStream fileOutputStream = new FileOutputStream("session2_serialized.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(sesion2);
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
                    FileInputStream fileInputStream = new FileInputStream("movie1_serialized.obj");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Movie deserializedMovie1 = (Movie) objectInputStream.readObject();
                    objectInputStream.close();

                    System.out.println("Movie1 deserializada: " + deserializedMovie1.getTitle() + ", " + deserializedMovie1.getDuration() + " minutos");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                 try {
                     FileInputStream fileInputStream = new FileInputStream("movie2_serialized.obj");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                     Movie deserializedMovie2 = (Movie) objectInputStream.readObject();
                     objectInputStream.close();

                     System.out.println("Movie2 deserializada: " + deserializedMovie2.getTitle() + ", " + deserializedMovie2.getDuration() + " minutos");
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }

                 try {
                     FileInputStream fileInputStream = new FileInputStream("theater1_serialized.obj");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                     Theater deserializedTheater1 = (Theater) objectInputStream.readObject();
                     objectInputStream.close();

                     System.out.println("Theater1 deserializado: " + deserializedTheater1.getName() + ", " + deserializedTheater1.getLocation());
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }

                 try {
                     FileInputStream fileInputStream = new FileInputStream("theater2_serialized.obj");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                     Theater deserializedTheater2 = (Theater) objectInputStream.readObject();
                     objectInputStream.close();

                     System.out.println("Theater2 deserializado: " + deserializedTheater2.getName() + ", " + deserializedTheater2.getLocation());
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }

                 try {
                     FileInputStream fileInputStream = new FileInputStream("session1_serialized.obj");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                     Session deserializedSession1 = (Session) objectInputStream.readObject();
                     objectInputStream.close();

                     System.out.println("Session1 deserializada: " + deserializedSession1.getMovie() + ", " + deserializedSession1.getTheater() + ", " + deserializedSession1.getTime());
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }

                 try {
                     FileInputStream fileInputStream = new FileInputStream("session2_serialized.obj");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                     Session deserializedSession2 = (Session) objectInputStream.readObject();
                     objectInputStream.close();

                     System.out.println("Session2 deserializada: " + deserializedSession2.getMovie() + ", " + deserializedSession2.getTheater() + ", " + deserializedSession2.getTime());
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }
            }
        }
    }
}