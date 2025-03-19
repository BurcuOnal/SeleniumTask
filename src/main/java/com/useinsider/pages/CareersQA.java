package com.useinsider.pages;

import com.useinsider.methods.BaseMethods;

public class CareersQA extends BaseMethods {
    // - assert navigation to the career page
    public void checkCareerQAPage(){

        checkURLContains("/careers/quality-assurance");
        checkForElement("careersQAPageTitle","Cannot find the QA title");
    }


    public void goToQAOpenPositions() {

        clickElement("careersQAPageSeeAllJobsBtn");
        logger.info("Navigating to Careers Open Positions page");
    }
}
