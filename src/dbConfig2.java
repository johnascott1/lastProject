


import java.sql.*;
import java.text.SimpleDateFormat;


public class dbConfig2 {

    static String dbUrl = "jdbc:sqlite:privateClinic.db";


    private static Statement primeStatement = null;

    private static Connection primeConnection = null;

    private static ResultSet primeResultSet = null;

    private static PreparedStatement primePrepSt = null;


    private static String patient_table_name = "private_clinic_portal";

    private static DataSet data = null;


    final static String primaryKeyCol = "id";

    final static String nameCol = "patientName";

    final static String doctorCol = "doctorName";

    final static String insuranceCol = "Insurance";

    final static String medicationCol = "Medication";

    final static String allergyCol = "Allergies";

    final static String balanceCol = "Balance_Due";

    final static String lastSeenCol = "Last_Seen";

    final static String nextAptCol = "Next_Appointment";

    final static String conditionsCol = "Diagnosed_Conditions";

    final static String streetAddressCol = "Street_Address";

    final static String emailCol = "Email";

    final static String phoneNumCol = "Phone_Number";





    /*static ResultSet setup(String tableName) throws SQLException {


        primeConnection = DriverManager.getConnection(dbUrl);

        primeStatement = primeConnection.createStatement();

        retrieveData();

        String fetchAll = "Select * From private_clinic_portal";

        primeResultSet = primeStatement.executeQuery(fetchAll);

        return primeResultSet;

    }*/
    
    
    
    static DataSet getAllData() {

        try (Connection primeConnection = DriverManager.getConnection(dbUrl)) {
        /*
        Statement delState = primeConnection.createStatement();
        String delString = "DROP TABLE private_clinic_portal";

        delState.executeUpdate(delString);
        */
        Statement statement = primeConnection.createStatement();
    
        retrieveData();
    
        String fetchAll = "Select * From private_clinic_portal";

        ResultSet resultSet = statement.executeQuery(fetchAll);
    
         data = new DataSet();
        
        while (resultSet.next()) {
            
            int id = resultSet.getInt("id");
            String  name = resultSet.getString(nameCol);
            String doctor = resultSet.getString(doctorCol);
            Patient p = new Patient(id, name, doctor);
            data.addPatient(p);
        }
        primeConnection.close();
        resultSet.close();
        return data;
        
    }
        catch (SQLException e) {
        System.out.println("Error getting all data");
        
        return null;
        }



        
    }

    static void insertData(String patient, String doctor, String insurance, String medication, String Allergies,
    String balance, String lastSeen, String nextApt, String conditions, String address, String email, String phone ){

        try{

            primeConnection = DriverManager.getConnection(dbUrl);

            Statement insertStatement = primeConnection.createStatement();
            //Would have been input validation.
            /*

            Double checkBalance = Double.parseDouble(balance);

            int checkPhone = Integer.parseInt(phone);

            SimpleDateFormat checkDate = new SimpleDateFormat("MM/DD/YYYY");

            checkDate.format(lastSeen);

            checkDate.format(nextApt);
            */
            String insertString = ("INSERT INTO private_clinic_portal(patientName, doctorName, Insurance, Medication, " +
                    " Allergies, Balance_Due, Last_Seen, Next_Appointment, Diagnosed, Street_Address, Email, Phone_Number) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)");

            PreparedStatement updatePS = primeConnection.prepareStatement(insertString);

            updatePS.setString(1, patient);

            updatePS.setString(2, doctor);
            updatePS.setString(3, insurance);
            updatePS.setString(4, medication);
            updatePS.setString(5, Allergies);
            updatePS.setString(6, balance);
            updatePS.setString(7, lastSeen);
            updatePS.setString(8, nextApt);
            updatePS.setString(9, conditions);
            updatePS.setString(10, address);
            updatePS.setString(11, email);
            updatePS.setString(12, phone);

            updatePS.executeUpdate();
            //insertStatement.executeUpdate(insertString);
            updatePS.close();
            System.out.println("Update");
            //Statement updateStatement = primeConnection.createStatement();
            //String updateString = ("Select * From private_clinic_portal");
            //updateStatement.executeQuery(updateString);
            //updateStatement.close();
            primeConnection.close();
            System.out.println("update2");
            //refresh = getAllData();

            //return getAllData();

        }

        catch (SQLException insertError){
            System.out.println("oops");
            insertError.printStackTrace();


        }




        //return null;

    }



    static void retrieveData()  {
        try {
            primeConnection = DriverManager.getConnection(dbUrl);
            Statement makeTableST = primeConnection.createStatement();
            String makeTable = "CREATE TABLE IF NOT EXISTS " + patient_table_name + " (" + primaryKeyCol +
                    " integer primary key autoincrement, " + nameCol  + " text, " + doctorCol + " text, " +
                    insuranceCol + " text, " + medicationCol + " text, " + allergyCol + " text, " + conditionsCol + " text, "+ balanceCol + " text, " +
                    lastSeenCol + " text, " + nextAptCol + " text, " + streetAddressCol + " text, " + emailCol + " text, " +
                    phoneNumCol + " text )";

            makeTableST.executeUpdate(makeTable);
        }
        catch (SQLException createError){
            createError.printStackTrace();
        }



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
