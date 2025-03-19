package com.useinsider.pages;

import com.useinsider.methods.BaseMethods;

public class CareersOpenPositions extends BaseMethods {

    public void checkCareersOpenPositionsPage(){

        checkURLContains("/careers/open-positions");
        checkForElement("careersOpenPositionsPageTitle","Cannot find the open positions title!");
    }

    public void filterOpenPositions(){

      clickElement("careersOpenPositionsFilterByLocationDropDown");
      clickElement("careersOpenPositionLocationDropDownListIstanbul");
      checkForElement("careersOpenPositionLocationCheckIstanbul","Istanbul cannot be selected!");
      clickElement("careersOpenPositionsFilterByDepartmentDropDown");
      clickElement("careersOpenPositionDepartmentDropDownListQA");
      checkForElement("careersOpenPositionDepartmantCheckQA","QA cannot be selected!");

    }




}
