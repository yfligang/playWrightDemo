package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class MoreBrowserDemo {
    //创建浏览器上下文
    public BrowserContext createContext(Browser browser){
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setIgnoreHTTPSErrors(true)
                .setJavaScriptEnabled(true)
                //此处可以理解为设定指定窗口启动
                .setViewportSize(1980,1080));
        return browserContext;
    }

    public Browser createBrowser(String name, Playwright playwright) {
        try{
            switch (name){
                case "firefox":
                    return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setTimeout(120*1000));
                case "chromium":
                    return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setTimeout(120*1000));
                case "webkit":
                    return playwright.webkit().launch();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testBrowser() throws InterruptedException {
        //启动火狐浏览器
        startBrowser("firefox");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //启动谷歌浏览器
        startBrowser("chromium");
    }

    //根据浏览器类型，启动浏览器
    public void startBrowser(String browserName){
        //创建Playwright
        Playwright playwright = Playwright.create();
        //创建browser
        Browser browser = createBrowser(browserName,playwright);
        //创建浏览器上下文
        BrowserContext browserContext = createContext(browser);
        Page page = browserContext.newPage();
        page.navigate("https://www.baidu.com");
        System.out.println("页面的标题为: " + page.title());
        System.out.println(browserName + " 浏览器启动了");

        browser.close();
        browserContext.close();
        playwright.close();

    }
}
