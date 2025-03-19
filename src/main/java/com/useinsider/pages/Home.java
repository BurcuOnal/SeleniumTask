package com.useinsider.pages;

import com.useinsider.methods.BaseMethods;

public class Home extends BaseMethods {


    public void checkHomePage() {
        waitForElementToBeVisible("homePageInsiderLogo");
        checkURLContains("useinsider.com");
        checkForElement("homePageInsiderLogo", "insider logo not visible, Homepage not open");
    }

    public void navigateToCareerPage() {
         /*
         Navigate to the career page
        Select the “Company” menu in the navigation bar, select “Careers” and check Career
        page, its Locations, Teams, and Life at Insider blocks are open or not
        */
        clickElement("homePageCompanyDropdownMenu");
        checkForElement("homePageCompanyDropdownMenuCareersBtn", "Carrer button not be visibled.");
        clickElement("homePageCompanyDropdownMenuCareersBtn");

    }

}
