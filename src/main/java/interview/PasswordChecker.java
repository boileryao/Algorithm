package interview;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by boileryao on 2018/8/28.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 * <p>
 * 1.长度**超过**8位
 * 2.包括大小写字母.数字.其它符号,以上四种**至少三**种
 * 3.不能有相同长度**超**2的子串重复
 * </p>
 */
public class PasswordChecker {
    private static Pattern pattern = Pattern.compile(".*?(.{3,}).*?\\1.*?");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.forEachRemaining(s -> System.out.println(isValidPassword(s) ? "OK" : "NG"));
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() <= 8) {
            return false;
        }

        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        boolean containsDigit = false;
        boolean containsOtherSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                containsLowerCase = true;
                continue;
            }
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
                continue;
            }
            if (Character.isDigit(c)) {
                containsDigit = true;
                continue;
            }
            containsOtherSymbol = true;
        }
        int symbolTypeCount = (containsDigit ? 1 : 0) + (containsLowerCase ? 1 : 0)
                + (containsUpperCase ? 1 : 0) + (containsOtherSymbol ? 1 : 0);
        if (symbolTypeCount < 3) return false;

        return !pattern.matcher(password).matches();
    }
}
