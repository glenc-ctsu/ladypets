package org.examples.testing.ladypets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
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
	public void testPlayPets() throws IOException{
		String workingDirectory = System.getProperty("user.dir");
		//System.out.println(workingDirectory);
		String propertyFilePath = workingDirectory + "//src//test//java//org//examples//property//";
		FileInputStream fip = new FileInputStream( propertyFilePath + "Param.properties");
		Properties prop = new Properties();
		prop.load(fip);
		String countString = prop.getProperty("ladyCount");
		int ladyCount = Integer.parseInt(countString);
		System.out.println(" Total lady count = " + ladyCount); //read it from "Para.properties" file
		DataFactory df =new DataFactory(); //Fake name generator
		for(int i=0; i < ladyCount; i++){
			new Lady(df.getName(), new Random().nextInt(6)+1).playPets();  //How many pets this lady owns
		}
	}
}
