


import java.sql.ResultSet;
import java.sql.SQLException;

class Private_Practice2 {

    private static ResultSet rsPrime;

    private static psychModel2 psychModelPrime;

    private static Private_PracticeGUI2 psychGUI;

    public static void main(String[] args){
        Private_Practice2 practice = new Private_Practice2();
        practice.initialize();
    }


    public void initialize(){



            psychGUI = new Private_PracticeGUI2(this);




    }
}

