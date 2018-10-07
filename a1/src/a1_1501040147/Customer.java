package a1_1501040147;

import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;
import utils.NotPossibleException;

/**
 * @overview Customers are people or organizations who have personal information
 *      such as id, name, phone number and address
 * @object A typical customer is C=<id,n,p,a>, where id(id), name(n,
 *      phoneNumber(p), address(a).
 * @attributes 
 *      id              Integer 
 *      name            String 
 *      phoneNumber     String 
 *      address         String
 * @abstract_properties 
 *      mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\ max(id)= 1000000 
 *      mutable(name)=true /\ optional(name)=false /\ length(name)=50 
 *      mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 
 *      mutable(address)=true /\ optional(address)=false /\ length(address)=100
 */
public class Customer implements Comparable {

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 1000000)
    private int id;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String name;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
    private String phoneNumber;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
    private String address;
    //optional = false 

    /**
     * @param id
     * @param name
     * @param phoneNumber
     * @param address
     * @effects 
     * initialize this as Customer: <id,name,phoneNumber,address>, if
     * <id,p,n,a> are valid and name has not existed 
     * else 
     *      throw new NotPossibleExceptio
     *
     */
    public Customer(
            @AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("phoneNumber") String phoneNumber,
            @AttrRef("address") String address) throws NotPossibleException {

        //validator of Customer
        //effects check validation of id  
        if (validateId(id)) {
            this.id = id;
        } else {
            throw new NotPossibleException("Invalid customer ID.");
        }

        // @effects check validation of name
        if (validatename(name)) {
            this.name = name;
        } else {
            throw new NotPossibleException("Invalid customer name.");
        }

        // @effects check validation of phone number
        if (validatephoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotPossibleException("Invalid customer phoneNumber.");
        }

        // @effects check validation of address 
        if (validateaddress(address)) {
            this.address = address;
        } else {
            throw new NotPossibleException("Invalid customer address.");
        }

    }

    /**
     * getter of class Customer
     *
     * @effects 
     *          return id, name, phone number, address of customers 
     *          if valid with regard to abstract properties
     */
    //attribute references
    /**
     * @return @effects return Customer.id
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }

    /**
     * @effects return customer.name
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects return Customer.phoneNumber
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @effects return Customer.address
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * Setter of id, name, phoneNumber, address
     */
    /**
     * @effects 
     * if name is valid 
     *      set this.name = name 
     * else 
     *      throw new NotPossibleException
     * @param name
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("name")
    public void setName(String name) throws NotPossibleException {
        if (validatename(name)) {
            this.name = name;
        } else {
            throw new NotPossibleException("Invalid customer's name." + name);
        }
    }

    /**
     * @effects 
     * if phoneNumber is valid 
     *      set this.phoneNumber = phoneNumber 
     * else
     *      throw new NotPossibleException
     * @param phoneNumber
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("phoneNumber")
    public void setphoneNumber(String phoneNumber) throws NotPossibleException {
        if (validatephoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotPossibleException("Invalid customer's phone number." + phoneNumber);
        }
    }

    /**
     * @effects 
     * if address is valid 
     *      set this.address = address 
     * else 
     *      throw new NotPossibleException
     * @param address
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("address")
    public void setAddress(String address) throws NotPossibleException {
        if (validatename(address)) {
            this.address = address;
        } else {
            throw new NotPossibleException("Invalid customer's address." + address);
        }
    }

// validator
    /**
     * @effects 
     * if id not null and id < 1000000 
     *      return true 
     * else 
     *      return false
     * @param id
     */
    protected boolean validateId(int id) {
        if (id > 1 && id < (1000000)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects 
     * if name is not null and name.length() <= 50 
     *      return true 
     * else
     *      return false @param name
     */
    private boolean validatename(String name) {
        if (name.length() > 0 && name.length() <= 50) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects 
     * if phone number is not null and length of phone number <=10
     *      return true 
     * else 
     *      return false 
     * @param phonenumber
     */
    private boolean validatephoneNumber(String phonenumber) {
        if (phonenumber.length() > 0 && phonenumber.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects 
     * if address is not null and address.length <=100 
     *      return true 
     * else
     *      return false 
     * @param address
     */
    private boolean validateaddress(String address) {
        if (address.length() > 0 && address.length() < 100) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * repOK
     *
     * @effects <pre>
     *            if id, name, phone, address are valid with regard to abstract properties
     *              return true
     *            else
     *              return false </pre>
     */
    public boolean repOK() {
        if (validateId(id) && validatename(name) && validatephoneNumber(phoneNumber) && validateaddress(address)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @efects check the validation of name by compareTo an object O
     *
     */
    @Override
    public int compareTo(Object x) {
        Customer newcust = (Customer) x;
        int i = this.name.compareTo(newcust.name);
        return i;
    }

    /**
     * @effects return id, name, phone number and address of Customers to String Customer<>
     */
    @Override
    public String toString() {
        return ("Customer <" + id + ", " + name + ", " + phoneNumber + ", " + address + ">");
    }
}
