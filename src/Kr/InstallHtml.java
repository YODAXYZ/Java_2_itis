package Kr;

import org.ini4j.Ini;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class InstallHtml {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String cocktail = scanner.nextLine();
        String path_uri = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktail;


        URI uri = null;
        try {
            uri = new URI(path_uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while (true) {
            try {
                if (!((line = in.readLine()) != null)) break;
                if (line.equals("{\"drinks\":null}")) {
                    throw new IOException("Такого напитка нет !!! ");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }

        File file = new File("" + cocktail);
        //Creating the directory
        boolean bool = file.mkdir();
        if(bool){
            System.out.println("Directory created successfully");
        }
        else{
            System.out.println("Sorry couldn’t create specified directory");
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/" + cocktail + "/" + cocktail + ".json", true)));
            out.println(stringBuffer.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
