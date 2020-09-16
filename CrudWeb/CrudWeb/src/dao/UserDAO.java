package dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import connection.DBConnection;
import idao.UserDaoInterface;
import model.User;
import helpers.*;
 
public class UserDAO implements UserDaoInterface {	
	
	@Override
	public boolean createUser(User user) {
		boolean added = false;
		
		Statement statement= null;
		Connection conection =null;
		String[] fields = {"firstName", "lastName", "username"};
		String[] values = {user.getFirstName(), user.getLastName(), user.getUsername()};
		String sql = Helpers.insertStatement("Users", fields, values);

		try {			
			conection= DBConnection.connect();
			statement= conection.createStatement();
			statement.execute(sql);
			added=true;
			statement.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't save new user");
			e.printStackTrace();
		}
		return added;
	}
 
	@Override
	public List<User> getAllUsers() {
		Connection conection =null;
		Statement statement= null;
		ResultSet rs=null;
		
		String sql= Helpers.getAllStatement("Users");
		
		List<User> users= new ArrayList<User>();
		
		try {			
			conection= DBConnection.connect();
			statement=conection.createStatement();
			rs=statement.executeQuery(sql);
			while (rs.next()) {
				User c=new User();
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setUsername(rs.getString(4));
				users.add(c);
			}
			statement.close();
			rs.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't get users list");
			e.printStackTrace();
		}
		
		return users;
	}
 
	@Override
	public boolean uptadeUserById(String[] fields, String[] values, int id) {
		Connection conection= null;
		Statement statement= null;
		
		boolean updated=false;
		
		String sql = Helpers.updateById("Users", fields, values, id, "user_id");		
		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			statement.execute(sql);
			updated=true;
		} catch (SQLException e) {
			System.out.println("Couldn't update the user");
			e.printStackTrace();
		}		
		return updated;
	}
 
	@Override
	public boolean deleteUserById(int id) {
		Connection conection = null;
		Statement statement = null;
		
		boolean deleted=false;
				
		String sql= Helpers.deleteById("Users", id, "user_id");
		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("Couldn't delete user");
			e.printStackTrace();
		}		
		return deleted;
	}

	@Override
	public User getUserById(int id) {
		Connection conection = null;
		Statement statement = null;
		User user = null;
		ResultSet rs= null;
		String sql= Helpers.getById("Users", id, "user_id");

		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				User c = new User();
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setUsername(rs.getString(4));
				System.out.println(c);
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				user = c;
			}
			statement.close();
			rs.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't get user");
			e.printStackTrace();
		}
		return user;
	}
 
}