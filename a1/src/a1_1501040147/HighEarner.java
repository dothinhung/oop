package a1_1501040147;

import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;
import utils.NotPossibleException;

/**
 * @Overview HighEarner is a sub-class of Customer, which inherits all attributes of Customer,
 * with wealthy customers whose incomes are above a certain threshold
 * @object A typical HighEarner customer is H=<id,n,p,a,i>, where id(id),
 *      name(n),phoneNumber(p), address(a), income(i).
 * @attribute income Float
 * @@Abstract_properties mutable(id)=false /\ optional(id)=false /\
 *      min(id)=10000000 mutable(income)=true/\
 *      optional(income)=false/\min(income)=10000000.
 * @author Admin
 */
public class HighEarner extends Customer {

    @DomainConstraint(type = "float", mutable = true, optional = false, min = 10000000)
    private float income;

    /**
     * @param id
     * @param name
     * @param phoneNumber
     * @param address
     * @param income
     * @effects initialize this as :<id,name,phoneNumber,address, income>
     *  if <id,n,p,a,i> are valid 
     * else
     *      throw new NotPossibleException
     */
    public HighEarner(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("phoneNumber") String phoneNumber,
            @AttrRef("address") String address,
            @AttrRef("income") float income) throws NotPossibleException {

        super(id, name, phoneNumber, address);
        if (validateIncome(income)) {
            this.income = income;
        } else {
            throw new NotPossibleException("Invalid HighEarner information.");
        }
    }

    /**
     * setter of income
     *
     * @effects 
     *  if income > 10000000 
     *      set this.income = income 
     *  else 
     *      throw new NotPossibleException
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("income")
    public void setIncome(float income) throws NotPossibleException {
        if (validateIncome(income)) {
            this.income = income;
        } else {
            throw new NotPossibleException("HighEarner is not valid: " + income);
        }
    }

    /**
     * getter of income
     *
     * @effects this.income
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("income")
    public Float getincome() {
        return this.income;
    }

    // validator of income
    /**
     * @effects 
     *  if income > 10000000 
     *      return true 
     *  else 
     *      return false
     * @return
     */
    private boolean validateIncome(float income) {
        if (income >= 1000000) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    /**
     * @effects 
     *  if id is not null and id > 10000000 
     *      return true 
     *  else 
     *      return false
     * @param id
     */

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10000000)
    protected boolean validateId(int id) {
        if (id >= 10000000) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects <pre>
     *            if this satisfies with regard to abatract properties
     *              returns true
     *            else
     *              returns false</pre>
     */
    public boolean repOK() {
        if (super.repOK() && validateIncome(income)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects 
     * return id, name, phone number, address and income of HighEarner
     * customer to String HighEarner Customer<>
     */
    @Override
    public String toString() {
        return "HighEarners Customers < " + super.getId() + ", " + super.getName() + ", "
                + super.getPhoneNumber() + ", " + super.getAddress() + ", " + getincome() + ">";
    }
}
