package test.testng.contact_us;

import org.testng.annotations.DataProvider;

public class ContactUsFormData {
    @DataProvider(name = "checkForWrongFilledContactForm")
    public static Object[][] checkForWrongFilledContactForm() {
        Object[][] data = new Object[12][5];
        //
        data[0][0] = "";
        data[0][1] = "Cruise";
        data[0][2] = "tom.cruise@gmail.com";
        data[0][3] = "I am Tom Cruise!";
        data[0][4] = "Error: all fields are required";
        //
        data[1][0] = "Tom";
        data[1][1] = "";
        data[1][2] = "tom.cruise@gmail.com";
        data[1][3] = "I am Tom Cruise!";
        data[1][4] = "Error: all fields are required";
        //
        data[2][0] = "Tom";
        data[2][1] = "Cruise";
        data[2][2] = "";
        data[2][3] = "I am Tom Cruise!";
        data[2][4] = "Error: all fields are required\n" +
                "Error: Invalid email address";
        //
        data[3][0] = "Tom";
        data[3][1] = "Cruise";
        data[3][2] = "tom.cruise@gmail.com";
        data[3][3] = "";
        data[3][4] = "Error: all fields are required";
        //
        data[4][0] = "Tom";
        data[4][1] = "Cruise";
        data[4][2] = "d@s.c";
        data[4][3] = "I am Tom Cruise!";
        data[4][4] = "Error: Invalid email address";
        //
        data[5][0] = "Tom";
        data[5][1] = "Cruise";
        data[5][2] = "com.gmail@d.s";
        data[5][3] = "I am Tom Cruise!";
        data[5][4] = "Error: Invalid email address";
        //
        data[6][0] = "Tom";
        data[6][1] = "Cruise";
        data[6][2] = "d#@gmial.com";
        data[6][3] = "I am Tom Cruise!";
        data[6][4] = "Error: Invalid email address";
        //
        data[7][0] = "Tom";
        data[7][1] = "Cruise";
        data[7][2] = "@tom.cruise@gmial.com";
        data[7][3] = "I am Tom Cruise!";
        data[7][4] = "Error: Invalid email address";
        //
        data[8][0] = "1";
        data[8][1] = "Cruise";
        data[8][2] = "tom.cruise@gmail.com";
        data[8][3] = "I am Tom Cruise!";
        data[8][4] = "Error: Invalid first name";
        //
        data[9][0] = "@";
        data[9][1] = "Cruise";
        data[9][2] = "tom.cruise@gmail.com";
        data[9][3] = "I am Tom Cruise!";
        data[9][4] = "Error: Invalid first name";
        //
        data[10][0] = "Tom";
        data[10][1] = "2";
        data[10][2] = "tom.cruise@gmail.com";
        data[10][3] = "I am Tom Cruise!";
        data[10][4] = "Error: Invalid last name";
        //
        data[11][0] = "Tom";
        data[11][1] = "#";
        data[11][2] = "tom.cruise@gmail.com";
        data[11][3] = "I am Tom Cruise!";
        data[11][4] = "Error: Invalid last name";
        //
        return data;
    }
}
