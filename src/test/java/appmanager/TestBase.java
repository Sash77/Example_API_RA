package appmanager;

import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();
    protected static final HashMap<String, String> hashMapLogin = new HashMap<>();


    @BeforeSuite
    protected void beforSuit() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException{
        app.init();
    }

    @AfterSuite
    protected void afterSuit(){
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(app.getProperty("allureBat"));
        arrayList.add(app.getProperty("allureCommand"));
        arrayList.add(app.getProperty("allureReport"));
        arrayList.add(app.getProperty("allureKey"));
        app.getJavaRunCommand().runCommand(arrayList);
    }

    @BeforeClass
    protected void beforeClass() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {}

    @AfterClass
    protected void afterClass(){}

    @BeforeMethod(alwaysRun = true)
    protected void logTestStart(Method m, Object[] p, ITestContext context){
        app.setCheck("Before method");
        context.setAttribute("app", app);
        context.setAttribute("className",m.getDeclaringClass().getName());
        ApplicationManager.setLogger(this.getClass());
        app.getLogger().info("Start test "+m.getName()+" with parameters "+ Arrays.asList(p)+" on "+app.returnCurrentDateFullData());
    }

    @AfterMethod(alwaysRun = true)
    protected void logTestStop(Method m){
        app.setCheck("After method");
        app.getLogger().info("Stop test "+m.getName()+" on "+app.returnCurrentDateFullData()+"\r\n");
    }

    public void logTrace(String value) {
        app.getLogger().trace(value);
    }

}
