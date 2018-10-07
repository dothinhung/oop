package test;
import a1_1501040147.Customer;
import a1_1501040147.HighEarner;
import utils.NotPossibleException;

/**
 *
 * @author admin
 */
public class Test {

    public static void main(String[] args) {
        
        Customer hst = null;
        try {
            hst = new Customer(2, "Dịu", "0123456","Hà Nội");
        } catch (NotPossibleException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(hst);
        
        HighEarner ht = null;
        try {
            ht = new HighEarner(1, "Hợp", "0123456789","Nam Định", 15);
        } catch (NotPossibleException e) {
            e.printStackTrace();
        }
        System.out.println(ht);
    }
}
