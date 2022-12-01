package com.restaurant.com.restaurant.zomato;
import java.sql.*;
import java.util.Scanner;

public class JDBCZomatoConnection {
	static final Scanner obj = new Scanner(System.in);
	public static void createRestaurantName(Connection connection ,Zomato obj) throws SQLException {

		PreparedStatement pstmt = connection.prepareStatement("insert into zomato values(?,?,?,?,?,?)");

		pstmt.setString(1, obj.getRestaurantname());
		pstmt.setInt(2, obj.getRestaurantId());
		pstmt.setString(3, obj.getDeliverymode());
		pstmt.setInt(4, obj.getAveragePrice());
		pstmt.setInt(5, obj.getRating());
		pstmt.setString(6, obj.getLocation());
		int records = pstmt.executeUpdate();
		System.out.println(records +"inserted succesfully");

	}	
	private  static void updateRestaurantName(Connection connection,int restaurantId)throws SQLException {
		System.out.println("enter the update the name");
		String value=obj.next();
		PreparedStatement pstmt = connection.prepareStatement("update Zomato set restaurantName=? where restaurantId="+restaurantId);

		pstmt.setString(1, value);
		//pstmt.setInt(2, restaurantId);
		int records=pstmt.executeUpdate();
		System.out.println(records+"inserted succesfully");
	}

	private static void deleteRestaurantName(Connection connection)throws SQLException {

		System.out.println("enter the id to delete");
		int value1=obj.nextInt();
		PreparedStatement pstmt=connection.prepareStatement("delete from zomato where restaurantId=? ");
		pstmt.setInt(1, value1);
		//pstmt.setInt(2, restaurantId);

		int records=pstmt.executeUpdate();
		System.out.println(records+"inserted succesfully");
	}

	private static void ViewRestaurantDetails(Connection connection) throws SQLException {

		System.out.println("enter the restaurantId to read details from the table");
		int value2=obj.nextInt();
		
		PreparedStatement pstmt=connection.prepareStatement(" select * from zomato where restaurantId=?");
		pstmt.setInt(1, value2);

		ResultSet rs=pstmt.executeQuery();
		if(rs.next()==false)
		{
			System.out.println("There is no such record in this database");
		}
		else
		{
			//rs.previous();
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6));
		}
	}
	public static void main(String []args)throws Exception {
		//Connection connection=null;
		final Zomato zObj=new Zomato();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rama@1234");

		System.out.println("ENTER 1 TO ADD RESTAURANT DETAILS");
		System.out.println("ENTER 2 TO UPDATE RESTAURANT DETAILS");
		System.out.println("ENTER 3 TO DELETE RESTAURANT DETAILS");
		System.out.println("ENTER 4 TO VIEW RESTAURANT DETAILS");

		System.out.println("ENTER YOUR CHOICE");

		//Scanner obj=new Scanner(System.in);
		byte choice= obj.nextByte();
		switch(choice) {
			case 1:
				Zomato obj=getRestaurant();
				createRestaurantName(connection,obj);
				break;

			case 2:

				updateRestaurantName(connection,12);

				break;	

			case 3:
				deleteRestaurantName(connection);
				break;	

			case 4:
				ViewRestaurantDetails(connection);
				break;	


			default:
				System.out.println("ENTER PROPER DETAILS");	
				connection.close();
		}

	}

	private static Zomato getRestaurant() {
		Zomato restaurant=new Zomato();
		System.out.println("enter a restaurant name");
		restaurant.setRestaurantname(obj.next());

		System.out.println("enter a restaurant Id");
		restaurant.setRestaurantId(obj.nextInt());

		System.out.println("enter a delivery mode");
		restaurant.setDeliverymode(obj.next());

		System.out.println("enter a average price");
		restaurant.setAveragePrice(obj.nextInt());

		System.out.println("enter a rating");
		restaurant.setRating(obj.nextInt());

		System.out.println("enter a location");
		restaurant.setLocation(obj.next());

		return restaurant;
	}
}



