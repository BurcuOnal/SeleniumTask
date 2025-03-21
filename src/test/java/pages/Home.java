package pages;

import com.useinsider.methods.BaseMethods;

public class Home extends BaseMethods {


    public void checkHomePage() {
        waitForElementToBeVisible("homePageInsiderLogo");
        checkURLContains("useinsider.com");
        checkForElement("homePageInsiderLogo", "insider logo not visible, Homepage not open");
    }

    public void navigateToCareerPage() {

        // Navigate to the career page
        clickElement("homePageCompanyDropdownMenu");
        checkForElement("homePageCompanyDropdownMenuCareersBtn", "Carrer button not be visibled.");
        clickElement("homePageCompanyDropdownMenuCareersBtn");

    }

}
