package com.it_academy.onliner.framework;

import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserOptionsFactory {

    public static AbstractDriverOptions options;

    public static AbstractDriverOptions getBrowserOptions(String browser){
        if (browser.equals("edge"))
            options = BrowserOptions.getEdgeOptions();
        else options = BrowserOptions.getChromeOptions();
        return options;
    }
}
