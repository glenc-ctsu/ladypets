package org.examples.testing.ladypets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Lady {
	private String name;
	private int count;
	private Collection<Pet> pets;
	Lady(String name, int count){
		this.name = name;
		this.count = count;
		pets = new ArrayList<Pet>(); 
		for(int i=0; i<count; i++){
			int rnd = new Random().nextInt(100);
			if ( rnd % 3 == 0)
				pets.add(new Dog());
			else if(rnd % 3== 1)
				pets.add(new Bird());
			else 
				pets.add(new Cat());
		}
	}
	public void playPets(){
		System.out.println(" ->Lady: " + name + " owns " + count + " pet(s)-");
		for (Pet each : pets){
			each.makeSound();			
		}
	}
}
