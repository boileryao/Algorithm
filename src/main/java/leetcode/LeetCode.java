package leetcode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by boileryao on 2018/3/23.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
public @interface LeetCode {
    int id();

    String problemName();

    String tag() default "[]";

    boolean accepted() default true;

    Level level() default Level.UNDEFINED;

    enum Level {EASY, MEDIUM, HARD, UNDEFINED}
}
