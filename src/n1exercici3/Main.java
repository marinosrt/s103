package n1exercici3;

import java.io.*;
import java.util.*;
import static n1exercici3.Tools.getString;
import static n1exercici3.Tools.getInt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args ) throws Exception {
        int klk;
        // read text file to HashMap
        Map<String, String> mapFromFile = HashMapFromTextFile();

        do {
            System.out.println("Que vols fer?\n" +
                    "1. Jugar.\n" +
                    "2. Sortir.");
            klk = getInt("Tria una opció");

            switch (klk){
                case 1:
                    int score = 0;
                    String playersName;
                    playersName = getString("Quin és el teu nom?");
                    score = guessCapitals(mapFromFile, score, playersName);
                    System.out.println("Ja has fet 10 intents. " + playersName + ", la teva puntuació és de " + score);
                    break;
                case 2:
                    System.out.println("Adeu!");
                    break;
            }


        } while (klk != 2);

    }


    public static Map<String, String> HashMapFromTextFile(){

        Map<String, String> map = new HashMap<String, String>();
        BufferedReader br = null;

        try {

            // crear file object
            File file = new File("src/n1exercici3/countries.txt");

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // llegir arxiu linea per linea
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()){
                    String[] parts = line.split(" ");

                    String country = parts[0].trim();
                    String capital = parts[1].trim();

                    if (!country.equals("") && !capital.equals("")){
                        map.put(country, capital);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return map;
    }

    public static int guessCapitals(Map<String, String> mapFromFile, int score, String playersName){
        int i = 10;
        String resp = "";

        do{
            Object[] capitalsG = mapFromFile.keySet().toArray();
            Object key = capitalsG[new Random().nextInt(capitalsG.length)];
            resp = getString("Encerta la capital de: " + key);
            if (resp.equalsIgnoreCase(mapFromFile.get(key))){
                System.out.println("Correcte!");
                score++;
            } else {
                System.out.println("No és correcte, la capital és " + mapFromFile.get(key));
            }
            i--;
        } while (i > 0);

        createFile(playersName, score);

        return score;
    }

    public static void createFile(String playersName, int score){

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = playersName + " : " + score + " points.\n";
            File file = new File("src/n1exercici3/classificacio.txt");

            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }

            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("información agregada!");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}