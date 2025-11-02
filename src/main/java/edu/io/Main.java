package edu.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    static void main(String[] args) throws IOException {
        TextSource source;
        if (args.length == 2) {
            Path path = Path.of(args[1]);
            String fileContent = Files.readString(path, StandardCharsets.UTF_8);
            source = new TextSource(fileContent);
        } else if (args.length == 1) {
            String input = new String(System.in.readAllBytes(), StandardCharsets.UTF_8);
            source = new TextSource(input);
        } else {
            throw new IllegalArgumentException("Not enough arguments");
        }
        performIteration(args[0], source);
    }

    public static void performIteration(String param, TextSource source) {
        switch (param) {
            case "c" -> {
                System.out.println("Iterating over character");
                for (String c : source) {
                    System.out.println(c);
                }
            }
            case "w" -> {
                System.out.println("Iterating over words");
                for (Iterator<String> it = source.wordIterator(); it.hasNext(); ) {
                    var w = it.next();
                    System.out.println(w);
                }
            }
            case "s" -> {
                System.out.println("Iterating over sentences");
                for (Iterator<String> it = source.sentenceIterator(); it.hasNext(); ) {
                    var s = it.next();
                    System.out.println(s);
                }
            }
            case "n" -> {
                System.out.println("Iterating over numbers");
                for (Iterator<String> it = source.numberIterator(); it.hasNext(); ) {
                    var n = it.next();
                    System.out.println(n);
                }
            }
            case "r" -> {
                System.out.println("Enter regex");
                String regex;
                try (Scanner sc = new Scanner(System.in)) {
                    regex = sc.next();
                }
                System.out.println("Iterating over custom regex " + regex);
                for (Iterator<String> it = source.regexIterator(regex); it.hasNext(); ) {
                    var r = it.next();
                    System.out.println(r);
                }
            }
            default -> throw new IllegalArgumentException("Argument not recognized");
        }
    }
}