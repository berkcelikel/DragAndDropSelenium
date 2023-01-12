package draganddrop;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class draganddrop extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        driver.manage().window().maximize();

        List<WebElement> element = driver.findElements(By.cssSelector(".dragDropSmallBox[id^='a']"));
        Actions aksiyonlar = new Actions(driver);

        for (WebElement sehir : element) {
            String id = sehir.getAttribute("id").replaceAll("[^0-9]","");
            WebElement ulke = driver.findElement(By.cssSelector(".dragDropSmallBox[id='q"+id+"']"));
            aksiyonlar.clickAndHold(sehir).perform();
            Bekle(1);
            aksiyonlar.moveToElement(ulke).release().perform();
        }
        BekleKapat();

    }
}
