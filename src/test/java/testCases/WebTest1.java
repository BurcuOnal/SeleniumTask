package testCases;

import com.useinsider.driver.BaseTest;
import com.useinsider.pages.Home;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class WebTest1 extends BaseTest {


    @BeforeEach

    public void testCase00() {
        /*
        testCase00: check insider homepage is open or not
        */
        Home homepage = new Home();
        homepage.checkHomePage();

    }

    @Test
    public void testCase01() {
/*
Navigate to the career page and certain locators
 */
        Home homepage = new Home();
        homepage.checkHomePage();

    }

}
