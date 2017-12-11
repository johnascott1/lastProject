/**
 * Created by clara on 12/11/17.
 */
public class Patient {
    
    int id;
    String name;
    String doctor;
    
    public Patient(int id, String name, String doctor) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDoctor() {
        return doctor;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
