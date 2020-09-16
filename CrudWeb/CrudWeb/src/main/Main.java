package main;
 
import controller.UserController;
 
// import model.User;
 
public class Main {
 
	public static void main(String[] args) {
		// User user = new User("Luchi", "Hernandez", "lu97is");			
		UserController userController = new UserController();
 
		// userController.create(user);
		// userController.getAll();

		// String[] fields = {"firstName", "lastName", "username"};
		// String[] values = {"Luis 2", "Hernandez 2", "luchi 2"};
		// userController.update(fields, values, 2);

		// userController.delete(2);
		userController.getUserById(1);
	}
}