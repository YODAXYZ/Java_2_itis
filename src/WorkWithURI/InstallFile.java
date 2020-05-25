package WorkWithURI;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class InstallFile {
    public static String main(String[] args) throws URISyntaxException, IOException {
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

//        File tmpDir = new File("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/WorkWithURI/HTML" + allMatches.get(i).replace("/", "_") + ".txt");
//        boolean exists = tmpDir.exists();
//        if (exists) {
//            return "Этот файл существует";
//        } else {
//            String href = "";
//            for (int j = 0; j < allMatches.get(i).length() - 1; j++) {
//                href += allMatches.get(i).charAt(j);
//            }
//            downloadHtml(href);
//        }

        return path_uri;
    }
}

