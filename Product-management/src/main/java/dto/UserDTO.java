package dto;

public class UserDTO {

	private String userId;
	private String password;
	private String userName;
	private String division;
	
	
	public UserDTO() {
		
	}
	
	public UserDTO(String userId, String password, String userName, String division) {
		
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.division = division;
		
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	
	
}
