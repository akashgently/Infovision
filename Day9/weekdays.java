package com.Day9;

import java.util.ArrayList;
import java.util.List;

public class weekdays {
	public static void main(String[] args) {
	
	String week_days[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	
	List<String> arrayList_week_days = new ArrayList<String>();
	arrayList_week_days.add("Sunday");
	arrayList_week_days.add("Monday");
	arrayList_week_days.add("Tuesday");
	arrayList_week_days.add("Wednesday");
	arrayList_week_days.add("Thursday");
	arrayList_week_days.add("Friday");
	arrayList_week_days.add("Saturday");
	
	for(String i : week_days) {
		System.out.println(i);	
	}
	System.out.println(arrayList_week_days);
	
	List<String> arrayList_week_days1 = new ArrayList<String>();
	arrayList_week_days1.addAll(arrayList_week_days);
	System.out.println(arrayList_week_days1);
	System.out.println(arrayList_week_days1.containsAll(arrayList_week_days));	
	arrayList_week_days1.removeAll(arrayList_week_days1);
	System.out.println(arrayList_week_days1);
	}

}
