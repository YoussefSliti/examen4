package examanPoo;

import java.time.LocalDate;

public class Buillet implements Publiable {
	protected LocalDate date;
	protected String auteur;
	
	public Buillet(LocalDate datePub,String auteur) {
		this.date=datePub;
		this.auteur=auteur;
	}
	
	

	@Override
	public LocalDate getDatePublication() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public String getAuteur() {
		// TODO Auto-generated method stub
		return auteur;
	}



	@Override
	public String toString() {
		return "Buillet [date=" + date + ", auteur=" + auteur + "]";
	}

}
