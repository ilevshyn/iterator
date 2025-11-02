package edu.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TextSource implements Iterable<String> {
    private ArrayList<String> characters;
    private ArrayList<String> words;

    public TextSource(String text) {
        this.characters = new ArrayList<>();
        this.words = new ArrayList<>();
        for (char c : text.toCharArray()) {
            characters.add((String.valueOf(c)));
        }
        try (Scanner scanner = new Scanner(text)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return characters.iterator();
    }

    public Iterator<String> wordIterator() {
        return words.iterator();
    }

}
