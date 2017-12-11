

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
    Private_Practice2 manager;

    public Private_PracticeGUI2(Private_Practice2 manager, psychModel2 guiModel){

        setContentPane(clinicPanel);

        pack();

        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.manager = manager;

        clinicTable2.setModel(guiModel);

       // clinicScrollPane2.setViewportView(clinicTable2);

        clinicTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //columns and such
        JTableHeader clinicHeader = clinicTable2.getTableHeader();

        TableColumnModel clinicColMod = clinicHeader.getColumnModel();

        TableColumn clinicColumn = clinicColMod.getColumn(0);

        clinicColumn.setHeaderValue("id");


        //patient name
        clinicColumn = clinicColMod.getColumn(1);

        clinicColumn.setHeaderValue("Patient Name");


        //Doctor name
        clinicColumn = clinicColMod.getColumn(2);

        clinicColumn.setHeaderValue("Doctor Name");


        addPatientData2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String patientName = patient_name_textField2.getText();

                String doctorName = doctor_textField2.getText();

                guiModel.addData(patientName, doctorName);

            }
        });



    }

}

