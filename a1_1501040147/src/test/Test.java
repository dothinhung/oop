package test;

import a1_1501040147.Hostel;
import a1_1501040147.Hotel;
import utils.NotPossibleException;

/**
 *
 * @author admin
 */
public class Test {

    public static void main(String[] args) {
        
        Hostel hst = null;
        try {
            hst = new Hostel(12, "Nhung", "Phu Tho", 3, 7.6f);
        } catch (NotPossibleException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(hst);
        
        Hotel ht = null;
        try {
            ht = new Hotel(7, "Linh", "Ha noi", 9, 17.5f, 3.9f);
        } catch (NotPossibleException e) {
            e.printStackTrace();
        }
        System.out.println(ht);
    }
}
