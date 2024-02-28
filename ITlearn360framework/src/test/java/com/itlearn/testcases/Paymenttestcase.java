package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

import com.itlearn.pages.PaymentPage;

public class Paymenttestcase extends BaseTest{
	 
		String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
		
		@Test(priority =1)
		void Paymenttestcase()
		{
			LoginPage lp=new LoginPage(driver);
			String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
			String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
			lp.loginPortal(username, password);
			
			DashBoardPage DP= new DashBoardPage(driver);
			DP.dashBoardClick();
			
			PaymentPage pg = new PaymentPage(driver);
			String cardnumber=ReadExcelFile.getCellValue(fileName, "carddetails", 0, 1);
			String expdate=ReadExcelFile.getCellValue(fileName, "carddetails", 0, 2);
			String cvcnumber=ReadExcelFile.getCellValue(fileName, "carddetails", 0, 3);
			
			pg.paymentOption(cardnumber, expdate, cvcnumber);
		}
		
}
