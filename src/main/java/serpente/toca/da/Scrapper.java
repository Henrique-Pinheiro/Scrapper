package serpente.toca.da;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Scrapper {

    private WebDriver driver = null;
    private WebDriverWait wait;


    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://tableau.ons.org.br/t/ONS_Publico/views/DadosHidrolgicos-Nveis/HistricoDadosHidrolgicos-NveldeMontante?:embed=y&:showAppBanner=false&:showShareOptions=true&:display_count=no&:showVizHome=no");
    }

    @Test
    public void scrapper() throws InterruptedException, AWTException {
        driver.findElement(By.cssSelector(".tabComboBox.tab-ctrl-formatted-widget.tab-ctrl-formatted-darker-border-hover.tab-widget.tabComboStdTheme.tabComboBoxNoIcon")).click();
        driver.findElement(By.xpath("//div[@data-test-id='tabMenuItem'][2]")).click();
        ((JavascriptExecutor) driver).executeScript("document.getElementById('initializing_thin_client').style.display = 'none';");
        driver.findElement(By.cssSelector(".tabComboBox.tab-ctrl-formatted-widget.tab-ctrl-formatted-darker-border-hover.tabComboStdTheme.tabComboBoxNoIcon.tiledContent")).click();
        List<String> list = new ArrayList<String>(Arrays.asList(driver.findElement(By.cssSelector(".CFInnerContainer.tab-ctrl-formatted-text.tiledContent")).getAttribute("innerText").split("\n")));
        driver.findElement(By.xpath("//*[contains(text(),'" + list.get(0) + "')]")).click();
//        driver.findElement(By.xpath("//input[@class='QueryBox'][1]")).sendKeys("01/01/2002");
        List<WebElement> timeRangElements = driver.findElements(By.xpath("//input[@class='QueryBox'][1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '01/01/2002';", timeRangElements.get(0));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '01/08/2020';", timeRangElements.get(1));
        driver.findElement(By.id("refresh-ToolbarButton")).click();

        sleep(10000);

        Robot robot = new Robot();
        robot.mouseMove(400, 400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        driver.findElement(By.cssSelector(".tab-button.tab-widget.tab-commandTooltip_ViewData.enabled")).click();

        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        String parentWindow = windows.get(0);
        String childWindow = windows.get(1);


        System.out.println("leite");
//        sleep(40000);
    }

    @After
    public void after() {
        driver.quit();
    }

}
