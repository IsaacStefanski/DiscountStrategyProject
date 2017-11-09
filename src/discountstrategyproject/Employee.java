package discountstrategyproject;

import java.util.Objects;

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

    public final void setEmployeeID(String employeeID)throws IllegalArgumentException  {
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
    public final void setName(String name)throws IllegalArgumentException {
        if(name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Employee name cannot be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.employeeID);
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.employeeID, other.employeeID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", name=" + name + '}';
    }
}