package a1_1501040016;

import java.util.Scanner;

public class Series {
   
    private int minimum;
    private int maximum;
    private float average;
    
    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("====================================================");
        System.out.println("Your Choice"
                +   "\n" +"1. Min number in series"
                +   "\n" +"2. Max number in series" 
                +   "\n" +"3. Average of series"
                +   "\n" +"4. Input other series"
                +   "\n" +"0. Quit the program (EXIT)");
    }

    public void inputNewSeries(){
        int sizeInput;
        int[] listNumber;
        
        System.out.print("Input new size list: ");
        sizeInput = scanner.nextInt();
        listNumber = new int[sizeInput];
        
      
        for (int i = 0; i < sizeInput ; i++) {
            System.out.print("Listnumber[" + i + "] = ");
            listNumber[i] = scanner.nextInt();
        }
        System.out.println("Element in the new series: ");
        for (int i = 0; i < listNumber.length ; i++) {
            System.out.print(listNumber[i] + "\t");
        }
        System.out.println();
    }

    /*
    * phương thức in ra số nhỏ nhất
    */
    public void min(int[] listNumber){
        minimum = listNumber[0];
        for (int i = 0; i <= listNumber.length - 1 ; i++) {
            if (listNumber[i] < minimum){
                minimum = listNumber[i];
            }
        }
        System.out.println("Min number in the series: "+minimum);
    }

    /*
    * phương thức in ra số lớn nhất
    */
    public void max(int[] listNumber){
        maximum = listNumber[0];
        for (int i = 1; i <= listNumber.length - 1 ; i++) {
            if (listNumber[i] > maximum){
                maximum = listNumber[i];
            }
        }
        System.out.println("Max number in the series: "+maximum);
    }

    /*
    * Phương thức in ra trung bình của 1 list
    */
    public void average(int[] listNumber){
        int sum = 0;
        for (int i = 0; i < listNumber.length ; i++) {
            sum =sum + listNumber[i];
        }
        average =  (float) sum / listNumber.length;
        System.out.println("Average of the series: "+average);
    }

}
