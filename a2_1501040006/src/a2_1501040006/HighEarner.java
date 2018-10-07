package a2_1501040006;

import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.DOpt;
import utils.AttrRef;
import utils.OptType;

/**
 * @overview <pre>
 *      HighEarner, which is a sub class of Customer, represents wealthy
 *     customers whose income are above a given threshold.
 * </pre>
 *
 * @attribute <pre>
 *      income      Float     float
 * </pre>
 *
 * @abstract_properties <pre>
 *      P_Customer.id /\ min(id) = 10000000
 *      mutable(income) = true /\ optional(income) = false /\ min(income) = 10000000
 * </pre>
 */
public class HighEarner extends Customer {

    private static final double MIN = 10000000;

    @DomainConstraint(mutable = true, optional = false, min = MIN)
    private float income;

    /**
     *
     * @effects <pre>
     *      if id, name, phoneNumber, address, income are valid
     *          initialize <tt>this</tt> as <id,name,phoneNumber,address,income>
     *      else
     *          throws NotPossibleException
     * </pre>
     *
     */
    @DOpt(type = OptType.Constructor)
    public HighEarner(@AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("phoneNumber") String phoneNumber,
            @AttrRef("address") String address,
            @AttrRef("income") float income) throws NotPossibleException{
        super(id, name, phoneNumber, address);
        if (validateIncome(income)) {
            this.income = income;
//        } else {
//            throw new NotPossibleException("<init>: invalid inputs");
        }
    }

    /**
     * @effects @return <tt>this.income</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("income")
    public float getIncome() {
        return income;
    }

    /**
     * @effects <pre>
     *    if income is valid
     *       set this.income = income
     *    else
     *       throws NotPossibleException
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("income")
    public void setIncome(float income) throws NotPossibleException{
        if (validateIncome(income)) {
            this.income = income;
        } else {
            throw new NotPossibleException("invalid input: "+income);
        }
    }

    /**
     * @effects <pre>
     *      if id is valid
     *          return true
     *      else
     *          return false
     * </pre>
     */
    @Override
    protected boolean validateID(int id) {
        return id >= MIN;
    }

    /**
     * @effects <pre>
     *      if income is valid
     *          return true
     *      else
     *          return false
     * </pre>
     */
  
    private boolean validateIncome(float income) {
        return income >= MIN;
    }

    /**
     * @effects <pre>
     *      if <i,n,p,a,c> is valid tuple
     *                  where income(c)
     *          return true
     *      else
     *          return false
     * </pre>
     */
    private boolean validate(int id, String name, String phoneNumber, String address, float income) {
        return super.repOK() && validateIncome(income);
    }

    /**
     * @effects <pre>
     *      if <tt>this</tt> satifies the abstract properties
     *          return true
     *      else
     *          return false
     * </pre>
     */
    @Override
    public boolean repOK() {
        return validate(getId(), getName(), getPhoneNumber(), getAddress(), income);
    }

    /**
     * @effects return the string representation of objects
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        if (repOK()) {
            return "High Earner: {\"Id\": " + getId() + ", \"Name\": " + getName() + ", "
                    + "\"Phone Number\": " + getPhoneNumber() + ", \"Address\": " + 
                    getAddress() + ", \"Income\": " + getIncome() + "}";
        } else {
            return "High Earner: {}";
        }
  
    
    }
    
}


