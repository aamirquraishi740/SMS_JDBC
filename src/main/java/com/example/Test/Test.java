package com.example.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.example.StudentDao.StudentDao;
import com.example.entity.Student;

public class Test {

	public static void main(String args[]) throws SQLException, NumberFormatException, IOException {

		StudentDao sd = new StudentDao();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c;

		while (true) {

			System.out.println("Enter 1 for insert data");
			System.out.println("Enter 2 for showAll students");
			System.out.println("Enter 3 for show student");
			System.out.println("Enter 4 for delete student row");
			System.out.println("Enter 5 for update student row");
			System.out.println("Enter 6 for exit ");

			c = Integer.parseInt(br.readLine());

			if (c == 1) {

				Student s = new Student();

				System.out.println("Enter name");
				String name = br.readLine();
				System.out.println("Enter phone");

				String phone = br.readLine();
				System.out.println("Enter city");

				String city = br.readLine();

				s.setName(name);
				s.setPhone(phone);
				s.setCity(city);

				sd.insertData(s);

			} else if (c == 2) {

				sd.showAll();

			} else if (c == 3) {
				System.out.println("Enter student id you want to show");
				
				int id =Integer.parseInt(br.readLine());

				sd.showAllById(id);

			} else if(c==4) {
				
				System.out.println("Enter student id you want to delete");
				
				int id =Integer.parseInt(br.readLine());
				
				sd.delete(id);
				
			} else if(c==5) {
				
				System.out.println("Enter student id you want to update");
				
				int id =Integer.parseInt(br.readLine());
				
				System.out.println("Enter new id ");
				int newId =Integer.parseInt(br.readLine());
				
				System.out.println("Enter new name ");
				String newName =br.readLine();
				
				System.out.println("Enter new phone ");
				String newPhone =br.readLine();
				
				System.out.println("Enter new city ");
				String newCity =br.readLine();


				
				sd.update(id,newId,newName,newPhone,newCity);
				
			}
			else if (c == 6) {
				System.out.println("thank u for using my app");
				break;
			} else {

			}

		}

	}

}
