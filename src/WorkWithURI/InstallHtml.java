package WorkWithURI;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstallHtml {
    public static void main(String[] args) {
        downloadHtml("https://www.kinopoisk.ru/series/841914/");
    }

    private static void downloadHtml(String path_URI) {
        path_URI = path_URI.toLowerCase();
        URI uri = null;

        try {
            uri = new URI(path_URI);
        } catch (URISyntaxException e) {
            System.out.println("Error with path URL " + path_URI);
            return;
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer stringBuffer = new StringBuffer();
        try {
            String line;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/WorkWithURI/HTML/" + path_URI.replace("/", "_") + ".txt"));
            bufferedWriter.write(String.valueOf(stringBuffer));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuffer.toString());

        ArrayList<String> allMatches = new ArrayList<String>();
        Pattern p = Pattern.compile("https:\\/\\/\\S+|http:\\/\\/\\S+");
        Matcher m = p.matcher(stringBuffer);

        while (m.find()) {
            allMatches.add(m.group());
        }

        for (int i = 0; i < allMatches.size(); i++) {
            File tmpDir = new File("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/WorkWithURI/HTML" + allMatches.get(i).replace("/", "_") + ".txt");
            boolean exists = tmpDir.exists();
            if (exists) {
                continue;
            } else {
                String href = "";
                for (int j = 0; j < allMatches.get(i).length() - 1; j++) {
                    href += allMatches.get(i).charAt(j);
                }
                downloadHtml(href);
            }
        }
    }
}

