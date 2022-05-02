package com.OrangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CyberSuccess.com.org.BaseClass;

public class RecruitmentPage extends BaseClass {
	
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public WebElement recruitmentModule;
	
	@FindBy(id="addCandidate_firstName")
	public WebElement firstName;
	
	@FindBy(id="addCandidate_lastName")
	public WebElement lastName;
	
	@FindBy(id="addCandidate_email")
	public WebElement email;

}
