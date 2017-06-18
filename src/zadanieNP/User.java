package zadanieNP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
	private String imie; 
	private String nazwisko; 
	private String dataUrodzenia;
	private String numerTelefonu;
	
	public User(String imie, String nazwisko, String dataUrodzenia, String numerTelefonu) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dataUrodzenia = dataUrodzenia;
		this.numerTelefonu = numerTelefonu;
	}

	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getDataUrodzenia() {
		return dataUrodzenia;
	}
	public void setDataUrodzenia(String dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	public String getNumerTelefonu() {
		return numerTelefonu;
	}
	
	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}
	
	public int getAge() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return LocalDate.parse(dataUrodzenia, formatter).until(LocalDate.now()).getYears();
		}
	
	@Override
	public String toString() {
		return "Użytkownik [imie = " + imie + ", nazwisko = " + nazwisko + ", wiek = " + dataUrodzenia + ", numer telefonu = "
				+ numerTelefonu + "]\n";
	}
}
