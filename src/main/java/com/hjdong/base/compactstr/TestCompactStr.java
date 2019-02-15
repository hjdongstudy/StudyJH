package com.hjdong.base.compactstr;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCompactStr {

    /* Require Java 9 To Execute This Code. Please Download From Following Link - http://jdk.java.net/9/ */

    /* Java 8 and previous String Implementation */
//    private final char value[];

    /* Java 9 String Implementation */
//    private final byte[] value;
//    private final byte coder;

    /* Java 9 Coder Implementation */
    static final byte LATIN1 = 0;
    static final byte UTF16 = 1;

    /* Java 9 - Testing String Performance */
    public void testStringPerformance() {
        long launchTime = System.currentTimeMillis();
        List<String> strings = IntStream.rangeClosed(1, 10_000_000).mapToObj(Integer::toString).collect(Collectors.toList());
        long runTime = System.currentTimeMillis() - launchTime;
        System.out.println("Generated " + strings.size() + " strings in " + runTime + " ms.");

        launchTime = System.currentTimeMillis();
        String appended = strings.stream().limit(100_000).reduce("", (left, right) -> left + right);
        runTime = System.currentTimeMillis() - launchTime;
        System.out.println("Created string of length " + appended.length() + " in " + runTime + " ms.");
    }
}
