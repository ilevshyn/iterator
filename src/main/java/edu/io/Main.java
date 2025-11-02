package edu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    static void main(String[] args) {
        if (args.length == 2) {
            switch (args[0]) {
                case "c" -> {
                    System.out.println("Iterating over character in " + args[1]);
                    try (BufferedReader br = new BufferedReader(new FileReader(args[1]))) {
                        int character;
                        while ((character = br.read()) != -1) {
                            System.out.println((char) character);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "w" -> {
                    System.out.println("Iterating over words in " + args[1]);
                    try (Scanner sc = new Scanner(new File(args[1]))) {
                        while (sc.hasNext()) {
                            String word = sc.next();
                            System.out.println(word);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "s" -> {
                    System.out.println("Iterating over sentences in " + args[1]);
                    try (Scanner sc = new Scanner(new File(args[1]))) {
                        Pattern pattern = Pattern.compile("[^.!?]+[.!?]+");
                        while (sc.findWithinHorizon(pattern, 0) != null) {
                            MatchResult match = sc.match();
                            System.out.println(match.group());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "n" -> {
                    System.out.println("Iterating over numbers in " + args[1]);
                    try (Scanner sc = new Scanner(new File(args[1]))) {
                        while (sc.hasNext()) {
                            if (sc.hasNextInt()) {
                                int number = sc.nextInt();
                                System.out.println(number);
                            } else if (sc.hasNextDouble()) {
                                double number = sc.nextDouble();
                                System.out.println(number);
                            } else {
                                sc.next();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "p" -> {
                    System.out.println("Iterating over custom regex" + args[0] + "in " + args[1]);
                    try (Scanner sc = new Scanner(new File(args[1]))) {
                        Pattern pattern = Pattern.compile(args[0]);
                        while (sc.findWithinHorizon(pattern, 0) != null) {
                            MatchResult match = sc.match();
                            System.out.println(match.group());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> throw new IllegalArgumentException("Illegal command line argument");
            }
        } else if (args.length == 1) {
            switch (args[0]) {
                case "c" -> {
                    System.out.println("Iterating over character from input");
                    System.out.println("Enter text to iterate over");
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                        int character;
                        while ((character = br.read()) != -1) {
                            System.out.println((char) character);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "w" -> {
                    System.out.println("Iterating over words from input");
                    System.out.println("Enter text to iterate over");
                    try (Scanner sc = new Scanner(System.in)) {
                        while (sc.hasNext()) {
                            String word = sc.next();
                            System.out.println(word);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "s" -> {
                    System.out.println("Iterating over sentences from input");
                    try (Scanner sc = new Scanner(System.in)) {
                        Pattern pattern = Pattern.compile("[^.!?]+[.!?]+");
                        while (sc.findWithinHorizon(pattern, 0) != null) {
                            MatchResult match = sc.match();
                            System.out.println(match.group());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "n" -> {
                    System.out.println("Iterating over numbers from input");
                    System.out.println("Enter text to iterate over");
                    try (Scanner sc = new Scanner(System.in)) {
                        while (sc.hasNext()) {
                            if (sc.hasNextInt()) {
                                int number = sc.nextInt();
                                System.out.println(number);
                            } else if (sc.hasNextDouble()) {
                                double number = sc.nextDouble();
                                System.out.println(number);
                            } else {
                                sc.next();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "p" -> {
                    System.out.println("Iterating over custom regex" + args[0] + "from input");
                    try (Scanner sc = new Scanner(System.in)) {
                        Pattern pattern = Pattern.compile(args[0]);
                        while (sc.findWithinHorizon(pattern, 0) != null) {
                            MatchResult match = sc.match();
                            System.out.println(match.group());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> throw new IllegalArgumentException("Illegal command line argument");
            }
        }
    }
}