package org.fundacionjala.sfdc.framework.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * This class initialize the Remote Selenium Web Driver.
 */
final class SauceLabs implements Driver {

    private static final Logger LOGGER = LogManager.getLogger(BrowserStack.class);

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static final String HTTPS_PROXY_HOST = "https.proxyHost";

    private static final String HTTPS_PROXY_PORT = "https.proxyPort";

    private static final String BROWSER = "browserName";

    private static final String BROWSER_VERSION = "version";

    private static final String PLATFORM = "platform";

    private static final String RESOLUTION = "screenResolution";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        final String url = String.format("https://%s:%s@ondemand.saucelabs.com:443/wd/hub",
                ENVIRONMENT.getRemoteUserName(),
                ENVIRONMENT.getRemoteKey());
        DesiredCapabilities caps = new DesiredCapabilities();
        //Setting proxy.
        if (!ENVIRONMENT.getProxy().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getProxy());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        caps.setCapability(BROWSER, ENVIRONMENT.getRemoteBrowser());
        caps.setCapability(BROWSER_VERSION, ENVIRONMENT.getRemoteBrowserVersion());
        caps.setCapability(PLATFORM, String.format("%s %s", ENVIRONMENT.getRemotePlatform(),
                ENVIRONMENT.getRemotePlatformVersion()));
        caps.setCapability(RESOLUTION, ENVIRONMENT.getRemoteResolution());
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(url), caps);
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return remoteWebDriver;
    }
}
