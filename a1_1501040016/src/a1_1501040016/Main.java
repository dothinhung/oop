package a1_1501040016;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int yourChoice;
        int sizeInput;
        int[] listNumber;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size list number: ");
        sizeInput = scanner.nextInt();
        listNumber = new int[sizeInput];
        for (int i = 0; i < sizeInput ; i++) {
            System.out.print("number[" + (i+1) + "] = ");
            listNumber[i] = scanner.nextInt();
        }
        System.out.println("Element in the series: ");
        for (int i = 0; i < listNumber.length ; i++) {
            System.out.print(listNumber[i] + "\t");
        }
        System.out.println();
        Series series = new Series();
        do {
            series.showMenu();
            System.out.println("****");
            System.out.print("Input Choose: ");
            yourChoice = scanner.nextInt();
            switch (yourChoice){
                case 1:
                    series.min(listNumber);
                    break;
                case 2:
                    series.max(listNumber);
                    break;
                case 3:
                    series.average(listNumber);
                    break;
                case 4:
                    series.inputNewSeries();
                    break;
                case 0:
                    System.out.println("EXIT");
                    break;
            }
        } while (yourChoice != 0);
    }
}
