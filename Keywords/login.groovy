import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class login {
	
	@Keyword
	def doLogin() {
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl('https://jira-expert.codecool.metastage.net/secure/Dashboard.jspa')
		
		WebUI.setText(findTestObject('Object Repository/login_repo/Page_System Dashboard - Jira Expert/input_U_os_username'), 'codecooladmin')
		
		WebUI.setEncryptedText(findTestObject('Object Repository/login_repo/Page_System Dashboard - Jira Expert/input_P_os_password'),
			'wk967+4M7AhWXKrDr+iFCw==')
		
		WebUI.click(findTestObject('Object Repository/login_repo/Page_System Dashboard - Jira Expert/input_Jira administrators_login'))
	}
}
