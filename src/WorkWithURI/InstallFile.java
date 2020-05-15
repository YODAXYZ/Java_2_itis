package WorkWithURI;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class InstallFile {
    public static void main(String[] args) throws URISyntaxException, IOException {
        String path_uri = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";
        URI uri = new URI(path_uri);
        BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)));
            out.println(stringBuffer.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

