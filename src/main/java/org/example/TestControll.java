package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestControll {

    static Playwright playwright;
    static BrowserContext browserContext;
    static Browser browser;
    static Page page;

    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType
                .LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
    }

    @Test //测试输入操作
    public void testInput(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.baidu.com");
        page.locator("#kw").fill("蓬勃发展");
        String value = page.locator("kw").getAttribute("value");
        //输出value值
        System.out.println("value值为: " + value);

    }
}
