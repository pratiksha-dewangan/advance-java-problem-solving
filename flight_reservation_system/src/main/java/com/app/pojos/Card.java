package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Card {
	
	@Column(name = "card_num",length = 20)
	private String cardNum;
	
	@Column(name = "card_name",length = 20)
	private String cardName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expDate;
	
	@Column(length = 5)
	private String cvv;
	
	public Card() {
		System.out.println("in const. of :" +getClass().getName());
	}

	public Card(String cardNum, String cardName, LocalDate expDate, String cvv) {
		super();
		this.cardNum = cardNum;
		this.cardName = cardName;
		this.expDate = expDate;
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", cardName=" + cardName + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}

}
