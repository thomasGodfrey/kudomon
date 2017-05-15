package Main;

import Model.ElementalType;
import Model.Kudomon;
import Model.Trainer;

public class KudomonGO {
	
	public static void main(String args[]){
				
		//Create a Trainer and print it to console
		Trainer ash = new Trainer("notAsh",3,4);
		System.out.println(ash);
		
		//Create a Kudomon and print it to console
		Kudomon squirtle = new Kudomon(ElementalType.WATER,"notSquirtle",4,4);
		System.out.println(squirtle);
		
	}

}
