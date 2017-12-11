


import java.sql.*;


public class dbConfig2 {

    static String dbUrl = "jdbc:sqlite:privateClinic.db";


    private static Statement primeStatement = null;

    private static Connection primeConnection = null;

    private static ResultSet primeResultSet = null;

    private static PreparedStatement primePrepSt = null;


    private static String patient_table_name = "private_clinic_portal";


    final static String primaryKeyCol = "id";

    final static String nameCol = "patientName";

    final static String doctorCol = "doctorName";


    static ResultSet setup(String tableName) throws SQLException {

        primeConnection = DriverManager.getConnection(dbUrl);

        primeStatement = primeConnection.createStatement();

        retrieveData();

        String fetchAll = "Select * From private_clinic_portal";

        primeResultSet = primeStatement.executeQuery(fetchAll);

        return primeResultSet;

    }
    
    
    
    static DataSet getAllData() {
    
        try (Connection primeConnection = DriverManager.getConnection(dbUrl)) {
    
        Statement statement = primeConnection.createStatement();
    
//        retrieveData();
    
        String fetchAll = "Select * From private_clinic_portal";
    
        ResultSet resultSet = statement.executeQuery(fetchAll);
    
        DataSet data = new DataSet();
        
        while (resultSet.next()) {
            
            int id = resultSet.getInt("id");
            String  name = resultSet.getString(nameCol);
            String doctor = resultSet.getString(doctorCol);
            Patient p = new Patient(id, name, doctor);
            data.addPatient(p);
        }
        
        return data;
        
    }
        catch (SQLException e) {
        System.out.println("Error getting all data");
        
        return null;
        }
        
    }



    static void retrieveData() throws SQLException {

        String makeTable = "CREATE TABLE IF NOT EXISTS " + patient_table_name + " (" + primaryKeyCol +
                " integer primary key autoincrement, " + nameCol  + " text, " + doctorCol + " text)";

        primeStatement.executeUpdate(makeTable);

    }

    public static String getPatient_table_name() {
        return patient_table_name;
    }

    static void closeTable(){
        try {
            if (primeResultSet != null){
                primeResultSet.close();
                System.out.println("Result set closed");
            }
        }
        catch (SQLException closeException){
            closeException.printStackTrace();
        }
        try {
            if (primeStatement != null){
                primeStatement.close();
                System.out.println("Statement closed");
            }
        }
        catch (SQLException closeException){
            closeException.printStackTrace();
        }

        try {
            if (primeConnection != null){
                primeConnection.close();
                System.out.println("Database connection closed");
            }
        }
        catch (SQLException closeException){
            closeException.printStackTrace();
        }
    }

}
