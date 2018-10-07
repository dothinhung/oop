/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condition;

/**
 *
 * @author nhung
 */
public class ex3 {
    public static void main(String[] args) {
        
        //for
        int n1 = 9;
        System.out.println("In ra 1 bảng cửu chương với vòng lặp for");
        for(int k = 2; k<10; k++){
            System.out.printf("%d * %d = %d%n",k,n1,k*n1);
        }
        
        // for
        System.out.println("****************************************************");
        System.out.println("In ra bảng cửu chương đầy đủ với 9 bảng");
        for(int i = 2; i<10; i++){
            System.out.println("Bảng cửu chương"+i);
            for(int j = 1; j<=10; j++){
                System.out.printf("%d * %d = %d%n",i,j,i*j); //string format printf
                //System.out.println(i+ "  *  "+j + "  =  " + i*j);
            }
        }
        
        //while
        System.out.println("In ra 1 bảng cửu chương với while loop");
        int n3 = 9;
        int n4 = 1;
        while(n4<10){ //vòng lặp while là vòng lặp vô hạn khi điều kiện là true, nó chỉ dừng lại khi gặp đk là false
            n4++;
            System.out.printf("%d * %d = %d%n",n3,n4,n3*n4);
        }
        
       
        
        //While
        System.out.println("In ra bảng cửu chương đầy đủ với while loop");
       int number = 1;
       while(number<9){
           number++; // number sẽ tăng lên 1 trước khi chạy đến câu lệnh in ra nên number sẽ chạy từ 2
           System.out.println("Bảng cửu chương "+number);
           for(int i=1; i<=10; i++){
               System.out.printf("%d * %d = %d%n",number,i,i*number);
           }   
       }
       
       //do...while
        System.out.println("----------------------------------------------------");
       int n5=9;
       int n6 = 1;
       do{
           System.out.printf("%d * %d = %d%n",n5,n6,n5*n6);
           n6++; // chạy câu lệnh in  ra trước khi tăng n nên sẽ chạy từ 1
       }while(n6<10);


    }

    
}
