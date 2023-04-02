package Policy;

import java.io.Serializable;

public class Customer implements Serializable{
	
	String fname, lname, city;
	int c_phone;
	Policy policy;
	public Customer(String fname, String lname, String city, int c_phone, Policy policy) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.c_phone = c_phone;
		this.policy = policy;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getCity() {
		return city;
	}
	public int getC_phone() {
		return c_phone;
	}
	public Policy getPolicy() {
		return policy;
	}
	@Override
	public String toString() {
		return "First Name" + fname + '\n' + 
				"Last Name" + lname + '\n' +
				"City" + city + '\n' + '\n' + 
				"Mobile Phone" + c_phone + '\n' + 
				" " + policy;
	}
	
	
	
	

}
