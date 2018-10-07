package a1_1501040120;

import utils.*;

/**
 * @author Pham Hoang Huong Ly
 * @overview
 *	Hostel is the boarding houses where travelers are interested
 *      It contains some main factors such as: id, name, address,number of rooms and price.
 * 
 * @attributes 
 * 	id          Integer     int
 * 	name        String      String    
 *  	address     String      String
 *      noRooms     Integer     int
 *      price       Float       float
 * 
 * @object 
 * 	A typical hostel is s = (id, name, address, noRooms, price)
 * 
 * @abstract_properties 
 *  mutable(id)=false /\ optional(id)=false /\ min(id)=1
 *  mutable(name)=true /\ optional(name)=false /\ length(name)=70
 *  mutable(address)=true /\ optional(address)=false /\ length(address)=150
 *  mutable(noRooms)=true /\ optional(noRooms)=false /\ min(noRooms)=3 /\ max(noRooms)=14
 *  mutable(price)=true /\ optional(price)=false /\ min(price)=1
 */
public class Hostel implements Comparable {
    
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int id;
    
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 70)
    private String name;
    
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 150)
    private String address;
    
    @DomainConstraint(type = "Integer", mutable = true, optional = false, min = 3, max = 14)
    private int noRooms;
    
    @DomainConstraint(type = "Float", mutable = true, optional = false, min = 1)
    private float price;
    
    /**
     * @param id
     * @param name
     * @param address
     * @param noRooms
     * @param price
     * @effects 
     * initialize this as Hostel:<id,name,address,noRooms,price>,
     *   if
     *       <id,name,address,noRooms,price> are valid 
     *       and name has not existed in  data
     *   else
     *       throw new NotPossibleException
     *  	
     */
    
    public Hostel(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("address") String address,
            @AttrRef("noRooms") int noRooms,
            @AttrRef("price") float price) throws NotPossibleException {
        
            this.id = id;
            this.name = name;
            this.address = address;
            this.noRooms = noRooms;
            this.price = price;
        
    }
    
    Hostel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     // Getter
    /**
     * @effects return id
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("id")
    public int getId(){
        return id;
    }
    
    /**
     * @effects return name
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("name")
    public String getName(){
        return name;
    }
    
    /**
     * @effects return address
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("address")
    public String getAddress(){
        return address;
    }
    
      /**
     * @effects return noRooms
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("noRooms")
    public int getNoRooms(){
        return noRooms;
    }
    
      /**
     * @effects return price
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("price")
    public float getPrice(){
        return price;
    }
    
    // Setter
    /**
     * if name is valid
     *      this.name = name 
     * else 
     *      throw new NotPossibleException
     * @param name
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("name")
    public void setName(String name) throws NotPossibleException { 
       if(validateName(name)) {
           this.name = name;
       } else {
           throw new NotPossibleException("Not found hostel's name");
       }
    }
    
    /**
     * if noRooms is valid 
     * 	this.noRooms = noRooms
     *  else 
     * 	throw new NotPossibleException
     * @param noRooms
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("noRooms")
    public void setNoRooms(int noRooms) throws NotPossibleException {
        if(validateNoRooms(noRooms)) {
            this.noRooms = noRooms;
        } else {
            throw new NotPossibleException("Not found hostel's noRooms");
        }
    }
    
    /**
     * if address is valid 
     * 	this.address = address 
     * else 
     * 	throw new NotPossibleException
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("address")
    public void setAddress() throws NotPossibleException {
        if(validateAddress(address)) {
            this.address = address;
        } else {
            throw new NotPossibleException("Not found hostel's address");
        }
    }
    
     /**
     * if price is valid 
     * 	this.price = price
     * else 
     * 	throw new NotPossibleException
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("price")
    public void setPrice() throws NotPossibleException {
        if(validatePrice(price)) {
            this.price = price;
        } else {
            throw new NotPossibleException("Not found hostel's price");
        }
    }
    //Validator
    /**
     * @effect 
     *  if id < 1
     *      return false
     *  else
     *      return true
     * @param id
     * @return 
     */
    protected boolean validateId(int id){
        if (id < 1) {
            return false;
	} else {
            return true;
	}
    }
    
    /**
     * @effect 
     *  if name is valid & name.length() > 70
     *      return false
     *  else
     *      return true
     * @param name
     * @return 
     */
    public boolean validateName(String name){
        if(name == null || name.length() > 70) {
            return false;
        } else {
            return true;
	}
    }
    
    /**
     * @effect 
     *  if noRooms < 3 ||  noRooms > 14   
     *      return false
     *  else
     *      return true
     * @param  noRooms
     * @return 
     */
    protected boolean validateNoRooms(int  noRooms){
        if (noRooms < 3 ||  noRooms>14) {
            return false;
	} else {
            return true;
	}
    }
    
    /**
     * @effect 
     *  if address is valid & address.length() > 150
     *      return false
     *  else
     *      return true
     * @param address
     * @return 
     */
    public boolean validateAddress(String address){
        //private statci/ public
        if (address == null || address.length() > 150) {
            return false;
        } else {
            return true;
	}
    }
     
    /**
     * @effect 
     *  if price < 1
     *      return false
     *  else
     *      return true
     * @param price
     * @return 
     */
    public boolean validatePrice(float price){
        //private statci/ public
        if (price < 1) {
            return false;
        } else {
            return true;
	}
    }
    
     /**
     * @effects <pre>
     *  if id, name, address, noRooms, price are valid
     *      return true
     *  else
     *      return false</pre>
     */
    private boolean validate(int id, String name, int noRooms, String address, float price) {
        if (validateId(id) && validateName(name) && validateNoRooms(noRooms) && validateAddress(address) && validatePrice(price)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Hostel:<" + getId() + ", " + getName() + ", " + getAddress() + ", " + getNoRooms() + ", " + getPrice() + ">";
    }
    
    @Override
    public boolean equals(Object ob) {
        if (ob == null)
            return false;

	if (ob.getClass() != this.getClass())
            return false;

	Hostel s = (Hostel) ob;
            return (s.name.equals(name) && s.address.equals(address));
	}
    
    @Override
    public int compareTo(Object ob){
        if(ob == null) 
            throw new NullPointerException("Hostel.compareByName");
	else if(!(ob instanceof Hostel))
            throw new ClassCastException("Hostel.compareByName: not a Hostel " + ob);
        
	Hostel s = (Hostel) ob;
	return this.name.compareTo(s.name);
    }
    
    /**
     * @return 
     * @effects <pre>
     *      if this satisfies rep invariant
     *          returns true
     *      else 
     *          returns false
     * </pre>
     */
    public boolean repOk(){
        if(validateId(id)&&validateName(name)&&validateNoRooms(noRooms)&&validatePrice(price))
            return true;
        else
            return false;
    }
}
