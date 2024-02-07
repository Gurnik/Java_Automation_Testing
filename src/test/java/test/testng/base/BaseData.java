package test.testng.base;

import org.testng.annotations.DataProvider;

public class BaseData {

    @DataProvider(name = "provideMenuListTitles")
    public static Object[][] provideMenuListTitles() {
        Object [][] data = new Object [21][2];

        data[0][0] = "Homepage".toUpperCase().trim();                  data[0][1] = 0;
        data[1][0] = "Accordion".toUpperCase().trim();                 data[1][1] = 1;
        data[2][0] = "Actions".toUpperCase().trim();                   data[2][1] = 2;
        data[3][0] = "Browser Tabs".toUpperCase().trim();              data[3][1] = 3;
        data[4][0] = "Buttons".toUpperCase().trim();                   data[4][1] = 4;
        data[5][0] = "Calculator (JS)".toUpperCase().trim();           data[5][1] = 5;
        data[6][0] = "Contact Us Form Test".toUpperCase().trim();      data[6][1] = 6;
        data[7][0] = "Date Picker".toUpperCase().trim();               data[7][1] = 7;
        data[8][0] = "DropDown Checkbox Radio".toUpperCase().trim();   data[8][1] = 8;
        data[9][0] = "File Upload".toUpperCase().trim();               data[9][1] = 9;
        data[10][0] = "Hidden Elements".toUpperCase().trim();          data[10][1] = 10;
        data[11][0] = "iFrames".toUpperCase().trim();                  data[11][1] = 11;
        data[12][0] = "Loader".toUpperCase().trim();                   data[12][1] = 12;
        data[13][0] = "Loader Two".toUpperCase().trim();               data[13][1] = 13;
        data[14][0] = "Login Portal Test".toUpperCase().trim();        data[14][1] = 14;
        data[15][0] = "Mouse Movement".toUpperCase().trim();           data[15][1] = 15;
        data[16][0] = "Pop Ups & Alerts".toUpperCase().trim();         data[16][1] = 16;
        data[17][0] = "Predictive Search".toUpperCase().trim();        data[17][1] = 17;
        data[18][0] = "Tables".toUpperCase().trim();                   data[18][1] = 18;
        data[19][0] = "Test Store".toUpperCase().trim();               data[19][1] = 19;
        data[20][0] = "About Me".toUpperCase().trim();                 data[20][1] = 20;

        return data;
    }
}
