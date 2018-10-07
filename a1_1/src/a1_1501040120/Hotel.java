package a1_1501040120;

import utils.*;

/**
 * @author  Pham Hoang Huong Ly
 * 
 * @overview    Hotel is a sub-class of Hostel, refers to the popular hostels which services are rated above a given threshold
 
 * @attribute    
 *      noStars  Float Float 
 * 
 * @Abstract_properties 
 *      mutable(noStars)=true /\ optional(noStars)=false /\ min(noStars)=3 /\ max(noStars)= 5
 * 
 */
public class Hotel extends Hostel{
    @DomainConstraint(type = "float", mutable = true , optional = false, min = 3, max = 5)
    private float noStars;
    
    /**
     * @effects <pre>
     * if id, name, address, noRooms, price and noStars are valid
     * initialise this as Hostel:<id,name,address,noRooms,price,noStars>
     * else
     * throw NotPossibleException
     * </pre>
     * @param id
     * @param name
     * @param address
     * @param noRooms
     * @param price
     * @param noStars
     */
    public Hotel(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("address") String address,
            @AttrRef("noRooms") int noRooms,
            @AttrRef("price") float price,
            @AttrRef("noStars") float noStars) throws NotPossibleException {
        super(id,name,address,noRooms,price);
        if(validateNoStars(noStars)){
            this.noStars=noStars;
        } else {
            throw new NotPossibleException("Invalid noStars");
        }      
    }
    
    /**
     * return this.noStars
     * @return 
     */
    public float getNoStars(){
        return this.noStars;
    }
    
    /**
     * @param noStars
     * @effect 
     *  if noStars is valid 
     *      this.noStars = noStars 
     *  else 
     *      throw new NotPossibleException
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("noStars")
    public void setNoStars(float noStars) throws NotPossibleException {
	if (!validateNoStars(noStars))
        	this.noStars = noStars;
	else
		throw new NotPossibleException("Invalid noStars");

	}
    
    /**
     *    if noStars is valid 
     *        sets this.noStars=noStars
     *    else 
     *        throws NotPossibleException
     *  
     */
    private boolean validateNoStars(float noStars){
        if (noStars < 3 || noStars > 5)
            return false;
        else
            return true;
    }
    
    @DomainConstraint(type = "Integer", mutable = true , optional = false, min = 15)
    @Override
    protected boolean validateId(int noRooms){
        if (noRooms < 15) {
            return false;
	} else {
            return true;
        }
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
    @Override
    public boolean repOk(){
        if(super.repOk() && validateNoStars(noStars))
            return true;
        else
            return false;//throw???
    }
    
    @Override
    public String toString(){
        return String.format("Hotel<%d, %s, %s, %d, %f, %f>", super.getId(),
				super.getName(), super.getAddress(), super.getNoRooms(), super.getPrice(), getNoStars());
    }
    
    
}