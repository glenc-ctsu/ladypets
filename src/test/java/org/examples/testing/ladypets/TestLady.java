package org.examples.testing.ladypets;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLady {
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
	public void testPlayPets(){
		Random gen = new Random();
		DataFactory df =new DataFactory();
		int ladyNumber = gen.nextInt(5) +3;  //How many ladies own pets
		for(int i=0; i < ladyNumber; i++){
			new Lady(df.getName(), new Random().nextInt(6)+1).playPets();  //How many pets this lady owns
		}
	}
}
