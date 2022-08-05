package FRIDAY_05_08_2022_TEST_2;

/**
 * 2) Print array in descending order
 */

public class Q2_DescendingOrder {

    void sortLength(String[] string) {

        for(int i = 1; i < 4; i++) {
            String strings = string[i];

            int j = i-1;
            while((j >= 0) && strings.length() > string[j].length()) {
                string[j+1] = string[j];
                j--;
            }

            string[j+1] = strings;
        }

        for (int k = 0; k < string.length; k++) {
            System.out.print(string[k] + " ");
        }

    }

}
