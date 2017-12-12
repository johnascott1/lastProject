import java.util.ArrayList;

/**
 * Created by clara on 12/11/17. For providing data to a JTable
 */
public class DataSet {
    
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> doctors = new ArrayList<>();
    ArrayList<String> insurance = new ArrayList<>();
    ArrayList<String> medication = new ArrayList<>();
    ArrayList<String> allergy = new ArrayList<>();
    ArrayList<String> balance = new ArrayList<>();
    ArrayList<String> lastSeen = new ArrayList<>();

    ArrayList<String> nextAPT = new ArrayList<>();
    ArrayList<String> diagnosedConditions = new ArrayList<>();
    ArrayList<String> streetAddress = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> phoneNumber = new ArrayList<>();

    
    public void addPatient(Patient p) {
        ids.add(p.id);
        names.add(p.name);
        doctors.add(p.doctor);
        insurance.add(p.insurance);
        medication.add(p.medicine);
        allergy.add(p.allergy);
        balance.add(p.balance);
        lastSeen.add(p.lastSeen);
        nextAPT.add(p.next_appointment);
        diagnosedConditions.add(p.Conditions);
        streetAddress.add(p.Address);
        email.add(p.email);
        phoneNumber.add(p.phoneNum);
    }
    
    public int getRows() {
        if (ids.size() > 0){
        return ids.size();}
        else {
            return 0;
        }
    }
    
    public Object valueAt(int rowIndex, int columnIndex) {
        
        if (columnIndex == 0) {
            return ids.get(rowIndex);
        }
        
        else if (columnIndex == 1) {
            return names.get(rowIndex);
        }
        
        else if (columnIndex == 2) {
            return doctors.get(rowIndex);
        }
        else if (columnIndex == 3){
            return insurance.get(rowIndex);
        }
        else if (columnIndex == 4){
            return medication.get(rowIndex);
        }
        else if (columnIndex == 5){
        return allergy.get(rowIndex);
        }

        else if (columnIndex == 6){
        return balance.get(rowIndex);
        }
        else if (columnIndex == 7){
            return lastSeen.get(rowIndex);

        }
        else if (columnIndex == 8){
            return nextAPT.get(rowIndex);
        }
        else if (columnIndex == 9){
        return diagnosedConditions.get(rowIndex);
        }
        else if (columnIndex == 10){
            return streetAddress.get(rowIndex);
        }
        else if (columnIndex == 11){
            return email.get(rowIndex);
        }
        else if (columnIndex == 12){
            return phoneNumber.get(rowIndex);
        }

        System.out.println("Trying to get data from unknown column " + columnIndex);
        return null;
        
    }
}
