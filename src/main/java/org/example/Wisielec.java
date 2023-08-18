package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    ArrayList<String> words = new ArrayList<String>();
    String word;
    char[] guessWord;
    int lives = 3;
    public void game() {
        Scanner scanner = new Scanner(System.in);
        words.add("komputer");
        words.add("programowanie");
        words.add("nauka");
        words.add("praca");
        words.add("gra");
        words.add("zabawa");

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));
        guessWord = new char[word.length()];
        Arrays.fill(guessWord, '_');

        while (!gameEnd()) {
            System.out.println(guessWord);
            System.out.println("Pozostało żyć: " + lives);
            System.out.println("Podaj literę: ");
            char letter = scanner.nextLine().charAt(0);
            char lowerLetter = Character.toLowerCase(letter);

            checkLetter(lowerLetter);
            }
        if (lives == 0) {
            System.out.println("Nie zgałeś hasła. Przegrywasz");
        } else {
            System.out.println("Zgadłeś hasło. Wygrywasz");
        }
    }
    private void checkLetter(char lowerLetter) {
        boolean foundLetter = false;
        for (int i=0; i<word.length(); i++) {
            if(word.charAt(i) == lowerLetter) {
                guessWord[i] = lowerLetter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            System.out.println("Nie ma takiej litery");
            lives--;
        }
    }

    private boolean gameEnd() {
        return lives == 0 || word.equals(String.valueOf(guessWord));
    }
}
