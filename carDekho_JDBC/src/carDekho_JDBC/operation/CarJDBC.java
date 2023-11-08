package carDekho_JDBC.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CarJDBC {
   
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
    private String query;
    
    public void addCar(Car car) {
    	 try {
			connection=openConnection();
			query="insert into car values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,car.getCar_id());
			preparedStatement.setString(2, car.getName());
			preparedStatement.setString(3,car.getBrand());
			preparedStatement.setString(4,car.getFuel_type());
			preparedStatement.setDouble(5, car.getPrice());
			int row= preparedStatement.executeUpdate();
			System.out.println(row +"row(s) affected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
   public List<Car> getAllCar() {
    	ArrayList<Car> list=new ArrayList<Car>();
    	 try {
			connection=openConnection();
			query="select * from car";
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  Car car= new Car();
			   car.setCar_id(resultSet.getInt(1));
			   car.setName(resultSet.getString(2));
			   car.setBrand(resultSet.getString(3));
			   car.setFuel_type(resultSet.getString(4));
			   car.setPrice(resultSet.getDouble(5));
			   list.add(car);
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return list;
    }
    
    public void deleteCar(int car_id) {
    	  try {
			connection=openConnection();
			query="delete from car where car_id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, car_id);
			int row=preparedStatement.executeUpdate();
			System.out.println(row +"row(s) affected");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	  
    	  
    	  
    }
    public void updateCar(int car_id,Scanner scanner) {
    	try {
			connection=openConnection();
			query="update car set name=?, brand=?, fuel_type=?, price=? where car_id=?";
			preparedStatement=connection.prepareStatement(query);
			scanner.nextLine();
			System.out.println("Enter car name");
			preparedStatement.setString(1,scanner.nextLine());
			System.out.println("Enter car brand");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter car Fuel_type");
			preparedStatement.setString(3,scanner.nextLine());
			System.out.println("Enter car price");
			preparedStatement.setDouble(4,scanner.nextDouble());
			preparedStatement.setInt(5, car_id);
			int row=preparedStatement.executeUpdate();
			System.out.println(row +"row(s) affected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    public Car getCarById( int car_id) {
    	Car car=new Car();
    	try {
			connection=openConnection();
			query="select * from car where car_id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, car_id);
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return car;
    }
    public Car getCarByName() {
    	Car car=new Car();
    	try {
			connection=openConnection();
			query="select * from car where name=?";
			preparedStatement=connection.prepareStatement(query);
			Scanner scanner=new Scanner(System.in);
			
			preparedStatement.setString(1, scanner.next());
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return car;
    }
    public Car getCarByBrand() {
    	Car car=new Car();
    	try {
			connection=openConnection();
			query="select * from car where brand=?";
			preparedStatement=connection.prepareStatement(query);
			Scanner scanner =new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	 return car;
    }
    public Car getCarByFuelType() {
    	
   	 Car  car=new Car();
   	  try {
			connection=openConnection();
			query="select * from car where fuel_type=?";
			preparedStatement=connection.prepareStatement(query);
			Scanner scanner =new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
	     	resultSet= preparedStatement.executeQuery();
	     	if (resultSet.next()) {
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
			}
	     
					} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   	  
   	
   	
   	return car;
   }
   
    public Car getCarByPrice() {
    	 Car  car=new Car();
   	  try {
			connection=openConnection();
			query="select * from car where price=?";
			preparedStatement=connection.prepareStatement(query);
			Scanner scanner =new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
	     	resultSet= preparedStatement.executeQuery();
	     	if (resultSet.next()) {
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
			}
	     
					} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   	  
   	
   	
   	return car;
    }
	 
    private Connection openConnection() throws SQLException, ClassNotFoundException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja2", "root", "root");
    }
    private void closeConnection() throws SQLException {
    	if (connection !=null) {
			connection.close();
		}
    	if (preparedStatement !=null) {
			preparedStatement.close();
		}
    	if (resultSet !=null) {
			resultSet.close();
		}
    }
}
