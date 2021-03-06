package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

//The object to model the database table for users
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your name.")
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.\\w+", message = "Please enter a valid email address.")
    private String email;
    @NotNull
    @Size(min=5, max=30, message = "Please enter a password of between 5 and 30 characters.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9_\\-]+", message = "The password has to contain a regular letter, a capital letter and a number.")
    private String password;
    private boolean boss = false; //email: mathias.fuchs@anitrans.ch password: theboss

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getBoss() {
		return boss;
	}
	
	public void setBoss(boolean boss) {
		this.boss = boss;
	}
    
    
}

