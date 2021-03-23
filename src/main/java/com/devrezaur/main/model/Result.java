package com.devrezaur.main.model;

import org.springframework.stereotype.Component;

@Component
public class Result {

	private int totalCorrect = 0;
	private int totalWrong = 0;

	public Result() {
		super();
	}

	public Result(int totalCorrect, int totalWrong) {
		super();
		this.totalCorrect = totalCorrect;
		this.totalWrong = totalWrong;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public int getTotalWrong() {
		return totalWrong;
	}

	public void setTotalWrong(int totalWrong) {
		this.totalWrong = totalWrong;
	}

}
