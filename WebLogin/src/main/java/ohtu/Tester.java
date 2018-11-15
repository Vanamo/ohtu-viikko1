package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

//        driver.get("http://localhost:4567");
//
//        //sleep(2);
//        //tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
//
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        //tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
//
//        //sleep(2);
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//
//        //sleep(2);
//        element.submit();
//
//        //sleep(3);
//        driver.quit();
        //Epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
//        driver.get("http://localhost:4567");
//
//        WebElement element2 = driver.findElement(By.linkText("login"));
//        element2.click();
//
//        element2 = driver.findElement(By.name("username"));
//        element2.sendKeys("pekka");
//        element2 = driver.findElement(By.name("password"));
//        element2.sendKeys("akke");
//        element2 = driver.findElement(By.name("login"));
//
//        element2.submit();
//
//        //tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
//        
//        driver.quit();
//
        //epäonnistunut kirjautuminen: ei-olemassaoleva käyttäjätunnus
//        driver.get("http://localhost:4567");
//
//        WebElement element3 = driver.findElement(By.linkText("login"));
//        element3.click();
//
//        element3 = driver.findElement(By.name("username"));
//        element3.sendKeys("vanamo");
//        element3 = driver.findElement(By.name("password"));
//        element3.sendKeys("akke");
//        element3 = driver.findElement(By.name("login"));
//
//        element3.submit();
//
//        //tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
//        
//        driver.quit();
        //uuden käyttäjätunnuksen luominen
//        driver.get("http://localhost:4567");
//
//        WebElement element4 = driver.findElement(By.linkText("register new user"));
//        element4.click();
//
//        element4 = driver.findElement(By.name("username"));
//
//        Random r = new Random();
//
//        element4 = driver.findElement(By.name("username"));
//        element4.sendKeys("vanamo" + r.nextInt(100000));
//
//        element4 = driver.findElement(By.name("password"));
//        element4.sendKeys("salainen");
//        element4 = driver.findElement(By.name("passwordConfirmation"));
//        element4.sendKeys("salainen");
//        element4 = driver.findElement(By.name("signup"));
//
//        element4.submit();
//
//        //tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
//
//        driver.quit();
        //uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        driver.get("http://localhost:4567");

        WebElement element5 = driver.findElement(By.linkText("register new user"));
        element5.click();

        element5 = driver.findElement(By.name("username"));

        Random r = new Random();

        element5 = driver.findElement(By.name("username"));
        element5.sendKeys("vanamo" + r.nextInt(100000));

        element5 = driver.findElement(By.name("password"));
        element5.sendKeys("salainen");
        element5 = driver.findElement(By.name("passwordConfirmation"));
        element5.sendKeys("salainen");
        element5 = driver.findElement(By.name("signup"));
        element5.submit();

        element5 = driver.findElement(By.linkText("continue to application mainpage"));
        element5.click();

        element5 = driver.findElement(By.linkText("logout"));
        element5.click();
        
        //tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
