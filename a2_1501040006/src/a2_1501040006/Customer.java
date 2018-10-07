package a2_1501040006;

import utils.DomainConstraint;
import utils.DOpt;
import utils.AttrRef;
import utils.OptType;
import utils.NotPossibleException;

/**
 * @overview <pre> A customer is a person or organization that are of interest to the
 * shop and buy goods or services from a store or business </pre>
 *
 * @attributes  <pre>
 *      id              Integer      Integer
 *      name            String       String
 *      phoneNumber     String       String
 *      address         String       String
 * </pre>
 *
 * @objects  <pre>
 *      A typical customer object is c = <i,n,p,a>
 *          where id(i),name(n),phoneNumber(p),address(a)
 * </pre>
 *
 * @abstract_properties  <pre>
 *          mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 1000000 /\
 *          mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 *          mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 *          mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 * </pre>
 *
 * @author quynhanhhle
 */
public class Customer implements Comparable {

    private static final int LENGTH_NAME = 50;

    private static final int LENGTH_PHONE = 10;

    private static final int LENGTH_ADDRESS = 100;

    private static final double MIN_ID = 1;

    private static final double MAX_ID = 1000000;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
    private int id;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_NAME)
    private String name;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_PHONE)
    private String phoneNumber;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_ADDRESS)
    private String address;

    /**
     * @effects <pre>
     *      if id, name, phoneNumber, address are valid
     *          initialize <tt>this</tt> as <id,name,phoneNumber,address>
     *      else
     *          throws NotPossibleException
     * </pre>
     *
     */
    @DOpt(type = OptType.Constructor)
    public Customer(@AttrRef("id") int id,
            @AttrRef("name") String name,
            @AttrRef("phoneNumber") String phoneNumber,
            @AttrRef("address") String address) throws NotPossibleException {
        if (validate(id, name, phoneNumber, address)) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.address = address;
//        } else {
//            throw new NotPossibleException("<init>: invalid inputs");
        }
    }

    /**
     * @effects @return <tt>id</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }

    /**
     * @modifies id
     * @effects <pre>
     *  if id is valid
     *      set this.id = id
     *  else
     *      throws NotPossibleException
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("id")
    public void setId(int id) throws NotPossibleException {
        if (validateID(id)) {
            this.id = id;
        } else {
            throw new NotPossibleException("invalid input: "+id);
        }
    }

    /**
     * @effects @return <tt>name</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @modifies name
     * @effects <pre>
     *  if name is valid
     *      set this.name = name
     *  else
     *      throws NotPossibleException
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("name")
    public void setName(String name) throws NotPossibleException {
        if (validateName(name)) {
            this.name = name;
        } else {
            throw new NotPossibleException("invalid input: "+name);
        }
    }

    /**
     * @effects @return <tt>phoneNumber</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @modifies phoneNumber
     * @effects <pre>
     *  if phoneNumber is valid
     *      set this.phoneNumber = phoneNumber
     *  else
     *      throws NotPossibleException
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("phoneNumber")
    public void setPhoneNumber(String phoneNumber) throws NotPossibleException {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotPossibleException("invalid input: "+phoneNumber);
        }
    }

    /**
     * @effects @return <tt>address</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * @effects <pre>
     *  if address is valid
     *      set this.address = address
     *  else
     *      throws NotPossibleException
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("address")
    public void setAddress(String address) throws NotPossibleException {
        if (validateAddress(address)) {
            this.address = address;
        } else {
            throw new NotPossibleException("invalid input: "+address);
        }
    }

    /**
     * @effects <pre>
     *            if id is valid
     *              return true
     *            else
     *              return false</pre>
     */
    protected boolean validateID(int id) {
        return (id >= MIN_ID && id <= MAX_ID);
    }

    /**
     * @effects <pre>
     *            if name is valid
     *              return true
     *            else
     *              return false</pre>
     */
    private boolean validateName(String name) {
        return !(name == null || name.trim().isEmpty() || name.length() > LENGTH_NAME);
    }

    /**
     * @effects <pre>
     *            if phoneNumber is valid
     *              return true
     *            else
     *              return false</pre>
     */
    private boolean validatePhoneNumber(String phoneNumber) {
        return !(phoneNumber == null || phoneNumber.trim().isEmpty() || phoneNumber.length() > LENGTH_PHONE);
    }

    /**
     * @effects <pre>
     *            if address is valid
     *              return true
     *            else
     *              return false</pre>
     */
    private boolean validateAddress(String address) {
        return !(address == null || address.trim().isEmpty() || address.length() > LENGTH_ADDRESS);
    }

    /**
     * @effects <pre>
     *            if <i,n,p,a> is a valid tuple
     *              return true
     *            else
     *              return false </pre>
     */
    private boolean validate(int id, String name, String phoneNumber, String address) {
        return validateID(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
    }

    /**
     * @effects @return the string representation of customer objects
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        if (validate(id, name, phoneNumber, address)) {
            return "Customer: {\"Id\": " + getId() + ", \"Name\": " + getName() + ", \"Phone Number\": " + getPhoneNumber() + ", \"Address\": " + getAddress() + "}";
        } else {
            return "Customer: {}";
        }
    }

    /**
     * @effects <pre>
     *      if <tt>this</tt> satifies the abstract properties
     *          return true
     *      else
     *          return false
     * </pre>
     */
    public boolean repOK() {
        return validate(id, name, phoneNumber, address);
    }

    /**
     * @effects compares <tt>this</tt> with the other for order <pre>
     *      if other eq null
     *          throws NullPointerException
     *      if other is not an instance of Customer
     *          throws ClassCastException
     *      if this > other
     *          return 1
     *      else if this < other
     *          return -1
     *      else this eq other
     *          return 0
     * </pre>
     */
    @Override
    public int compareTo(Object other) throws NullPointerException, ClassCastException {
        if (other == null) {
            throw new NullPointerException("object is null");
        }
        if (!(other instanceof Customer)) {
            throw new ClassCastException("not a customer");
        }
        Customer customer = (Customer) other;
        if (name.compareToIgnoreCase(customer.name) > 0) {
            return 1;
        } else if (name.compareToIgnoreCase(customer.name) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
