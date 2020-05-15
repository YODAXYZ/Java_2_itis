package WorkWithURI;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstallHtml {
    public static void main(String[] args) {
//        String path_URI = "https://google.com";
//        URI uri = null;
//
//        try {
//            uri = new URI(path_URI);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StringBuffer stringBuffer = new StringBuffer();
//        try {
//            String line;
//            while ((line = in.readLine()) != null) {
//                stringBuffer.append(line);
//                stringBuffer.append("\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ArrayList<String> allMatches = new ArrayList<String>();
//        Pattern p = Pattern.compile("https:\\/\\/\\S+|http:\\/\\/\\S+");
//        Matcher m = p.matcher(stringBuffer);
//
//        while (true) {
//            while (m.find()) {
//                allMatches.add(m.group());
//            }
//        }

//        Pattern p = Pattern.compile("(<div )");
//        Matcher m = p.matcher(stringBuffer);
//        long matches = m.results().count();
//        System.out.println(matches);
//        downloadHtml("https://tproger.ru");
//        downloadHtml("https://gmpg.org/xfn/11");
        downloadHtml("https://tproger.ru/books/linux/");
    }
    
    private static void downloadHtml (String path_URI) {
        URI uri = null;

        try {
            uri = new URI(path_URI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
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
            }
            else {
                String href = "";
                for (int j = 0; j < allMatches.get(i).length() - 1; j++) {
                    href += allMatches.get(i).charAt(j);
                }
                downloadHtml(href);
            }
        }
    }
}
