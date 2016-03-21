package org.examples.testing.ladypets;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPet {
	private Collection<Pet> pets = null;          //Collection is an interface - you can use index

	@BeforeTest
	public void BeforeTest(){
		//ArrayList initialisation - animals
		pets = new ArrayList<Pet>();
		
		for(int i=0; i<10; i++){
			int rnd = new Random().nextInt(99);
			if (rnd % 3 == 0)
				pets.add(new Dog());
			else if(rnd % 3 == 1)
				pets.add(new Bird());
			else 
				pets.add(new Cat());

		}
	}
	
	@BeforeMethod
	public void printMethodNameBefore(Method method){
		System.out.println("Test Name: " + method.getName() + " -- Starts @ " + new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
	@AfterMethod
	public void printMethodNameAfter(Method method){
		System.out.println("Test Name: " + method.getName() + " -- Ends @ " + new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		System.out.println();
	}
	

	@Test
	public void makeSoundTest() {
		for (Pet each : pets) {
			each.makeSound();
			//Wait
/*			try {
			    Thread.sleep(1);                 //1: it means wait 1 millisecond.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}*/
		}
	}
/*	
	@Test
	public void testHomePageTitle() {
	WebDriver driver = new FirefoxDriver();
	driver.get("https://violin.ctsu.ox.ac.uk/celloTesting/");
	driver.manage().window().maximize();
	String homepageTitle = driver.getTitle();
	System.out.println(homepageTitle);
	Assert.assertEquals(homepageTitle, "Cello Testing - Login");
	driver.close();
	driver.quit();
	}
*/	
	@AfterTest
	public void AfterTest(){
		pets.removeAll(pets);
	}
}
