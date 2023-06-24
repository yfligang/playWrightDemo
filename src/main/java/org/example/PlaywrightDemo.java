package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

/*
   用例编写
 */
public class PlaywrightDemo {
    //先定义一些参数
    static Playwright playwright;
    static Browser browser;
    static BrowserType browserType;
    static BrowserContext browserContext;
    static Page page;


    //先执行打开浏览器的网页
    @BeforeClass
    public static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setArgs(Collections.singletonList("--start-maximized"))
                .setHeadless(false).setSlowMo(5000));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920,1080));
        page = browserContext.newPage();

    }

    //真正想测试的内容
    @Test //TestNG的使用方法
    public void playwrightTest(){
        //打开百度
        page.navigate("https://www.baidu.com");
        //输入内容
        page.locator("#kw").fill("微信");
        //输入回车键
        page.locator("#kw").press("Enter");
        String value = page.getAttribute("#kw","value");
        Assert.assertEquals(value,"微信");
        System.out.println(page.url());

        page.locator("#area").type("Hello,world!");

    }

    //case执行完后，再执行方法
    @AfterClass
    public void afterClass(){
        browser.close();
        browserContext.close();
        playwright.close();
    }


}
