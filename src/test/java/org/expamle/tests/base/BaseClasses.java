package org.expamle.tests.base;

import org.example.framework.managers.DriverManager;
import org.example.framework.managers.InitManager;
import org.example.framework.managers.PageManager;
import org.example.framework.managers.TestPropManager;
import org.example.framework.utils.MyAllureListener;
import org.example.framework.utils.PropConst;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(MyAllureListener.class)
public class BaseClasses {

    /**
     * Менеджер страничек
     *
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void BeforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(PropConst.BASE_URL));
    }


    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }

}

