package resumeBuilder;

public class ContactInformation {
	private String name;
	private String email;
	private String phone_number;
	private String address;
	
	public ContactInformation() {}
	
	public ContactInformation (String name, String email, String phone_number, String address) {
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phone_number;
	}
	
	public String getAddress() {
		return this.address;
	}
}
