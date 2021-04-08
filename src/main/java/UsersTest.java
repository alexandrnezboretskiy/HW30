import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class UsersTest {

    public static WebDriver driver;
    private JavascriptExecutor js;

    @Test



    public void login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://users.bugred.ru/user/login/index.html");

        /***User Autorization**/

        driver.findElement(By.name("login")).sendKeys("finya@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.className("btn-danger")).click();
        Thread.sleep(2000);


        /***Finding user**/
        driver.findElement(By.xpath("//tbody/tr[4]/td[1]/input[1]")).sendKeys("finya");
        driver.findElement(By.xpath("//button[contains(text(),'Найти')]")).click();
        Thread.sleep(2000);

        /**Add new user**/
        driver.findElement(By.xpath("//a[contains(text(),'Добавить пользователя')]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("Steve");
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("steves22@gmail.com");
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("2222");
        By fileInput = By.cssSelector("input[type=file]");
        String filePath = "C:\\Users\\Foundation Coffee\\IdeaProjects\\MyTest\\src\\main\\java\\jjj.jpg";
        driver.findElement(fileInput).sendKeys(filePath);
        driver.findElement(By.name("noibiz_birthday")).sendKeys("10", "03", "1995");
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        driver.findElement(By.name("noibiz_gender"));
        select.selectByVisibleText("Мужской");
        driver.findElement(By.name("noibiz_date_start")).sendKeys("10", "10", "2010");
        driver.findElement(By.name("noibiz_hobby")).sendKeys("Разные,веселые");
        driver.findElement(By.name("noibiz_name1")).sendKeys("Stevenson");
        driver.findElement(By.name("noibiz_name1")).sendKeys("Bourlak");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
        Thread.sleep(3000);
        driver.findElement(By.name("act_create")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Удалить")).click();
        Thread.sleep(3000);

        /**Change settings of personal area**/
        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Личный кабинет")).click();
        Thread.sleep(2000);
        By fileInput2 = By.cssSelector("input[type=file]");
        String filePath2 = "C:\\Users\\Foundation Coffee\\IdeaProjects\\MyTest\\src\\main\\java\\jjj.jpg";
        driver.findElement(fileInput2).sendKeys(filePath2);
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).clear();
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("Morfey");
        WebElement selectElem1 = driver.findElement(By.tagName("select"));
        Select select1 = new Select(selectElem1);
        driver.findElement(By.cssSelector("select[class=form-control]"));
        select1.selectByVisibleText("Мужской");
        Thread.sleep(2000);
        driver.findElement(By.name("birthday")).sendKeys("11", "11", "2011");
        driver.findElement(By.name("date_start")).sendKeys("11", "11", "1911");
        driver.findElement(By.name("hobby")).sendKeys("So many,so you wanted");
        driver.findElement(By.name("inn")).sendKeys("1111111111111111");
        Thread.sleep(3000);
        driver.findElement(By.name("act_profile_now")).click();



        driver.close();

    }

}
