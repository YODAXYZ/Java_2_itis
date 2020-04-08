package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Href {
    public static void main(String[] args) {
        String href = "https://habr.com/";
        Pattern p = Pattern.compile("\\/\\/\\S+?\\/+");
        Matcher m = p.matcher(href);
        while(m.find()){
            System.out.println(href.substring(m.start() + 2,m.end() - 1));
        }
    }
}
