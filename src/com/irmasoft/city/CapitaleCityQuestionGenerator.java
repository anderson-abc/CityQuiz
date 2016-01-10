package com.irmasoft.city;

import java.util.ArrayList;
import java.util.Random;

public class CapitaleCityQuestionGenerator {
	
	private int nbreQuestions;
	
	public CapitaleCityQuestionGenerator(int nbreQuestions) {
		this.nbreQuestions = nbreQuestions;
	}
	
	public int getNbreQuestions(){
		return nbreQuestions;
	}

	public ArrayList<Question> generate(int nbreQuestions){
		String[][] data = getData();
		if(nbreQuestions > data.length){
			throw new IllegalArgumentException("On ne peut generer que "+data.length+" questions maximum.");
		}
		ArrayList<Question> questions = new ArrayList<>();
		
		int index;
		ArrayList<Integer> indexesAlreadyToken = new ArrayList<>();
		
		for(int i=0; i<nbreQuestions; i++){
			// choisir un pays d'une maniére aleatoire
			do{
				Random random = new Random();
				index = random.nextInt(data.length);
			} while(indexesAlreadyToken.contains(index));
			
			indexesAlreadyToken.add(index);
			
			String pays = data[index][0];
			String capitale = data[index][1];
			
			String questionText = String.format("Quelle est la capitale de ce pays: %s?", pays);
			questions.add(new Question(questionText, capitale));
		}
		
		
		return questions;		
	}
	
	private static String[][] getData(){
		String [][]data = {
				{"Tunisia", "Tunis"},
				{"France", "Paris"},
				{"Germany", "Berlin"},
				{"Italy", "Rome"},
				{"Qatar", "Doha"},
		};
		return data;
	}

}
