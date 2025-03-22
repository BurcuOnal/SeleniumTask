package testCases;

import com.useinsider.base.BaseTest;
import pages.*;
import org.junit.Test;

public class WebTest1 extends BaseTest {


    @Test
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

        testCase01: Navigate to the career page and check certain modules
        if they are exist on the page or not

        */
        Home homepage = new Home();
        Careers careerspage = new Careers();

        homepage.checkHomePage();
        homepage.navigateToCareerPage();
        careerspage.checkCareerPage();
        careerspage.visibilityOfTeamsModule();
        careerspage.visibilityOfLocationsModule();
        careerspage.visibilityOfLifeAtInsiderModule();

    }

    @Test
    public void testCase02() {
        /*

        testCase02:
        * Filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”,
        check the presence of the jobs list.
        * Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”,
        and Location contains “Istanbul, Turkey”
        * Click the “View Role” button and check that this action redirects us to the Lever Application form page

        */
        CareersQA careersQA = new CareersQA();
        CareersOpenPositions careersOpenPositions = new CareersOpenPositions();
        JobLever jobLever = new JobLever();

        careersQA.checkCareerQAPage();
        careersQA.goToQAOpenPositions();
        careersOpenPositions.checkCareersOpenPositionsPage();
        careersOpenPositions.filterOpenPositions();
        careersOpenPositions.checkOpenPositions();
        careersOpenPositions.clickViewRoleBtn();
        jobLever.checkJobLeverPage();

    }

}
