import com.telran.data.UserData;
import com.telran.pages.HomePage;
import com.telran.pages.JSExecutor;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorTest extends TestBase {


    @Test
    public void registerWithJSExecutorTest(){
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).enterNameAndEmailWithJSE(UserData.USER_NAME, UserData.USER_EMAIL)
                .clickOnSubmitButtonWithJSE();
    }

    @Test
    public void checkBoxWithJSExecutorTest(){
        new HomePage(driver).getForms();
        new SidePanelPage(driver).selectPracticeForm();
        new JSExecutor(driver).checkboxWithJSE().refreshWithJSE().getTitleWithJSE().getURLPageWithJSE()
                .scrollWithJSE();
    }
}
