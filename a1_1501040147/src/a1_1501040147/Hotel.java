package a1_1501040147;

import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.DOpt;
import utils.AttrRef;
import utils.OptType;

/**
 * @overview 
 *  <pre> 
 *      Hotel which  represents popular hostels whose services are rated above a given threshold. 
 *  </pre>
 * 
 * @attribute
 *  <pre>
 *          noStars      Float     float
 *  </pre>
 * 
 * @abstract_properties 
 *  <pre>
 *      P_Hostel.id /\ min(id) = 1
 *      mutable(noStar) = true /\ optional(noStar) = false /\ min(noStar) = 3 /\  max(noStar) = 5 /\
 *  </pre>
 * @author nhung
 */
public class Hotel extends Hostel{
    @DomainConstraint(type = "float", mutable = true, optional = false, min = 3, max = 5)
    private float nos;
    
    /**
     * @param id
     * @param name
     * @param add
     * @param nor
     * @param price
     * @param nos
     * @effects initialize this as :<id,name, add, nor, price, nos>
     *  if <id,n,a,nor,p,nos> are valid 
     * else
     *      throw new NotPossibleException
     */
    
    public Hotel(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("address") String add,
            @AttrRef("noRooms") int nor, 
            @AttrRef("price") float price,
            @AttrRef("noStars") float nos) throws NotPossibleException {
        super(id, name, add, nor, price);
        
        if (validNos(nos)) {
            this.nos = nos;
        } else {
            throw new NotPossibleException("Invalid information.");
        }
    }
    
     /**
     * setter of noStars
     *
     * @effects 
     *  if nos > 3 && nos < 5
     *      set this.income = income 
     *  else 
     *      throw new NotPossibleException
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("noStars")
    public void setNos(float nos) throws NotPossibleException {
        if (validNos(nos)) {
            this.nos = nos;
        } else {
            throw new NotPossibleException("Hotel is not valid: " + nos);
        }
    }
    
    /**
     * getter of nos
     *
     * @effects this.nos
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("noStars")
    public float getNos() {
        return this.nos;
    }

    // validator of nos
    /**
     * @effects 
     *  if nos > 3 && nos < 5 
     *      return true 
     *  else 
     *      return false
     * @return
     */
    private boolean validNos(float nos) {
        if (nos >= 3 && nos <= 5) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @effects
     *  <pre>
     *      if nor is not null and nor > 15
     *          return true 
     *      else
     *          return false 
     *  </pre>
     * @param nor
     */
    private boolean validNor(int nor) {
        if ( nor > 15) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @effects 
     *  if id is not null and id > 1 
     *      return true 
     *  else 
     *      return false
     * @param id
     */

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    protected boolean validateId(int id) {
        if (id >= 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @effects 
     *  <pre>
     *            if this satisfies with regard to abatract properties
     *              returns true
     *            else
     *              returns false
     *  </pre>
     */
    public boolean repOK() {
        if (super.repOK() && validNos(nos)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return 
     * @effects 
     * return id, name, address, nor, price and nos of Hotel
     * hostel to String Hotel Hostel<>
     */
    @Override
    public String toString() {
        return "Hotel Hostel { " + super.getId() + ", " + super.getName() + ", "
                + super.getAdd() + ", " + super.getNor() + ", " + getPrice() + "," + getNos() + "}";
    }

}
