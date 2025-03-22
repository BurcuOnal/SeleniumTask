package pages;

import com.useinsider.methods.BaseMethods;

public class CareersOpenPositions extends BaseMethods {

    public void checkCareersOpenPositionsPage(){

        checkURLContains("/careers/open-positions");
        waitBySecond(2);
        checkForElement("careersOpenPositionsPageTitle","Cannot find the open positions title!");
    }

    public void filterOpenPositions(){

      scrollToElementToBeVisible("careersOpenPositionsFilterByLocationDropDown");
      waitForElementToBeVisible("checkSearchPageisOpen");
      clickElement("careersOpenPositionsFilterByLocationDropDown");
      clickElement("careersOpenPositionLocationDropDownListIstanbul");
      checkForElement("careersOpenPositionLocationCheckIstanbul","Istanbul cannot be selected!");
      waitBySecond(3);
      clickElement("careersOpenPositionsFilterByDepartmentDropDown");
      waitForElementToBeVisible("careersOpenPositionDepartmentDropDownListQA");
      clickElement("careersOpenPositionDepartmentDropDownListQA");
      waitBySecond(3);
      checkForElement("careersOpenPositionDepartmantCheckQA","QA cannot be selected!");
      waitBySecond(3);
    }

    public void checkOpenPositions(){
        scrollToElementToBeVisible("sectionOfThePositionArea");
        waitForElementToBeVisible("careersOpenPositionJobsPositionTitles");
        checkIsTextContainsList("careersOpenPositionJobsPositionDepartment", "Quality Assurance");
        saveValueLastJob("careersOpenPositionJobsPositionDepartment");
        waitBySecond(3);
        checkIsTextContainsList("careersOpenPositionJobPositionLocation", "Istanbul, Turkiye");
        saveValueLastJob("careersOpenPositionJobPositionLocation");
        waitBySecond(1);
    }

    public void clickViewRoleBtn() {
        hoverOverElementWithSelectedSize("careersOpenPositionViewRoleBtn");
        clickElementWithSelectedSize("careersOpenPositionViewRoleBtn");
        logger.info("navigating to the job lever page");

    }


}
