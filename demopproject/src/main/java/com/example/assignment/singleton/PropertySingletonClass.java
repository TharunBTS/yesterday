package com.example.assignment.singleton;

import com.example.assignments.PropertyTax;

public class PropertySingletonClass {
	
	private static PropertyTax propertyTax = null;
	
	public static PropertyTax getPropertyTaxObj()
	{
		if(propertyTax == null)
		{
			propertyTax = new PropertyTax();
		}
		return propertyTax;
	}
	
	

}
