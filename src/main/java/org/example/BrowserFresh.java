package org.example;

import com.microsoft.playwright.*;

public class BrowserFresh {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setIgnoreHTTPSErrors(true)
                .setJavaScriptEnabled(true)
                .setViewportSize(2880,1800));
        Page page = browser.newPage();
        page.navigate("https://www.163.com");

        System.out.println("page title为 " + page.title());
        Thread.sleep(3000);

        //打开另一个浏览器
        page.navigate("https://www.baidu.com");
        System.out.println("page title: " + page.title());

        //前进操作
        page.goForward();
        Thread.sleep(3000);
        System.out.println("page title: " + page.title());

        //刷新操作
        page.reload();
        Thread.sleep(3000);
        System.out.println("page title: " + page.title());
        System.out.println("page url" + page.url());

        browser.close();
        playwright.close();

    }
}
