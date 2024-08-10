package WordGuess;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Application {

    public static int attempts = 3;
    public static Character[] letters = { 'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z' };
    public static String[] words = { "computer", "mathematics", "football", "software", "fenerbahçe", "man", "ball",
            "phone", "table", "house", "poster", "cansu" };

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;
        int index = random.nextInt(words.length);
        String selectedWord = words[index];

        System.out.print("Word to guess: ");
        char[] hiddenWord = new char[selectedWord.length()];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
            System.out.print(hiddenWord[i]);
        }

        // Create a set to store guessed letters
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println();

        while (continueGame) {

            System.out.print("\nIf you want to see the available letters, you can type 'Letters'."
                    + "\nPlease enter the letter or word you want to guess: ");
            String guess = scanner.next().toLowerCase();

            if (guess.length() > 1) {
                if (guess.equals("letters")) {
                    System.out.println();
                    System.out.print("Available letters: ");
                    for (int i = 0; i < letters.length; i++) {
                        System.out.print(letters[i] + " ");
                    }
                    System.out.println();
                    System.out.println("\n---------------------------------------------------------------------\n");
                    System.out.println("Used letters: " + guessedLetters);
                    System.out.println();
                    System.out.print("Guessed word: ");
                    for (char c : hiddenWord) {
                        System.out.print(c);
                    }
                    System.out.println();
                } else if (guess.equals(selectedWord)) {
                    System.out.println("\n---------------------------------------------------------------------\n");
                    System.out.println("Congratulations! You guessed the word correctly.\n");
                    System.out.print("Guessed word: " + selectedWord);
                    System.out.println();
                    continueGame = false;
                } else {
                    System.out.println("Incorrect guess :(");
                    attempts--;
                    System.out.println("Remaining attempts: " + attempts);
                    System.out.println("\n---------------------------------------------------------------------\n");
                    System.out.println("Used letters: " + guessedLetters);
                    if (attempts == 0) {
                        continueGame = false;
                        System.out.println("Unfortunately, you ran out of attempts and couldn't guess the word.\n"
                                + "\nThe word was: " + selectedWord);
                        continue;
                    }

                }
            } else {
                char guessedLetter = guess.charAt(0);
                // Check if the letter is valid
                if (!Set.of(letters).contains(guessedLetter)) {
                    System.out.println("\nYou entered an invalid letter. Please enter a letter from the alphabet.\n");
                    System.out.print("Available letters: ");
                    for (int i = 0; i < letters.length; i++) {
                        System.out.print(letters[i] + " ");
                    }
                    System.out.println();
                    System.out.println("\n---------------------------------------------------------------------\n");
                } else if (guessedLetters.contains(guessedLetter)) {
                    System.out.println("You have already used this letter '" + guessedLetter + "'.");
                    System.out.println("\n---------------------------------------------------------------------\n");
                    System.out.println("Used letters: " + guessedLetters);
                    System.out.println();
                } else {
                    guessedLetters.add(guessedLetter);

                    boolean letterFound = false;
                    for (int i = 0; i < selectedWord.length(); i++) {
                        if (selectedWord.charAt(i) == guessedLetter) {
                            hiddenWord[i] = guessedLetter;
                            letterFound = true;
                        }
                    }

                    if (letterFound) {
                        System.out.println("Correct guess!");
                        System.out.println("\n---------------------------------------------------------------------\n");
                        System.out.println("Used letters: " + guessedLetters);
                        System.out.println();
                    } else {
                        System.out.println("Incorrect guess :(");
                        attempts--;
                        System.out.println("Remaining attempts: " + attempts);
                        System.out.println("\n---------------------------------------------------------------------\n");
                        if (attempts == 0) {
                            continueGame = false;
                            System.out.println("\nUnfortunately, you ran out of attempts and couldn't guess the word."
                                    + "\nThe word was: " + selectedWord);
                            continue;
                        }
                        System.out.println("Used letters: " + guessedLetters);
                        System.out.println();

                    }

                    if (new String(hiddenWord).equals(selectedWord)) {
                        System.out.println("Congratulations! You guessed the word correctly.\n");
                        continueGame = false;
                    }
                    System.out.print("Guessed word: ");
                    for (char c : hiddenWord) {
                        System.out.print(c);
                    }
                    System.out.println();
                }
            }
        }
    }
}
