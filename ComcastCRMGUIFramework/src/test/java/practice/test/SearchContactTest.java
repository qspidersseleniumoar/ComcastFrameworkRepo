package practice.test;
/**
 * test class for Contact module
 * @author Deepak
 *
 */

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass{
	/**
	 *  Scenario : login()==> navigateConatct==>createcontact()==verify
	 */
	
	@Test
	public void searchcontactTest() {
		/*step 1 : login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "pas");
	}

}
