package interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by boileryao on 2018/4/27.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class SentenceRegulation {
    private static Pattern pattern;

    public static void main(String[] args) {
        pattern = Pattern.compile(".*?([^0123456789]{2,})\\1.*?");
        Scanner in = new Scanner(System.in);
        String res;

        String sentence;
        try {
            sentence = in.nextLine();
        } catch (Exception e) {
            sentence = null;
        }

        res = removeDuplicate(sentence);
        System.out.println(res);
    }

    public static String removeDuplicate(String string) {
        while (true) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                String duplicate = matcher.group(1);
                string = string.replaceAll("(" + duplicate + ")" + "{2,}", duplicate);
            } else {
                break;
            }
        }
        return string;
    }


}
