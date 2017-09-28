// coded by Christine Anne Catubig

import java.lang.IllegalArgumentException;

public class Date{

	private int year;
	private int month;
	private int day;

	Date(){
		this.year = 1000;
		this.month = 1;
		this.day = 1;
	}

	Date(int year, int month, int day){
		setDate(year, month, day);
	}

	void setDate(int year, int month, int day){
	 	setYear(year);
		setMonth(month);
		setDay(day);
	}

	int getYear(){
		return this.year;
	}

	int getMonth(){
		return this.month;
	}

	int getDay(){
		return this.day;
	}

	void setYear(int year){
		if(year < 1000 || year > 9999){
			throw new IllegalArgumentException("year out of bounds");
		}
		this.year = year;
	}

	void setMonth(int month){
		if(month < 1 || month > 12){
			throw new IllegalArgumentException("month out of bounds");
		}
		this.month = month;
	}

	void setDay(int day){
		if(day < 1 || day > getDaysOfMonth(this.month)){
			throw new IllegalArgumentException("day out of bounds");
		}
		this.day = day;
	}

	int getDaysOfMonth(int month){ // returns how many days there are in a month
		/*
		 *	31 days = (month) 1, 3, 5, 7, 8, 10, 12
		 *	30 days = (month) 4, 6, 9, 11
		 * 	28 days = (month) 2
		*/
		
		switch(month){    // pwede ra dli man switch case, you  can check the days of the month in the setDate or you can check it without using switch case
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return 28;
			default:
				break;
		}		
		return 0;
	}

	public String toString(){
		return String.format("%02d//%02d//%d", this.month, this.day, this.year);
	}
	


}