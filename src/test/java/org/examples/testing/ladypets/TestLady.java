package org.examples.testing.ladypets;

//import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
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
	public String readPropertyFromFile(String keyName) throws IOException{
		String workingDirectory = System.getProperty("user.dir");
		System.out.println(workingDirectory);
		Properties prop = new Properties();
		String propertyFilePath = workingDirectory + "/src/test/java/org/examples/testing/resources/";
//		FileInputStream fis=null;
		FileReader fReader=null;
		try {
//			fis = new FileInputStream(propertyFilePath + "Param.properties");
			fReader = new FileReader(propertyFilePath + "Param.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Property file not found !");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
//			prop.load(fis);
			prop.load(fReader);
		} catch (IOException e) {
			System.out.println("Property file loading failure !");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e){
			System.out.println("Null Pointer Exception - cgg !");
			System.out.println("cgg - Message is: " + e.getMessage());
			e.printStackTrace();
		} finally {  									//Always run irrespective of success or failure
			//System.out.println("Final block !!!!!!!!");
//			fis.close();
			fReader.close();
		}
		return prop.getProperty(keyName);
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
	public void testPlayPets() throws IOException{
		String keyValue=null;
		keyValue = readPropertyFromFile("LadyCount");
		int ladyCount = Integer.parseInt(keyValue);
		System.out.println(" Total lady count = " + ladyCount); //read it from "Para.properties" file
		DataFactory df =new DataFactory(); //Fake name generator
		for(int i=0; i < ladyCount; i++){
			new Lady(df.getName(), new Random().nextInt(6)+1).playPets();  //How many pets this lady owns
		}
	}
}
