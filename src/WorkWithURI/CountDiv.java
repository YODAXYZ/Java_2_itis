package WorkWithURI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountDiv {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);
        String path_URI = scanner.next();
        URI uri = new URI(path_URI);
        BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }

        ArrayList<String> div = new ArrayList<>();
        for (String s : stringBuffer.toString().split("(<div)")) {
            div.add(s);
        }

        System.out.println(div.size() - 1);

    }

}
