package com.it_academy.onliner.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "chrome");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "MicrosoftEdge");
        return options;
    }
}
