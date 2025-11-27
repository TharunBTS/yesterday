package com.example.assignment.singleton;


import com.example.assignments.VehicleTax;

public class VehicleSingletonClass {
	
private static VehicleTax vehicleTax = null;
	
	public static VehicleTax getVehicleTaxObj()
	{
		if(vehicleTax == null)
		{
			vehicleTax = new VehicleTax();
		}
		return vehicleTax;
	}

}
