package test.testng.buttons;

import org.testng.annotations.DataProvider;

public class ButtonsData {
    @DataProvider(name = "checkButtonEnabled")
    public static Object[][] checkButtonEnabled() {
        Object[][] data = new Object[4][2];
        //
        data[0][0] = 1;
        data[0][1] = true;
        //
        data[1][0] = 2;
        data[1][1] = true;
        //
        data[2][0] = 3;
        data[2][1] = true;
        //
        data[3][0] = 4;
        data[3][1] = false;
        //
        return data;
    }
}
