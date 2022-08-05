package FRIDAY_05_08_2022_TEST_2;

import java.util.Scanner;

public class TestApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Q1_Pattern q1_pattern = new Q1_Pattern();
        q1_pattern.printPattern(4);

        String[] strings = new String[4];

        System.out.println();
        System.out.println("Enter strings : ");
        for(int i = 0; i < 4; i++){
            strings[i] = scanner.nextLine();
        }

        Q2_DescendingOrder q2_descendingOrder = new Q2_DescendingOrder();
        q2_descendingOrder.sortLength(strings);
    }

}
