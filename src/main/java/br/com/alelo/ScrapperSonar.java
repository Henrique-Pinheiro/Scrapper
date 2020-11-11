package br.com.alelo;

import com.google.gson.Gson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ScrapperSonar {

    private WebDriver driver = null;
    private WebDriverWait wait;
    private static final String FILE_NAME = "sonar-geral.json";

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.nike.com.br/Produto/Meiao-Nike-Corinthians-I-201920-Torcedor-Pro/1-2-8-262753?gridPosition=B4/");

//        File myFile = new File(FILE_NAME);
//        if (myFile.delete()) {
//            System.out.println("Deleted the file: " + myFile.getName());
//        } else {
//            System.out.println("Failed to delete the file.");
//        }
    }

//    @Test
//    public void scrapper() throws IOException {
//        driver.findElement(By.id("login")).sendKeys("hrodrigues");
//        driver.findElement(By.id("password")).sendKeys("Alelo@2020" + 1234653);
//        driver.findElement(By.className("button")).click();
//
//        Map<String, Map<String, String>> projectData = new HashMap<>();
//        List<WebElement> projectList = driver.findElements(By.cssSelector(".project-card-name"));
//        List<String> projectNameList = new ArrayList<>();
//        projectList.forEach(project -> projectNameList.add(project.getText()));
//        projectList.forEach(project -> {
//            projectNameList.add(project.getText());
//        });
//        System.out.println(projectNameList);
//
//        projectNameList.forEach(projectName -> {
////            Map<String, String> subProjectData = new HashMap<>();
////            driver.navigate().refresh();
////
////            projectData.put(projectName, null);
////
////            System.out.println("Projeto Atual: " + projectName);
////
////            driver.findElement(By.xpath("//*[contains(text(),'" + projectName + "')]")).click();
////
////            driver.findElement(By.xpath("//*[contains(text(),'Measures')]")).click();
////
////            driver.findElement(By.xpath("//*[contains(text(),'Reliability')]")).click();
////            try {
////                subProjectData.put("Reliability", driver.findElement(By.xpath("//div[@id='measure-new_bugs-leak']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-new_reliability_rating-leak']/span/span")).getText());
////            } catch (NoSuchElementException e) {
////                subProjectData.put("Reliability", driver.findElement(By.xpath("//div[@id='measure-bugs-value']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-reliability_rating-value']/span/span")).getText());
////            }
////            driver.findElement(By.xpath("//*[contains(text(),'Reliability')]")).click();
////
////            driver.findElement(By.xpath("//*[contains(text(),'Security')]")).click();
////            try {
////                subProjectData.put("Security", driver.findElement(By.xpath("//div[@id='measure-new_vulnerabilities-leak']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-new_security_rating-leak']/span/span")).getText());
////            } catch (NoSuchElementException e) {
////                subProjectData.put("Security", driver.findElement(By.xpath("//div[@id='measure-vulnerabilities-value']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-security_rating-value']/span/span")).getText());
////            }
////            driver.findElement(By.xpath("//*[contains(text(),'Security')]")).click();
////
////            driver.findElement(By.xpath("//*[contains(text(),'Maintainability')]")).click();
////            try {
////                subProjectData.put("Maintainability", driver.findElement(By.xpath("//div[@id='measure-new_code_smells-leak']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-new_maintainability_rating-leak']/span")).getText());
////            } catch (NoSuchElementException e) {
////                subProjectData.put("Maintainability", driver.findElement(By.xpath("//div[@id='measure-code_smells-value']/span")).getText() + driver.findElement(By.xpath("//div[@id='measure-sqale_rating-value']/span/span")).getText());
////            }
////            driver.findElement(By.xpath("//*[contains(text(),'Maintainability')]")).click();
////
////            try {
////                driver.findElement(By.xpath("//*[contains(text(),'Coverage')]")).click();
////                try {
////                    subProjectData.put("Coverage", driver.findElement(By.xpath("//div[@id='measure-new_coverage-leak']/span")).getText());
////                } catch (NoSuchElementException e) {
////                    subProjectData.put("Coverage", driver.findElement(By.xpath("//div[@id='measure-coverage-value']/span")).getText());
////                }
////                driver.findElement(By.xpath("//*[contains(text(),'Coverage')]")).click();
////            } catch (NoSuchElementException ignore) {
////            }
////
////            driver.findElement(By.xpath("//*[contains(text(),'Duplication')]")).click();
////            try {
////                subProjectData.put("Duplication", driver.findElement(By.xpath("//div[@id='measure-new_duplicated_lines_density-leak']/span")).getText());
////            } catch (NoSuchElementException e) {
////                try{
////                    subProjectData.put("Duplication", driver.findElement(By.xpath("//div[@id='measure-duplicated_lines_density-value']/span")).getText());
////                }catch (NoSuchElementException ignore){}
////            }
////            driver.findElement(By.xpath("//*[contains(text(),'Duplication')]")).click();
////
////            projectData.put(projectName, subProjectData);
////
////            driver.findElement(By.xpath("//a[@href='/projects']")).click();
////            System.out.println("Mapa Atual:\n" + projectData);
//        });
//
//        String json = new Gson().toJson(projectData);
//
//        PrintWriter out = new PrintWriter(FILE_NAME);
//        out.println(json);
//        out.close();
//
//    }

    @Test
    public void nikeBoot() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        driver.findElement(By.id("anchor-acessar")).click();
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vi_viniciusferreira@outlook.com");
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Carrancas10");
//        driver.findElement(By.xpath("//input[@value='ENTRAR']")).click();

        driver.findElement(By.cssSelector(".cc-btn.cc-allow")).click();
        driver.findElement(By.id("btn-comprar")).click();
        driver.findElement(By.xpath("//*[@for='tamanho__idP']")).click();
        driver.findElement(By.id("btn-comprar")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btn.btn-dark.btn-border.mb-3"))));
        driver.findElement(By.cssSelector(".btn.btn-dark.btn-border.mb-3")).click();
        driver.get("https://www.nike.com.br/Checkout");

//        sleep(1000);
        System.out.println("batata");

        driver.findElement(By.id("guest-id")).sendKeys("50301288836");
        driver.findElement(By.id("data-nascimento-guest")).sendKeys("14/09/2000");
        driver.findElement(By.id("btn-continuar-pagamento")).click();
        System.out.println("batata");

    }

    @After
    public void after() {
        driver.quit();
    }

}
