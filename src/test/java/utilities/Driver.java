package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(){


        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--no-sandbox");
                    //options.addArguments("--disable-web-security");
                    //options.addArguments("--allow-running-insecure-content");
                    //options.addArguments("--allow-insecure-localhost");
                   // options.addArguments("--ignore-ssl-errors=yes");
                    //options.addArguments("--ignore-certificate-errors");
                   // options.addArguments("start-maximized");
                    //options.setExperimentalOption("useAutomationExtension", false);
                    //options.setExperimentalOption("dom.webdriver.enabled", false);
                   // options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    // options.addArguments("--user-data-dir=C:\\Users\\Arda\\AppData\\Local\\Google\\Chrome\\User Data");
                    // options.addArguments("--user-data-dir=C:\\Users\\ArdaEbrar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 6");
                    // options.addArguments("--profile-directory=Profile 6");
                    // C:\Users\ArdaEbrar\AppData\Local\Mozilla\Firefox\Profiles\n8k62f27.default-release

                    DesiredCapabilities cp= new DesiredCapabilities();
                    cp.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(cp);
                    driver = new ChromeDriver(options);
                    break;


            case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    // firefoxOptions.addArguments("--remote-allow-origins=*");
                    // firefoxOptions.addArguments("--no-sandbox");


                    firefoxOptions.addArguments("--disable-web-security");
                    // firefoxOptions.addArguments("--allow-running-insecure-content");
                    // firefoxOptions.addArguments("--allow-insecure-localhost");
                    firefoxOptions.addPreference("useAutomationExtension", false);
                    firefoxOptions.addPreference("dom.webdriver.enabled", false);


                    ProfilesIni profile = new ProfilesIni();

                    FirefoxProfile myprofile = profile.getProfile("default");
                    myprofile.setPreference("general.useragent.override", "Custom-Agent");

                    // firefoxOptions.addArguments("--user-data-dir=C:\\Users\\ArdaEbrar\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\n8k62f27.default-release");
                    FirefoxProfile firefoxProfile = new FirefoxProfile(new File("C:\\Users\\ArdaEbrar\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\9vqggaly.selenium"));
                    firefoxProfile.setPreference("general.useragent.override", "Custom-Agent");
                    firefoxOptions.setProfile(myprofile);
                    driver=new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;

    }


    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null;
        }

    }



}
