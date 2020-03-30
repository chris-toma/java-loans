package com.javatut;

import java.util.Scanner;

/**
 *
 */
public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args1) {
        System.out.print("Enter number of months: ");
        if (input.hasNextInt()) {
            int a = input.nextInt();
            if (a > 0) {
                for (int i = 0; i < a; i++)
                    LoanRepository.processPeriod(i);

            } else System.out.println("Value must be between 1 and 12");
        } else System.out.println("The value must be int");
    }
}
