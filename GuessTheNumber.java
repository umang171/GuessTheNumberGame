package GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

class NumberGame {
    private int num;
    private int noOfGuesses;
    int userInp;

    NumberGame() {
        Random r = new Random();
        num = r.nextInt(99) + 1;
    }

    int noOfGuesses() {
        return noOfGuesses;
    }

    void takeUserInput(int userInp) {
        this.userInp = userInp;
    }

    boolean isCorrectNumber() {
        noOfGuesses++;
        if (userInp == num) {
            System.out.println("Congratulations You guess the correct number!");
            System.out.println("The number is:" + num);
            System.out.println("You guess the number in " + noOfGuesses + " guesses.");
            return true;
        } else if (userInp > num) {
            System.out.println("Oops you guess the bigger number,Please guess the smaller number!");
        } else {
            System.out.println("Oops you guess the smaller number,Please guess the bigger number!");
        }
        return false;
    }
}

class GuessTheNumber {
    public static void main(String[] args) {
        NumberGame obj = new NumberGame();
        NumberGame obj2 = new NumberGame();
        Scanner sc = new Scanner(System.in);
        do {
            int userInp;
            System.out.print("Guess the number between 1 to 100:");
            userInp = sc.nextInt();
            obj.takeUserInput(userInp);
        } while (!obj.isCorrectNumber());
        do {
            int userInp;
            System.out.print("Guess the number between 1 to 100:");
            userInp = sc.nextInt();
            obj2.takeUserInput(userInp);
        } while (!obj2.isCorrectNumber());
        if (obj.noOfGuesses() > obj2.noOfGuesses()) {
            System.out.println("Player 2 won");
        } else if (obj.noOfGuesses() < obj2.noOfGuesses()) {
            System.out.println("Player 1 won");
        } else {
            System.out.println("Tie");
        }
        sc.close();
    }
}