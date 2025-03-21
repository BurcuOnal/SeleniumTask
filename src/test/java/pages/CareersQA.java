package pages;

import com.useinsider.methods.BaseMethods;

import static com.useinsider.base.BaseTest.configReader;

public class CareersQA extends BaseMethods {
    // ** assert navigation to the career page
    public void checkCareerQAPage(){

        driver.get(configReader.getFilePath("careersQAUrl"));
        System.out.println("Navigated to: " + driver.getCurrentUrl());
        checkURLContains("/careers/quality-assurance");
        checkForElement("careersQAPageTitle","Cannot find the QA title");
    }

    public void goToQAOpenPositions() {

        clickElement("careersQAPageSeeAllJobsBtn");
        logger.info("Navigating to Careers Open Positions page");
    }
}
