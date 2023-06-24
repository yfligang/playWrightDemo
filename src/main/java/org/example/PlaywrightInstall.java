package org.example;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;


public class PlaywrightInstall {
    public static void main(String[] args) throws InterruptedException {
//        try (Playwright playwright = Playwright.create()) {
//                BrowserType chromium = playwright.chromium();
//            // Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
//            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
//            Page page = browser.newPage();
//            page.navigate("https://www.baidu.com");
//            Thread.sleep(5000);
//            page.navigate("https://lpt.liepin.com");
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Thread.sleep(3000);
        PlaywrightInstall playwrightInstall = new PlaywrightInstall();
        playwrightInstall.PlaywrightBrower();
        //playwrightInstall.playwrightImage();
    }

    public void PlaywrightBrower() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setDevtools(true));
            Page page = browser.newPage();
            page.navigate("https://www.163.com");
            Thread.sleep(10000);
            page.pause();
            System.out.println(page.title());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void playwrightImage(){
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.baidu.com");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("PlaywrightInstall.png")));
        }
    }

//    public void test01(){
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                    .setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = browser.newPage();
//            Page page1 = page.waitForPopup(() -> {
//                page1.frameLocator("div >> internal:has-text=\"网易 有态度 网络监督专区\"s >> iframe").getByRole(AriaRole.LINK).click();
//            });
//            page1.getByText("网易 有态度 网络监督专区").click();
//            Page page2 = page.waitForPopup(() -> {
//                page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("外媒述评：西方对华“去风险”本身就是大风险")).click();
//            });
//            Page page3 = page.waitForPopup(() -> {
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("广东6男孩被骗到缅甸失联20余天 警方：手机均关机")).click();
//            });
//        }
//    }
}
