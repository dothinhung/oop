package a1_1501040147;

import utils.DomainConstraint;
import utils.DOpt;
import utils.AttrRef;
import utils.OptType;
import utils.NotPossibleException;

/**
 * @Overview <pre> Hostel is place that are of interest to the travelers </pre>
 * 
 * @attributes <pre>
 *          id          Integer             int
 *          name        String              String
 *          address     String              String
 *          noRooms     Integer             int
 *          price       Float               float
 * </pre>
 * 
 * @objects <pre>
 *          A typical hostel object is h<i,n,a,nor,p>
 *          Where id(i), name(n), address(a), noRooms(nor), price(p)
 * </pre>
 * 
 * @abstract properties <pre>
 *          mutable(id) = False /\ optional(id) = False /\ min(id) = 1 /\
 *          mutable(name) = True /\ optional(name) = False /\ length(name) = 70 /\
 *          mutable(address) = True /\ optional(address) = False /\ length(address) = 150 /\
 *          mutable(noRooms) = True /\ optional(noRooms) = False /\ min(noRooms) = 3 /\ max(noRooms) = 4 /\
 *          mutable(price) = True /\ optional(price) = False /\ min(price) =1 /\
 * </pre>
 * 
 * @author nhung
 */
public class Hostel implements Comparable {
    
    // attributes
    
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int id;
    
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 70)
    private String name;
    
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 150)
    private String add;
    
    @DomainConstraint(type = "Integer", mutable = true, optional = false, min = 3, max = 14)
    private int nor;
    
    @DomainConstraint(type = "float", mutable = true, optional = false, min = 1)
    private float price;
    
    /**
     * @param id
     * @param name
     * @param add
     * @param nor
     * @param price
     * @effects <pre>
     *          if id, name, add, nor, price are valid
     *              initialize <tt>this</tt> as <id,na,add, nor, price>
     *          else
     *              throws NotPossibleException
     *          </pre>
     */
    
    public Hostel(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("address") String add,
            @AttrRef("noRooms") int nor, 
            @AttrRef("price") float price)throws NotPossibleException {

        //validator of Hostel
        //effects check validation of id 
            this.id = id;
            if(validName(name)){
                this.name = name;
            }
            if(validAdd(add)){
                this.add = add;
            }
            
                this.nor = nor;
            
            if(validPrice(price)){
                this.price  = price;
            }
        
    }
    
    //getter
    /**
     * @effects <pre>
     *          return id, name, add, nor, price of hostels 
     *          if valid with regard to abstract properties </pre>
     */
    
    //attribute references
    /**
     * @return @effects return Hostel.id
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }
    
    /**
     * @return 
     * @effects return Hostel.name
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }
    
    /**
     * @return 
     * @effects return Hostel.add
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAdd() {
        return add;
    }

    /**
     * @return 
     * @effects return Hostel.nor
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("noRooms")
    public int getNor() {
        return nor;
    }
    
    /**
     * @return 
     * @effects return Hostel.price
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("price")
    public float getPrice() {
        return price;
    }
    
    //setter
    /**
     * @effects 
     *  <pre>
     *      if name is valid 
     *          set this.name = name 
     *      else 
     *          throw new NotPossibleException
     *  </pre>
     * @param name
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("name")
    public void setName(String name) throws NotPossibleException {
        if (validName(name)) {
            this.name = name;
        } else {
            throw new NotPossibleException("Invalid name." + name);
        }
    }
    
    /**
     * @effects 
     *  <pre>
     *      if add is valid 
     *          set this.add = add 
     *      else 
     *          throw new NotPossibleException
     *  </pre>
     * @param add
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("address")
    public void setAdd(String add) throws NotPossibleException {
        if (validAdd(add)) {
            this.add = add;
        } else {
            throw new NotPossibleException("Invalid address." + add);
        }
    }
    
    /**
     * @effects 
     *  <pre>
     *      if nor is valid 
     *          set this.nor = nor 
     *      else 
     *          throw new NotPossibleException
     *  </pre>
     * @param nor
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("noRooms")
    public void setNor(int nor) throws NotPossibleException {
        if (validNor(nor)) {
            this.nor = nor;
        } else {
            throw new NotPossibleException("Invalid noRooms" + nor);
        }
    }
    
    /**
     * @effects 
     *  <pre>
     *      if price is valid 
     *          set this.price = price 
     *      else 
     *          throw new NotPossibleException
     *  </pre>
     * @param price
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("price")
    public void setPrice(float price) throws NotPossibleException {
        if (validPrice(price)) {
            this.price = price;
        } else {
            throw new NotPossibleException("Invalid price." + price);
        }
    }
    
    //validator
    
    /**
     * @return 
     * @effects 
     *  <pre>
     *      if id not null and id < 1
     *          return flase
     *      else 
     *          return true
     *  </pre>
     * @param id
     */
    protected boolean validId(int id) {
        if (id < 1) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * @effects
     *  <pre>
     *      if name is not null and name.length() <= 70
     *          return true 
     *      else
     *          return false 
     *  </pre>
     * @param name
     */
    private boolean validName(String name) {
        if (name.length() > 0 && name.length() <= 70) {
            return true;
        } else {
            return false;
        }
    }
    
     /**
     * @effects
     *  <pre>
     *      if add is not null and add.length() <= 150
     *          return true 
     *      else
     *          return false 
     *  </pre>
     * @param add
     */
    private boolean validAdd(String add) {
        if (add.length() > 0 && add.length() <= 150) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @effects
     *  <pre>
     *      if nor is not null and nor < 14
     *          return true 
     *      else
     *          return false 
     *  </pre>
     * @param nor
     */
    private boolean validNor(int nor) {
        if ( nor >= 3 && nor <= 14) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @effects
     *  <pre>
     *      if price is not null and price < 1
     *          return false 
     *      else
     *          return true 
     *  </pre>
     * @param price
     */
    private boolean validPrice(Float price) {
        if (price < 1) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * repOK
     *
     * @return 
     * @effects 
     *  <pre>
     *            if id, name, add, nor, price are valid with regard to abstract properties
     *              return true
     *            else
     *              return false 
     *  </pre>
     */
    public boolean repOK() {
        return validId(id) && validName(name) && validAdd(add) && validNor(nor) && validPrice(price);
    }
    
    /**
     * @param x
     * @efects check the validation of name by compareTo an object O
     *
     */
    @Override
    public int compareTo(Object x) {
        Hostel hostel = (Hostel) x;
        int i = this.name.compareTo(hostel.name);
        return i;
    }

    /**
     * @effects return id, name, address, nor and price of Hostel to String Hostel<>
     */
    @Override
    public String toString() {
        return ("Hostel {" + id + ", " + name + ", " + add + ", " + nor + "," + price + "}");
    }
}
