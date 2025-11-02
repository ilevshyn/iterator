package edu.io;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TextSource implements Iterable<String> {
    private final String text;
    private ArrayList<String> it;

    public TextSource(String text) {
        this.text = text;
    }


    @Override
    public Iterator<String> iterator() {
        this.it = new ArrayList<>();
        for (char c : this.text.toCharArray()) {
            it.add((String.valueOf(c)));
        }
        return it.iterator();
    }

    public Iterator<String> wordIterator() {
        this.it = new ArrayList<>();
        try (Scanner scanner = new Scanner(this.text)) {
            while (scanner.hasNext()) {
                it.add(scanner.next());
            }
        }
        return it.iterator();
    }

    public Iterator<String> sentenceIterator() {
        this.it = new ArrayList<>();
        try (Scanner sc = new Scanner(this.text)) {
            Pattern pattern = Pattern.compile("[^.!?]+[.!?]+");
            while (sc.findWithinHorizon(pattern, 0) != null) {
                MatchResult match = sc.match();
                it.add(match.group().trim());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return it.iterator();
    }

    public Iterator<String> numberIterator() {
        return this.regexIterator("-?\\d+(\\.\\d+)?"
        );
    }

    public Iterator<String> regexIterator(String regex) {
        this.it = new ArrayList<>();
        try (Scanner sc = new Scanner(this.text)) {
            Pattern pattern = Pattern.compile(regex);
            while (sc.findWithinHorizon(pattern, 0) != null) {
                MatchResult match = sc.match();
                it.add(match.group().trim());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return it.iterator();
    }

    public Iterator<String> regexIterator() {
        this.it = new ArrayList<>();
        return it.iterator();
    }
}
