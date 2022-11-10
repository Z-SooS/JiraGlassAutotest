import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'login.doLogin'()

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_System Dashboard - Jira Expert/span_Administration'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_System Dashboard - Jira Expert/a_Issues'))

WebUI.setEncryptedText(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Administrator Access - Jira Expert/input_Password_webSudoPassword'), 
    'wk967+4M7AhWXKrDr+iFCw==')

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Administrator Access - Jira Expert/input_Password_login-form-submit'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Issue types - Jira Expert/a_Workflows'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Workflows - Jira Expert/strong_Software Simplified Workflow for Pro_b4eb6b'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Workflows - Jira Expert/a_Edit'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Edit workflow  Software Simplified Wor_248208/a_Diagram'))

WebUI.click(findTestObject('Object Repository/Show_Transition_Labels_Repo/Page_Edit  Software Simplified Workflow for_6e178f/input_Add transition_show-transition-labels'))

WebUI.verifyElementPresent(findTestObject('Show_Transition_Labels_Repo/Page_Edit  Software Simplified Workflow for_6e178f/tspan_Approve'), 
    0)

WebUI.verifyElementPresent(findTestObject('Show_Transition_Labels_Repo/Page_Edit  Software Simplified Workflow for_6e178f/tspan_Start Draft'), 
    0)

WebUI.verifyElementPresent(findTestObject('Show_Transition_Labels_Repo/Page_Edit  Software Simplified Workflow for_6e178f/tspan_Rejected'), 
    0)

WebUI.verifyElementPresent(findTestObject('Show_Transition_Labels_Repo/Page_Edit  Software Simplified Workflow for_6e178f/tspan_Submit to Review'), 
    0)

