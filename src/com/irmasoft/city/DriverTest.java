package com.irmasoft.city;

public class DriverTest {
	
	public static void main(String[] args){
		Quiz quiz = new GUIQuiz(new CapitaleCityQuestionGenerator(2));
		quiz.start();
		quiz.displayResultats();
	}
}
