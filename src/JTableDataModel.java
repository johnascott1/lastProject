import javax.swing.table.AbstractTableModel;

/**
 * Created by clara on 12/11/17.
 */
public class JTableDataModel extends AbstractTableModel {
    
    
    DataSet dataset;
    
    JTableDataModel(DataSet dataSet) {
        this.dataset = dataSet;
    }


    
    @Override
    public int getRowCount() {
    try {
        return dataset.getRows();
    }
    catch (NullPointerException noRows){
        return 0;
    }



    }
    
    @Override
    public int getColumnCount() {
        return 13;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dataset.valueAt(rowIndex, columnIndex);
    }
}
