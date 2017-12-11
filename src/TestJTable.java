import javax.swing.*;

/**
 * Created by clara on 12/11/17.
 */
public class TestJTable extends JFrame{
    
    
    public static void main(String[] args) {
        TestJTable gui = new TestJTable();
        
    }
    
    TestJTable() {
        setContentPane(panel);
        pack();
        setVisible(true);
        
        DataSet data = dbConfig2.getAllData();
        JTableDataModel model = new JTableDataModel(data);
        table1.setModel(model);
        
    }
    
    private JTable table1;
    private JPanel panel;
}
