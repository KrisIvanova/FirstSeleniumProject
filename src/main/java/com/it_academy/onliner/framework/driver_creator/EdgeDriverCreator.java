package com.it_academy.onliner.framework.driver_creator;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public EdgeDriver create() {
        return new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
    }
}
