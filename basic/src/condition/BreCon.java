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
public class BreCon {
/*
    *Câu lệnh break là dừng vòng lặp đấy lại
    *Câu lệnh continue là dừng vòng lặp tại giá trị đó và nhảy tiếp đến giá trị tiếp theo của vòng lặp
    */
    public static void main(String[] args) {
        for(int i = 1; i < 20; i++){ //trong vòng lặp for khi khai báo biến i thì phải gán n với 1 giá trị
            if(i % 7 == 0){
                System.out.println("OK" +"---------------"+ i);
//                break; // khi gặp break thì chạy đến 7 chương trình sẽ dừng lại và không chạy câu lệnh đằng sau
                   continue;//khi chạy câu lệnh continue thì n sẽ dừng lại ở 7 và chạy đến giá trị tiếp theo của vòng for (8)
                   //nếu k có continue thì sau khi in ra 7, thực hiện câu lệnh tiếp theo lại in ra 7
            }
            System.out.println(i);
        }
    }
    
}
