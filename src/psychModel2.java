


import javax.swing.table.AbstractTableModel;

import java.sql.*;


public class psychModel2 extends AbstractTableModel {

    private int rowCount = 0;

    private int columnCount = 0;

    private ResultSet initModelRS;

    psychModel2(ResultSet modelRS){

        this.initModelRS = modelRS;

        start();

    }


    private void start(){
        rowSum();

        try {
            columnCount = initModelRS.getMetaData().getColumnCount();
        }

        catch (SQLException startException){
            startException.printStackTrace();
        }

    }

    @Override
    public String getColumnName(int index) {
        String[] columnNames = {"ID", "patientName", "doctorName"};
        return columnNames[index];

    }

    public void updateResultSet(ResultSet updateRS){
        initModelRS = updateRS;
        start();
    }

    public void rowSum(){
        rowCount = 0;

        try {


            while (initModelRS.next()){
                rowCount++;
            }
        }

        catch (SQLException countRowError){
            countRowError.printStackTrace();
        }
    }


    @Override
    public int getRowCount() {
        rowSum();
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            initModelRS.absolute(rowIndex + 1);
            Object getValue = initModelRS.getObject(columnIndex + 1);
            return getValue.toString();

        } catch (SQLException sqle) {
            return sqle.getErrorCode();
        }
    }


    public void addData(String patientName, String doctorName){
        try {

            Connection newCon = DriverManager.getConnection(dbConfig2.dbUrl);

            Statement newStatement = newCon.createStatement();

            String applyUpdate = ("INSERT INTO private_clinic_portal(patientName, doctorName) VALUES (?, ?)");

            PreparedStatement updatePS = newCon.prepareStatement(applyUpdate);

            updatePS.setString(1, patientName);

            updatePS.setString(2, doctorName);

            newStatement.executeUpdate(applyUpdate);

            initModelRS.updateString(dbConfig2.nameCol, patientName);

            initModelRS.updateString(dbConfig2.doctorCol, doctorName);

            initModelRS.insertRow();

            fireTableDataChanged();

        }

        catch (SQLException addException){
            addException.getErrorCode();
        }

    }


}
