package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class Employee implements Person {
    private String employeeID;
    private String name;
    

    public Employee(String employeeID, String name) {
        setEmployeeID(employeeID);
        setName(name);
    }
    
    @Override
    public final String getID(){
        return getEmployeeID();
    }

    public final String getEmployeeID() {
        return employeeID;
    }

    public final void setEmployeeID(String employeeID) {
        if(employeeID != null){
            this.employeeID = employeeID;
        } else {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final void setName(String name) {
        if(name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Employee name cannot be null");
        }
    }
}