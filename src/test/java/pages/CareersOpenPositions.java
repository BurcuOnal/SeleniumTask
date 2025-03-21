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

      clickElement("careersOpenPositionsFilterByDepartmentDropDown");
      waitForElementToBeVisible("careersOpenPositionDepartmentDropDownListQA");

      clickElement("careersOpenPositionDepartmentDropDownListQA");
      checkForElement("careersOpenPositionDepartmantCheckQA","QA cannot be selected!");
      waitBySecond(3);
    }

    public void checkOpenPositions(){
        scrollToElementToBeVisible("sectionOfThePositionArea");
        waitForElementToBeVisible("careersOpenPositionJobsPositionTitles");
        waitBySecond(5);
        //checkIsTextContainsList("careersOpenPositionJobsPositionTitles", "Quality Assurance");
       // waitBySecond(3);
        //saveValueLastJob("careersOpenPositionJobsPositionTitles");
       // waitBySecond(3);
        checkIsTextContainsList("careersOpenPositionJobsPositionDepartment", "Quality Assurance");
        saveValueLastJob("careersOpenPositionJobsPositionDepartment");
        checkIsTextContainsList("careersOpenPositionJobPositionLocation", "Istanbul, Turkey");
        saveValueLastJob("careersOpenPositionJobPositionLocation");
        waitBySecond(1);
    }

    public void clickViewRoleBtn() {
        hoverOverElementWithSelectedSize("careersOpenPositionViewRoleBtn");
        clickElementWithSelectedSize("careersOpenPositionViewRoleBtn");
        logger.info("Seçilen Job ekranına gidiliyor");

    }


}
