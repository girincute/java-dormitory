import java.awt.List;

import org.hyunjun.school.School;
import org.hyunjun.school.SchoolMenu;
import org.hyunjun.school.SchoolException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class test {

	public static void main(String[] args) {


	School api = new School(School.Type.HIGH, School.Region.SEOUL, "B100000465");

	try
	{
		java.util.List<SchoolMenu> menu = api.getMonthlyMenu(2017, 4);


		// 2017년 4월 22일 저녁 급식 식단표
		System.out.println(menu.get(21).dinner);


	}catch(SchoolException e)
	{
		e.printStackTrace();
	}

}

}
