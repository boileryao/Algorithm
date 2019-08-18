package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by boileryao on 2018/8/29.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 * <p>
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * Input: 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * Output: 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开
 * </p>
 */
public class NaiveLogger {
    private static final int CAP = 8;
    private static final Map<String, Integer> logBase = new HashMap<>(CAP);
    private static final Queue<String> logQueue = new LinkedBlockingDeque<>(CAP);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String filePath = scanner.next();
            if (!scanner.hasNextInt()) continue;

            int lineNumber = scanner.nextInt();
            processLog(filePath, lineNumber);
        }
        output();
    }

    public static void reset() {
        logBase.clear();
        logQueue.clear();
    }

    public static void output() {
        logQueue.forEach((lineInfo) -> {
            int count = logBase.get(lineInfo);
            System.out.println(String.format("%s %d", lineInfo, count));
        });
    }

    public static void processLog(String filePath, int lineNumber) {
        String fileName = getNormalizedFileName(filePath);
        String key = fileName + " " + lineNumber;

        if (logBase.containsKey(key)) {
            logBase.put(key, logBase.get(key) + 1);
            return;
        }

        if (logQueue.size() >= 8) {
            String oldest = logQueue.poll();
            logBase.remove(oldest);
        }
        logQueue.add(key);
        logBase.put(key, 1);
    }

    private static String getNormalizedFileName(String filePath) {
        filePath = filePath.replaceAll(".*\\\\", "");
        if (filePath.length() > 16) filePath = filePath.substring(filePath.length() - 16, filePath.length());
        return filePath;
    }
}
