package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utils klasa sadrzi helper funkcije koje se koriste na vise mesta u page klasama. 
 * Na ovaj nacin su delovi koje se ponavljaju izvuceni na jedno mesto.
 * Sve metode su staticke, tako da se mogu pozivati bez instanciranja same klase. 
 * 
 *
 */
public class Utils {
	
	/**
	 * Metoda ceka da element sa prosledjenim selektorom postan klikabilan (displayed and enabled)
	 * @param driver - web driver
	 * @param selector - selektor elementa koji cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element
	 */
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	
	/**
	 * Metoda ceka da se element sa prosledjenim selektorom pojavi u DOM stablu
	 * @param driver - web driver
	 * @param selector - selektor elementa cije prisustvo cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element
	 */
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}

}
