package idao;
 
import java.util.List;
 
import model.User;
 
public interface UserDaoInterface {	
	public boolean createUser(User user);
	public List<User> getAllUsers();
	public boolean uptadeUserById(String[] fields, String[] values, int id);
	public boolean deleteUserById(int id);
	public User getUserById(int id);
}