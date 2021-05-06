package BrowserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        //***USTAWIANIE SCIEZKI WEB DRIVER DLA PRZEGLADARKI CHROME***
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Patryk\\Documents\\Selenium\\Chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //***WLACZANIE PRZEGLADARKI I STRONY***
        String url = "https://www.browserstack.com/";
        driver.manage().window().maximize();
        driver.get(url);


        //***SPRAWDZANIE TYTULU***
        String title = driver.getTitle();

        if (title.equals("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool")) {
            System.out.println("Title is correctly set to: '" + title + "'");
        } else {
            System.out.format("Title is set to '%s', instead of 'Quiz Show | Test And Quiz'\n", title);
        }


        //***WYSZUKIWANIE PRZYCISKU LOGOWANIA***
        WebElement signIn;
        signIn = driver.findElement(By.linkText("Sign in"));

        if (signIn != null) {
            System.out.println("Link 'Sign in' is displayed");
        } else {
            System.err.println("Link 'Sign in' is not displayed\n");
        }
        //***SPRDZANIE CZY PRZYCISK POSIADA DANA WARTOSC***
        String linkText = signIn.getText();

        if (linkText.equals("Sign in")) {
            System.out.println("Link text is correctly set to: '" + linkText + "'");
        } else {
            System.err.format("Link text is set to '%s', instead of 'Sign In'\n", linkText);
        }


        //***KLINIECIE W PRZYCISK***
        signIn.click();

        //***SPRAWDZANIE TYTUŁU STRONY PO LOGOWANIU***
        title = driver.getTitle();

        if (title.equals("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool")) {
            System.out.println("Title is correctly set to: '" + title + "'");
        } else {
            System.out.format("Title is set to '%s', instead of 'BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool'\n", title);
        }

        //***WYSZUKIWANIE POLA DO WPISANIA EMAILA***
        WebElement user = driver.findElement(By.id("user_email_login"));

        if (user != null) {
            System.out.println("Field user is displayed");
        } else {
            System.err.println("Field user is not displayed\n");
        }


        //***WYSZUKIWANIE POLA DO WPISANIA HASLA***
        WebElement password = driver.findElement(By.id("user_password"));

        if (password != null) {
            System.out.println("Field password is displayed");
        } else {
            System.err.println("Field password is not displayed");
        }


        //***WPISYWANIE EMAILA***
        user.sendKeys("d967220@student.wsiz.edu.pl");
        String tmpStr = user.getAttribute("value");

        if (tmpStr.equals("d967220@student.wsiz.edu.pl")) {
            System.out.println("User name is correctly set to: '" + tmpStr + "'");
        } else {
            System.err.format("User name is set to '%s', instead of 'User'\n", tmpStr);
        }


        //***WPISYWANIE HASLA***
        password.sendKeys("Test123!");
        tmpStr = password.getAttribute("value");

        if (tmpStr.equals("Test123!")) {
            System.out.println("Password is correctly set to: '" + tmpStr + "'");
        } else {
            System.err.format("Password is set to '%s', instead of 'haslo'\n", tmpStr);
        }

        //***SPRAWDZANIE PRZYCISKU LOGOWANIA***
        WebElement signMeIn;
        signMeIn = driver.findElement(By.id("user_submit"));

        if (signMeIn != null) {
            System.out.println("Link 'Sign me in' is displayed");
        } else {
            System.err.println("Link 'Sign me in' is not displayed\n");
        }


        //***SPRAWDZANIE CZY PRZYCISK POSIADA DANA WARTOSC***
        String signMeInText = signMeIn.getAttribute("value");

        if (signMeInText.equals("Sign me in")) {
            System.out.println("Link text is correctly set to: '" + linkText + "'");
        } else {
            System.err.format("Link text is set to '%s', instead of 'Sign me in'\n", linkText);
        }


        //***KLIKNIECIE W PRZYCISK***
        signMeIn.click();


        //***SPRAWDZANIE CZY UZYTKOWNIK ZALOGOWAŁ SIĘ POPRAWNIE DZIĘKI SPRAWDZENIU TYTULU STRONY***
        title = driver.getTitle();

        if (title.equals("Dashboard")) {
            System.out.println("Title is correctly set to: '" + title + "'");
        } else {
            System.out.format("Title is set to '%s', instead of 'Dashboard'\n", title);
        }


    }
}
