import java.util.ArrayList;

/**
 * Created by clara on 12/11/17. For providing data to a JTable
 */
public class DataSet {
    
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> doctors = new ArrayList<>();
    
    public void addPatient(Patient p) {
        ids.add(p.id);
        names.add(p.name);
        doctors.add(p.doctor);
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
    
        System.out.println("Trying to get data from unknown column " + columnIndex);
        return null;
        
    }
}
