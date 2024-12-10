package Assigment1;
import java.util.Arrays;
import java.util.Scanner;

import static Assigment1.Ex1.*;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit", sum = "", product = "";
        while ((!num1.equals(quit) && !num2.equals(quit))) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
             if (!num1.equals("quit")) {
                if (isNumber(num1)) {
                    System.out.println("num1 = " + num1 + " is number : " + isNumber(num1) + " , value: " + number2Int(num1));
                }
                else {
                    System.out.println("num2 = " + num1 + " is number : " + isNumber(num1) + ", value: " + number2Int(num1));
                    //ErrorPrint(num1);
                    main(null);
                }
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (!num2.equals("quit")) {
                if (isNumber(num2)) {
                    System.out.println("num2 = " + num2 + " is number : " + isNumber(num2) + ", value: " + number2Int(num2));
                }
                else {
                    System.out.println("num2 = " + num2 + " is number : " + isNumber(num2) + ", value: " + number2Int(num2));
                    //ErrorPrint(num2);
                    main(null);
                }
            }
            System.out.println("Enter a base for Output, [2,16]");
            String base = sc.next();
            if (isBase(base)) {
            sum = sumOf(num1, num2, base);
            product = productOf(num1, num2, base);
            System.out.println(num1 + " + " + num2 + " = " + num2Template(sum, base));
            System.out.println(num1 + " * " + num2 + " = " + num2Template(product, base));
            String arr[] = {num1, num2, sum, product};
                System.out.println("max number over " + Arrays.toString(arr) + " is " + arr[maxIndex(arr)]);
        } else {
                System.out.println("ERR: Wrong base, should get [2,16] got " + base);
                main(null);
            }
        }
        System.out.println();

        System.out.println("quiting now...");
        System.exit(0);
    }
}
