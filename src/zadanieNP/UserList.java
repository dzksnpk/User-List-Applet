package zadanieNP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserList {

	public static void main(String[] args) {

		ArrayList<User> list = new ArrayList<>();

		// czytanie u¿ytkownika z pliku tekstowego
		try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {

			String line;
			String[] attributes;

			while ((line = br.readLine()) != null) {
				attributes = line.split(",");

				list.add(new User(attributes[0], attributes[1], attributes[2], attributes[3]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// najstarszy u¿ytkownik z numerem telefonu
		User najstarszyUser = null;

		for (User user : list) {

			if (najstarszyUser == null) {
				najstarszyUser = user;
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			Date date2;
			try {
				date = sdf.parse(user.getDataUrodzenia());
				date2 = sdf.parse(najstarszyUser.getDataUrodzenia());

				if (date.getTime() < date2.getTime() && !(user.getNumerTelefonu().equals(" "))) {
					najstarszyUser = user;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		// zamiana daty urodzenia na wiek
		for (User user : list) {

			Integer wiek = user.getAge();

			user.setDataUrodzenia(wiek.toString());
		}

		System.out.println("Liczba u¿ytkowników wynosi: " + list.size()); // iloœæ
																			// u¿ytkowników

		System.out.println("Najstarszy u¿ytkownik z numerem telefonu to: " + najstarszyUser); // najstarszy
																								// uzytkownik

		System.out.println(list); // lista u¿ytkowników

	}

}