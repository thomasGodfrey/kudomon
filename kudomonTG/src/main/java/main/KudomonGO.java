package main;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.KudomonCantBeCaughtException;
import model.ElementalType;
import model.GameField;
import model.Kudomon;
import model.Trainer;

public class KudomonGO {
	
	
	public static void main(String args[]) throws KudomonCantBeCaughtException{
		
		GameField gameField;
		ArrayList<Trainer> trainers;
		ArrayList<Kudomon> kudomon;
		Trainer currentPlayer;
		
		gameField = new GameField(100,100);
		
		//Create a Trainer, adding the Trainer to the GameField
		Trainer ash = new Trainer("ash",25,33,gameField);
		
		//Create some Kudomon and add them to the GameField
		Kudomon squirtle = new Kudomon(ElementalType.WATER,"elSquirt",0,100,gameField);
		Kudomon caterpie = new Kudomon(ElementalType.GRASS,"ercatpie",23,34,gameField);
		Kudomon croconaw = new Kudomon(ElementalType.WATER,"narcoCow",22,35,gameField);
		Kudomon dedenne = new Kudomon(ElementalType.ELECTRIC,"dedenne",20,37,gameField);
		Kudomon aggron = new Kudomon(ElementalType.ROCK,"aggron",25,33,gameField);
		Kudomon alakazam = new Kudomon(ElementalType.PSYCHIC,"alakazam",25,34,gameField);
		Kudomon arkanine = new Kudomon(ElementalType.FIRE,"arkanine",55,45,gameField);
		
		ash.catchKudomon(aggron);
		
		System.out.println(ash.getCaughtKudomon());
		
		
		
	}
	
	

}
