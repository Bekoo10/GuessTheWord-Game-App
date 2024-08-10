#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <conio.h>
#include <stdbool.h>

#define MAX_WORD_LENGTH 20
#define MAX_GUESS_LIMIT 3

const char* words[] = {"computer", "programming", "developer", "hello", "coding", "learning", "success", "fenerbahce", "mathematics", "keyboard"};

void welcomeMessage(){
	
	printf("\n\n\n\n\n\n\n\n\n");
	printf("\n\t\t\t\t\t-\t\t\t\t\t-");
	printf("\n\t\t\t\t|\t\t\t\t\t\t\t|");
	printf("\n\t\t\t\t|\t\tWelcome to the Word Game\t\t|");
	printf("\n\t\t\t\t|\t\t\t\t\t\t\t|");
	printf("\n\t\t\t\t\t-\t\t\t\t\t-");
	printf("\n\n\n\n");
    getch();
    system("cls");
	
}

void startGame() {
    srand(time(0));

    int totalWordCount = sizeof(words) / sizeof(words[0]);
    int randomIndex = rand() % totalWordCount;

    const char* selectedWord = words[randomIndex];

    int wordLength = strlen(selectedWord);
    char* guessedWord = (char*)malloc((wordLength + 1) * sizeof(char));

    for (int i = 0; i < wordLength; i++) {
        guessedWord[i] = '_';
    }

    guessedWord[wordLength] = '\0';

    int remainingGuesses = MAX_GUESS_LIMIT;
    while (remainingGuesses > 0) {
        printf("Guessed word: %s\n", guessedWord);
        printf("Remaining guesses: %d\n", remainingGuesses);
        char guess;
        printf("Guess a letter: ");
        scanf(" %c", &guess);
        printf("\n------------------------------------------------------------\n\n");
        
        int correctGuess = 0;

        for (int i = 0; i < wordLength; i++) {
            if (selectedWord[i] == guess) {
                guessedWord[i] = guess;
                correctGuess = 1;
            }
        }

        if (!correctGuess) {
            remainingGuesses--;
            printf("Incorrect guess! Remaining guesses: %d\n", remainingGuesses);
            if (remainingGuesses == 0){
            	printf("The word was: %s\n", selectedWord);
			}
        }

        if (strcmp(selectedWord, guessedWord) == 0) {
            printf("Congratulations! You guessed the word correctly: %s\n", selectedWord);
            break;
        }
     }

    free(guessedWord);
}

int main() {
    welcomeMessage();
    char proceed[10];
    bool continuePlaying = false;
    printf("\t\t**WORD GAME**");
    printf("\n------------------------------------------------------------\n\n");
    startGame();
    while (!continuePlaying){
        printf("Would you like to play a new game? (Y/N): ");
        scanf("%s", &proceed);

        if (strcmp(proceed,"YES")==0 || strcmp(proceed,"yes")==0){
            system("cls");
            printf("\t\t**WORD GAME**");
            printf("\n------------------------------------------------------------\n\n");
            startGame();
		    continuePlaying = false;
		}
		else if(strcmp(proceed,"NO")==0 || strcmp(proceed,"no")==0)
		{
            printf("\n------------------------------------------------------------\n\n");
            printf("Game over. Thank you for playing!\n");
            continuePlaying = true;
        }
        else {
        	printf("\nInvalid input, please try again.\n");
		}

    } 

    return 0;
}
