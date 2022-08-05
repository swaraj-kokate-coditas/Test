package FRIDAY_05_08_2022_TEST_2;

/**
 * Print Pattern :
 *
 *  A
 *  A B
 *  A B C
 *  A B C D
 *  A B C
 *  A B
 *  A
 *
 *  Author : Swaraj Ashok Kokate
 */

public class Q1_Pattern {

        void printPattern(int rows) {

            for(int iteration_1 = 0; iteration_1 <= rows; iteration_1++) {

                int alphabet = 65;

                for(int iteration_2 = 0; iteration_2 < iteration_1; iteration_2++) {
                    System.out.print((char) alphabet + " ");
                    alphabet++;
                }

                System.out.println();

            }

            for(int iteration_1 = rows-1; iteration_1 > 0; iteration_1--) {

                int alphabet = 65;

                for(int iteration_2 = iteration_1; iteration_2 > 0; iteration_2--) {
                    System.out.print((char) alphabet + " ");
                    alphabet++;
                }

                System.out.println();
            }

        }
    }

/* OUTPUT
A
A B
A B C
A B C D
A B C
A B
A
 */

