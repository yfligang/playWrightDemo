package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NewPlaywrightDemo {

    public static void main(String[] args){
        //创建Playwright
        try(Playwright playwright = Playwright.create()) {
            //新建浏览器
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            //创建新页面
            Page page = browser.newPage();
            //导航到要测试验证的页面
            page.navigate("http://playwright.dev");

            Thread.sleep(30000);

            //期望标题包含一个 子字符串
            assertThat(page).hasTitle(Pattern.compile("Playwright"));

            //创建一个锚点
            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName("Get Started"));

            //期望等待一个属性
            assertThat(getStarted).hasAttribute("href","/docs/intro");

            //点击要开始的链接
            getStarted.click();

            //
            assertThat(page).hasURL(Pattern.compile(".*intro"));


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
