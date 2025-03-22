package pages;

import com.useinsider.methods.BaseMethods;

public class JobLever extends BaseMethods {
    public void checkJobLeverPage() {
        // saved locators in the Careers Open Positions page used in this class to compare values
        switchToSecondTab();
        waitForElementToBeVisible("jobLeverPagejobTitle");
        isSavedValueEqualExpectedValue("jobLeverPageJobDepartment", "careersOpenPositionJobsPositionDepartment");
        isSavedValueEqualExpectedValue("jobLeverPageJobLocation", "careersOpenPositionJobPositionLocation");

    }
}
