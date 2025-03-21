package pages;

import com.useinsider.methods.BaseMethods;

public class Careers extends BaseMethods {

// ** assert navigation to the career page **
    public void checkCareerPage() {
        checkURLContains("/careers");
    }

// ** assert if 'Locations, Teams, and Life at Insider' titles are visible **

    //*Teams Module:
    public void visibilityOfTeamsModule() {

        scrollToElementToBeVisible("careersPageSeeAllTeamsBtn");
        javascriptclicker("careersPageSeeAllTeamsBtn");
        waitBySecond(2);
        checkForElement("careersPageTeamsSection", "teams section not visible");
    }
    //*Locations Module:
    public void visibilityOfLocationsModule() {

        scrollToElementToBeVisible("careersPageOurLocationsTitle");
        checkForElement("careersPageLocationsSection", "location section not visible");

    }
    //*Life at Insider Module:
    public void visibilityOfLifeAtInsiderModule() {
        scrollToElementToBeVisible("careersPageLifeaAtInsiderTitle");
        checkForElement("careersPageLifeaAtInsiderSection", "life at Insider section not visible");

    }
}
