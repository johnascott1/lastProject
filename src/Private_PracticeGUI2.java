

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;

public class Private_PracticeGUI2 extends JFrame {
    private JPanel clinicPanel;
    private JTable clinicTable2;
    private JTextField patient_name_textField2;
    private JTextField doctor_textField2;
    private JButton addPatientData2;
    private JLabel patient_name_label2;
    private JLabel doctor_label2;
    private JScrollPane clinicScrollPane2;
    private JTextField insuranceTextField;
    private JTextField perscriptionTextField;
    private JTextField allergyTextField;
    private JTextField balanceTextField;
    private JTextField lastSeenTextField;
    private JTextField nextAptTextField;
    private JTextField conditionsTextField;
    private JTextField addressTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JLabel insuranceLabel;
    private JLabel perscriptionLabel;
    private JLabel allergyField;
    private JLabel balanceLabel;
    private JLabel lastSeenLabel;
    private JLabel conditionLabel;
    private JLabel addressLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    Private_Practice2 manager;

    public Private_PracticeGUI2(Private_Practice2 manager){

        setContentPane(clinicPanel);

        pack();

        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.manager = manager;

        DataSet data = dbConfig2.getAllData();

        JTableDataModel model = new JTableDataModel(data);

       // clinicScrollPane2.setViewportView(clinicTable2);

        clinicTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        clinicTable2.setModel(model);

        //columns and such
        //JTableHeader clinicHeader = clinicTable2.getTableHeader();

        //TableColumnModel clinicColMod = clinicHeader.getColumnModel();

        //TableColumn clinicColumn = clinicColMod.getColumn(0);

        //clinicColumn.setHeaderValue("id");


        //patient name
        //clinicColumn = clinicColMod.getColumn(1);

        //clinicColumn.setHeaderValue("Patient Name");


        //Doctor name
       // clinicColumn = clinicColMod.getColumn(2);

        //clinicColumn.setHeaderValue("Doctor Name");






        addPatientData2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String patientName = patient_name_textField2.getText();

                String doctorName = doctor_textField2.getText();

                String insurance = insuranceTextField.getText();

                String medication = perscriptionTextField.getText();

                String allergy = allergyTextField.getText();

                String balance = balanceTextField.getText();

                String lastSeen = lastSeenTextField.getText();

                String nextApt = nextAptTextField.getText();

                String condition = conditionsTextField.getText();

                String Address = addressTextField.getText();

                String email = emailTextField.getText();

                String phone = phoneTextField.getText();

                //guiModel.addData(patientName, doctorName);

                dbConfig2.insertData(patientName, doctorName, insurance, medication, allergy, balance, lastSeen,
                        nextApt, condition, Address, email, phone);
                model.fireTableDataChanged();
               // clinicTable2.setModel(model);


                //JTableDataModel newModel = new JTableDataModel(newData);

                //clinicTable2.setModel(newModel);

               // model.fireTableDataChanged();

            }
        });



    }

}

