package pojo;

public class User {
	private String username;
	private int age;
	private String password;
	
	public User(String username, int age, String password) {
		super();
		this.username = username;
		this.age = age;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", password=" + password + "]";
	}	
	
}
