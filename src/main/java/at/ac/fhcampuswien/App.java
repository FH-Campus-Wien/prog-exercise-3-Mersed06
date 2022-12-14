package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int daysOfMonth, int firstDay)
    {
        final int MAX_WEEKDAY = 7;
        StringBuilder LineOfCalender = new StringBuilder();
        final char dateSeparator = ' ';
        final char bufferForOneDigitDates = ' ';
        final String noDate = "  ";

        int currentWeekDay = 1;
        // Variable wird verwendet, um auch in der Schleife die "Leeren" Tage anzuzeigen.
        int startValueOfOutputLoop = 2 - firstDay;
        for (int currentDate = startValueOfOutputLoop  ; currentDate <= daysOfMonth ; currentDate++,currentWeekDay++ ){

            if (currentDate <= 0){
                LineOfCalender.append(noDate);
            } else {
                if(currentDate < 10) LineOfCalender.append(bufferForOneDigitDates);
                LineOfCalender.append(currentDate);
            }

            // Datumstrennung einsetzten.
            LineOfCalender.append(dateSeparator);

            if(currentWeekDay == MAX_WEEKDAY || currentDate == daysOfMonth){
                System.out.println(LineOfCalender);
                // String "ausleeren"
                LineOfCalender.setLength(0);
                currentWeekDay = 0;
            }
        }


    }


    public static long[] lcg(long value)
    {
        long[] random = new long[10];
        final long m = (long) Math.pow(2,31);
        final int c = 12345;
        final long a = 1103515245;

        for (int i = 0; i <= 9 ; i++)
        {
            if (i==0)
            {
                random[i] = (a*value + c) % m;
            }
            else
            {
                random[i] = (a * random[i-1] + c) % m;
            }

        }

        return random;

    }




    public static void guessingGame(int numberToGuess) {
        Scanner sc = new Scanner(System.in);
        int count;

        for (count = 1; count <= 10; count++) {
            System.out.print("Guess number " + count + ": ");
            int guessedNumber = sc.nextInt();

            if (guessedNumber < numberToGuess && count < 10) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (guessedNumber > numberToGuess && count < 10) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (guessedNumber == numberToGuess && count < 10) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (count == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");

            }
        }
    }


    public static String camelCase(String string) {
        char[] charArray = string.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>(charArray.length);
        String result;


        charArray[0] = Character.toUpperCase(charArray[0]);


        for (int i = 1; i < charArray.length; i++)
        {
            if (Character.isLowerCase(charArray[i]) && Character.isWhitespace(charArray[i-1]))
            {
                charArray[i] = Character.toUpperCase(charArray[i]);
            } else if (Character.isUpperCase(charArray[i]) && !Character.isWhitespace(charArray[i-1]))
            {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            arrayList.add(String.valueOf(charArray[i]));
        }

        for (int i = 0; i < charArray.length; i++)
        {
            if (arrayList.contains(" "))
            {
                arrayList.remove(" ");
            }
            else if (arrayList.contains(".")) {
                arrayList.remove(".");
            } else if (arrayList.contains(",")) {
                arrayList.remove(",");
            } else if (arrayList.contains(";")) {
                arrayList.remove(";");
            } else if (arrayList.contains("?")) {
                arrayList.remove("?");
            } else if (arrayList.contains("!")) {
                arrayList.remove("!");
            } else if (arrayList.contains("'")) {
                arrayList.remove("'");
            }
        }
        result = arrayList.get(0);

        for (int i = 1; i < arrayList.size(); i++)
        {
                result = result + arrayList.get(i);
        }
        return result;
    }




    public static boolean swapArrays(int[] first, int[] second) {
        int[] array3 = new int[6];
        if (first.length != second.length) {
            return false;
        } else {
            for (int i = 0; i < 6; i++) {
                array3[i] = first[i];
                first[i] = second[i];
                second[i] = array3[i];

            }

            return true;
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        int minimum = 1;
        int maximum = 100;              // setting a range of numbers for the random number
        int randomNumber = (int) (Math.random() * (maximum - minimum) + 1);
        return randomNumber;
    }


    public static int checkDigit(int [] code) {
        int weighting = 1;
        int product = 0;
        int digit = 0;

        for (int i = 0; i < code.length; i++) {
            weighting = weighting +1;                           //Gewichtung: Array Position + 0
            product = product + code[i] * weighting;            //Produkt = weighting * Code, Summe vom Ganzen

            //Pr??fziffer als int zur??ckliefern
        }

        int rest = product % 11;

        digit = 11 - rest;
        if (digit == 11) {
            digit = 5;
        } else if (digit == 10) {
            digit = 0;
        }
        return digit;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(4,5);
        lcg(123);
    }
}