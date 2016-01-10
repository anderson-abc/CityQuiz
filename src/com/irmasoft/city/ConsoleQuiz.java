package com.irmasoft.city;

import java.util.Scanner;

public class ConsoleQuiz extends Quiz {
	
	Scanner clavier = new Scanner(System.in);
	
	public ConsoleQuiz(CapitaleCityQuestionGenerator generator) {
		super(generator);
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public String retreiveAnswer(String prompt) {
		displayMessage(prompt);
		return clavier.nextLine();
	}

}
