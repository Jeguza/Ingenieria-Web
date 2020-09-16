package controller;
 
import java.util.ArrayList;
import java.util.List;
 
import dao.UserDAO;
import idao.UserDaoInterface;
import model.User;
import view.ViewUser;
 
public class UserController {
	
	private ViewUser view= new ViewUser();
	
	public UserController() {
	}
	
	public void create(User cliente ) {
		UserDaoInterface userDAO = new UserDAO();
		userDAO.createUser(cliente);
	}
	
	public void update(String[] fields, String[] values, int id) {
		UserDaoInterface userDAO= new UserDAO();
		userDAO.uptadeUserById(fields, values, id);
	}
	
	public void delete(int id) {
		UserDaoInterface userDAO= new UserDAO();
		userDAO.deleteUserById(id);
	}
	
	public void getAll(){
		List<User> users = new ArrayList<User>();
		UserDaoInterface userDAO= new UserDAO();
		users=userDAO.getAllUsers();
		view.viewUsers(users);
	}

	public void getUserById(int id) {
		UserDaoInterface userDAO = new UserDAO();
		User user = userDAO.getUserById(id);
		System.out.println(user);
		view.viewUser(user);
	}
}