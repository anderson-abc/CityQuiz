package com.irmasoft.city;

import javax.swing.JOptionPane;

public class GUIQuiz extends Quiz {
	public GUIQuiz(CapitaleCityQuestionGenerator generator) {
		super(generator);
	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public String retreiveAnswer(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}

}
