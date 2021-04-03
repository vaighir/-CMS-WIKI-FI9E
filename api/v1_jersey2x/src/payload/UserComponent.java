package payload;


/**
 * Data Transfer Object.
 * Used to transfer data between Client snd Server
 * @author FEY
 *
 */
public class UserComponent {
	
	private int id = 0;
	private String name = "";
	private String email = "";
	
	public UserComponent() {
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
