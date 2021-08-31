package org.example.framework.utils;


import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.example.framework.managers.DriverManager;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyAllureListener extends AllureJunit5 implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if(extensionContext.getExecutionException().isPresent()){
            addScreenshot();
        }
    }

    @Attachment(value="screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
