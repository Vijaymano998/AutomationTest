package repository;

public class OtpRepository
{
	public static final String otpPage_enterOTP = "OTP,xpath,//input[@placeholder='Enter OTP']";
	public static final String otpPage_clickOTPText = "Enter the OTP,xpath,//label[contains(text(),'Enter the OTP')]";
	public static final String otpPage_sentto = "OTP listbox,xpath,//div[@class='modal-body']//span[@class='k-dropdown-wrap']";
	public static final String otpPage_sendtoList = "OTP listbox,xpath,//*[@class='k-list k-reset']//li";
	public static final String otppage_confirmbtn = "Confirm CTA,xpath,//button[text()='Confirm']";
	public static final String totppage_cancelbtn = "Cancel button,xpath,//button[text()='Cancel']";

}
