package com.testingsostenible.curso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

	private Double amount;
	private String today;
	
	

	public Transaction() {
	}



	public Transaction(final String today, final Double amount) {
		this.today = today;
		this.amount = amount;
	}



	public Double getAmount() {
		return amount;
	}



	public String getToday() {
		return today;
	}


	public Long getTodayLong() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date = LocalDate.parse(today, dateFormatter).atStartOfDay();
		ZonedDateTime zoneDateTimeInMadrid = date.atZone(ZoneId.of("Europe/Madrid"));
		return zoneDateTimeInMadrid.toEpochSecond();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((today == null) ? 0 : today.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (today == null) {
			if (other.today != null)
				return false;
		} else if (!today.equals(other.today))
			return false;
		return true;
	}




}
