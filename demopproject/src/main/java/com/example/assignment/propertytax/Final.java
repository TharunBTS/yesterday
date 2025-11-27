package com.example.assignment.propertytax;


import java.util.Scanner;

import com.example.assignment.singleton.PropertySingletonClass;
import com.example.assignment.singleton.TotalSingletonClass;
import com.example.assignment.singleton.VehicleSingletonClass;
import com.example.assignments.PropertyTax;
import com.example.assignments.TotalTax;
import com.example.assignments.VehicleTax;
//import com.example.assignment.PropertyTax;

public class Final {

	public static void main(String[] args) throws Exception {
		
		Scanner ip = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. PROPERTY TAX");
			System.out.println("2. VEHICLE TAX");
			System.out.println("3. TOTAL");
			System.out.println("4. EXIT");
			
			int n = ip.nextInt();
			
			switch(n)
			{
				case 1 : 
					PropertyTax propertyTax = PropertySingletonClass.getPropertyTaxObj();
					propertyTax.propertyMethod();
					break;
				case 2 : 
					VehicleTax vehicleTax = VehicleSingletonClass.getVehicleTaxObj();
					vehicleTax.vehicleMethod();
					break;
				case 3 : 
					TotalTax totalTax = TotalSingletonClass.getTotalTaxObj();
					totalTax.totalList();
					break;
				case 4 : 
					System.out.println("Than You For Visiting, Exiting..............");
					return;
			}
			
			
		}
	
//		List<AddProperty> list = new ArrayList<>();
//		Scanner ip = new Scanner(System.in);
//		PropertyTax propertyTax = new PropertyTax();
//		propertyTax.propertyMethod();
//		System.out.println(list);
		
//		VehicleTax vehicleTax = new VehicleTax();
//		vehicleTax.vehicleMethod();
		
//		TotalTax totalTax = new TotalTax();
//		totalTax.totalList();

	}

}
