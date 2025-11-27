package com.example.assignment.singleton;


import com.example.assignments.TotalTax;

public class TotalSingletonClass {
	
private static TotalTax totalTax = null;
	
	public static TotalTax getTotalTaxObj()
	{
		if(totalTax == null)
		{
			totalTax = new TotalTax();
		}
		return totalTax;
	}

}
