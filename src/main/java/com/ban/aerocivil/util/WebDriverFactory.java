package com.ban.aerocivil.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;

public class WebDriverFactory {

    public static WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.aerocivil.gov.co/");
        return driver;
    }
}
