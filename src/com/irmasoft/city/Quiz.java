package com.irmasoft.city;

import java.util.Scanner;

import com.irmasoft.city.utils.TimeConverter;

public abstract class Quiz {
	private CapitaleCityQuestionGenerator generator;
	private int score;
	private long timeElapsed;
	private boolean done = false;
	Scanner clavier = new Scanner(System.in);
	
	public Quiz(CapitaleCityQuestionGenerator generator){
		this.generator = generator;	
	}

//	abstract public void displayResults(String message);
	abstract public void displayMessage(String message);
	
	abstract public String retreiveAnswer(String prompt);
	
	public void start(){
		try{
			long startTime = System.currentTimeMillis();
			
			for(Question question : generator.generate(generator.getNbreQuestions())){
				String userAnswer = retreiveAnswer(question.getText());
				if(userAnswer.equalsIgnoreCase(question.getResponse())){
					score++;
					displayMessage("Bonne reponse !");
				} else {
					displayMessage("Oops! Mauvaise réponse.\nLa bonne réponse était: "+question.getResponse());
				}
			}
			done = true;
			long endTime = System.currentTimeMillis();
			
			timeElapsed = endTime - startTime;
		
		} catch(IllegalArgumentException e){
			done = false;
			System.out.println(e.getMessage());
		}
		
	}
	
	public void displayResultats(){
		if(done){
			displayScore();
			displayTimeElapsed();
		}
	}
	
	private void displayTimeElapsed() {
		displayMessage(String.format("Il vous a fallu environ %d seconds pour " +
				"repondre au %d questions", TimeConverter.toSeconds(timeElapsed), generator.getNbreQuestions()));
		
	}

//	protected void displayMessage(String format) {
//		System.out.println(format);		
//	}

	private void displayScore() {
		displayMessage(String.format("Votre score final est de %d/%d.", score, generator.getNbreQuestions()));
		
	}

}
