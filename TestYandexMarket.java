package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestYandexMarket {

     public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/shushanghazaryan/Downloads/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
        WebElement electronics = driver.findElement(By.xpath("//span[contains(text(),'Электроника')]"));
        electronics.click();
        WebElement smartphones= driver.findElement(By.xpath("//a[contains(text(),'Смартфоны и аксессуары')]"));
        smartphones.click();
        driver.findElement(By.xpath("//a[contains(text(),'Мобильные телефоны')]")).click();
        if
        (driver.findElement(By.xpath("//h1[@class='_3wPGpzKmmn']")).getText().equals("Мобильные телефоны")){
            System.out.println("Success Мобильные телефоны page ");
        }
        else
        System.out.println("Fail");
        driver.findElement(By.xpath("//input[@id='glpricefrom']")).sendKeys("20000");
       if (driver.findElement(By.xpath("//input[@value='20000']")).isDisplayed()) {
           System.out.println("Success! Цена ");
       }
           else
           System.out.println("Fail!");


        driver.findElement(By.xpath("//input[@name='Диагональ экрана (точно) от']")).sendKeys("3");
        if (driver.findElement(By.xpath("//input[@value='3']")).isDisplayed()) {

            System.out.println("Success Диагональ экрана!");
        }
        else
            System.out.println("Fail!");
        driver.findElement(By.xpath("//div[@class='LhMupC0dLR']/span[text()='Apple']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@name='Производитель Apple']")).isSelected());
        driver.findElement(By.xpath("//div[@class='LhMupC0dLR']/span[text()='HONOR']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@name='Производитель HONOR']")).isSelected());
        driver.findElement(By.xpath("//div[@class='LhMupC0dLR']/span[text()='Xiaomi']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@name='Производитель Xiaomi']")).isSelected());

     driver.findElement(By.xpath("//button[contains(text(),'по цене')]")).click();

     try {
           Thread.sleep(5_000L);
       }catch (InterruptedException ex) {
         ex.printStackTrace();
     }

      // System.out.println(driver.findElement(By.xpath("//div[@class='_2Qo3ODl0by cia-vs']/article[1]")).getAttribute("price"));

       String firstElementText = driver.findElement(By.xpath("//article[1]/div[4]/div[1]/h3/a/span")).getText();
       System.out.println(firstElementText);

        driver.findElement(By.xpath("//button[contains(text(),'по популярности')]")).click();

        try {
            Thread.sleep(5_000);
        }catch (InterruptedException ignored){

        }
        driver.findElement(By.xpath("//input[@id='header-search']")).sendKeys(firstElementText);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        new WebDriverWait(driver, 60);
        if(driver.findElement(By.xpath("//article[1]/div[4]/div[1]/h3/a")).getAttribute("title").equals(firstElementText))
        {
        System.out.println(driver.findElement(By.xpath("//article[1]/div[5]/div[1]/div[1]/div/a/div/span/span[1]")).getText());
        }
        else {

            System.out.println("Fail!!!");
        }

        driver.quit();
    }

}
