package main;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.KudomonCantBeCaughtException;
import model.ElectricType;
import model.ElementalType;
import model.FireType;
import model.GameField;
import model.GrassType;
import model.Kudomon;
import model.PsychicType;
import model.RockType;
import model.Trainer;
import model.WaterType;

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
		Kudomon squirtle = new WaterType(ElementalType.WATER,"elSquirt",0,100,gameField);
		Kudomon caterpie = new GrassType(ElementalType.GRASS,"ercatpie",23,34,gameField);
		Kudomon croconaw = new WaterType(ElementalType.WATER,"narcoCow",22,35,gameField);
		Kudomon dedenne = new ElectricType(ElementalType.ELECTRIC,"dedenne",20,37,gameField);
		Kudomon aggron = new RockType(ElementalType.ROCK,"aggron",25,33,gameField);
		Kudomon alakazam = new PsychicType(ElementalType.PSYCHIC,"alakazam",25,34,gameField);
		Kudomon arkanine = new FireType(ElementalType.FIRE,"arkanine",55,45,gameField);
		
		ash.attemptCapture(aggron);
		ash.finishCapture();
		
		ash.attemptCapture(alakazam);
		ash.finishCapture();
		
		System.out.println(ash.getCaughtKudomon());
		System.out.println(aggron.getEffectiveness(ElementalType.GRASS));
		
		
		
	}
	
	

}
