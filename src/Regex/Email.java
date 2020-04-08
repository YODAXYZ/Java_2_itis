package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static void main(String[] args) {
        String email = "ka1yoda@gmail.com";
        Pattern p = Pattern.compile("((\\w|(\\.))+@((\\w+\\.{0,1})){1,})\\w+");
        Matcher m = p.matcher(email);

        if (m.find()) {
            if (email.length() == m.end() - m.start()) {
                System.out.println("This is email " + email.substring(m.start() , m.end()) );

                Pattern q = Pattern.compile("(?:@\\w+)|(?:(?:\\.\\w+$))");
                Matcher v = q.matcher(email);
                while (v.find()) {
                    System.out.println(email.substring(v.start() , v.end()));
                }
            } else {
                System.out.println("Isn't email");
            }
        }else {
            System.out.println("Isn't email");
        }
    }
}
