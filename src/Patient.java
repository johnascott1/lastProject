/**
 * Created by clara on 12/11/17.
 */
public class Patient {
    
    int id;
    String name;
    String doctor;
    String insurance;
    String medicine;
    String allergy;
    String balance;
    String lastSeen;
    String next_appointment;
    String Conditions;
    String Address;
    String email;
    String phoneNum;
    
    public Patient(int id, String name, String doctor, String insurance, String medicine, String allergy, String balance, String lastSeen, String next_appointment, String Conditions,
                   String Address, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
        this.insurance = insurance;
        this. medicine = medicine;
        this.allergy = allergy;
        this.balance = balance;
        this.lastSeen = lastSeen;
        this.next_appointment = next_appointment;
        this.Conditions = Conditions;
        this.Address = Address;
        this.email = email;
        this.phoneNum = phoneNum;
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

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getBalance() {
        return balance;
    }

    public void setNext_appointment(String next_appointment) {
        this.next_appointment = next_appointment;
    }

    public void setConditions(String conditions) {
        Conditions = conditions;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public String getNext_appointment() {
        return next_appointment;
    }

    public String getConditions() {
        return Conditions;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
