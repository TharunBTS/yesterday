package com.example.assignment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.assignment.propertytax.AddProperty;
import com.example.assignment.vehicletax.AddVehicle;

public class DbQueries {
	
	public static void insertRrecord(AddProperty ap)
	{
		try
		{
			System.out.println("In insertRecord function");
			Connection connection = DbConnect.getConnection();
			String sql = "insert into addProperty(baseValueOfLand, buildUpArea, ageOfLandInYears, locatedInCity, propertyTaxes) values (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
				
				ps.setInt(1,ap.getBaseValueOfLand());
				ps.setInt(2,ap.getBuildUpArea());
				ps.setInt(3,ap.getAgeOfLandInYears());
				ps.setString(4,ap.getLocatedInCity());
				ps.setDouble(5,ap.getTax());
			int n = ps.executeUpdate();
			System.out.println("Inserted "+n+" rows successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static List<AddProperty> getRecord()
	{
		List<AddProperty> list = new ArrayList();
		try
		{
			Connection connection = DbConnect.getConnection();
			String sql = "select * from addProperty";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			AddProperty ap;
			while(rs.next())
			{
				ap = new AddProperty();
				ap.setPropertyId(rs.getInt(1));
				ap.setBaseValueOfLand( rs.getInt(2));
				ap.setBuildUpArea( rs.getInt(3));
				ap.setAgeOfLandInYears(rs.getInt(4));
				ap.setLocatedInCity(rs.getString(5));
				ap.setTax((int) rs.getDouble(6));
				list.add(ap);
			}
//			System.out.println("Inserted "+n+" rows successfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}
	
	
	public static void updateRecord(AddProperty ap, double tax)
	{
		try {
			Connection connection = DbConnect.getConnection();
			String sql = "update addProperty set propertyTaxes = ? where propertId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, tax);
			ps.setInt(2, ap.getPropertyId());
			int rs = ps.executeUpdate();
			System.out.println("propertyId "+ap.getPropertyId()+" is updated!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
//	 Vehicle Related Queries
	
	
	
	public static void insertVehicleRrecord(AddVehicle av)
	{
		try
		{
			System.out.println("In insertRecord function");
			Connection connection = DbConnect.getConnection();
			String sql = "insert into addVehicle(vehicleRegistrationNumber, vehicleBrand, maximumVelocityOfVehicle, capacity, vehicleType, purchaseCost, vehicleTax) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
				ps.setString(1,av.getVehicleRegistrationNumber());
				ps.setString(2,av.getVehicleBrand());
				ps.setInt(3,av.getMaximumVelocityOfVehicle());
				ps.setInt(4,av.getCapacity());
				ps.setString(5,av.getTypeOfVehicle());
				ps.setInt(6,av.getPurchaseCost());
				ps.setDouble(7,av.getVehicleTax());
			int n = ps.executeUpdate();
			System.out.println("Inserted "+n+" rows successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	public static List<AddVehicle> getVehicleRecord()
	{
		List<AddVehicle> list = new ArrayList();
		try
		{
			Connection connection = DbConnect.getConnection();
			String sql = "select * from addVehicle";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			AddVehicle ap = new AddVehicle();
			
			while(rs.next())
			{
				ap = new AddVehicle();
				ap.setVehicleId(rs.getInt(1));
				ap.setVehicleRegistrationNumber(rs.getString(2));
				ap.setVehicleBrand(rs.getString(3));
				ap.setMaximumVelocityOfVehicle(rs.getInt(4));
				ap.setCapacity(rs.getInt(5));
				ap.setTypeOfVehicle(rs.getString(6));
				ap.setPurchaseCost(rs.getInt(7));
				ap.setVehicleTax(rs.getDouble(8));
				list.add(ap);
			}
//			System.out.println("Inserted "+n+" rows successfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}
	
	
	
	
	
	
	
	public static void updateVehicleRecord(AddVehicle ap, double tax)
	{
		try {
			Connection connection = DbConnect.getConnection();
			String sql = "update addVehicle set vehicletax = ? where vehicleId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, tax);
			ps.setInt(2, ap.getVehicleId());
			int rs = ps.executeUpdate();
			System.out.println("vehicleId "+ap.getVehicleId()+" is updated!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int[] recordCount() throws Exception
	{
		Connection connection = DbConnect.getConnection();
		String sql = "select count(*) from addProperty";
		PreparedStatement ps1 = connection.prepareStatement(sql);
		ResultSet count1 = ps1.executeQuery();
		int res1 = 0;
		if (count1.next()) {  
		    res1 = count1.getInt(1); 
		}
		
		sql = "select count(*) from addVehicle";
		PreparedStatement ps2 = connection.prepareStatement(sql);
		ResultSet count2 = ps2.executeQuery();
//		int res2 = count2.getInt(1);
		int res2 = 0;
		if (count2.next()) {  
		    res2 = count2.getInt(1);  
		}
		return new int[] {res1, res2};
		
	}
	public static double[] taxSum() throws Exception
	{
		Connection connection = DbConnect.getConnection();
		String sql = "select sum(propertyTaxes) from addProperty";
		PreparedStatement ps1 = connection.prepareStatement(sql);
		ResultSet count1 = ps1.executeQuery();
		int res1 = 0;
		if (count1.next()) {  
		    res1 = count1.getInt(1); 
		}
		
		sql = "select sum(vehicleTax) from addVehicle";
		PreparedStatement ps2 = connection.prepareStatement(sql);
		ResultSet count2 = ps2.executeQuery();
		int res2 = 0;
		if (count2.next()) {  
		    res2 = count2.getInt(1);  
		}
		return new double[] {res1, res2};
		
	}
	
	

}
