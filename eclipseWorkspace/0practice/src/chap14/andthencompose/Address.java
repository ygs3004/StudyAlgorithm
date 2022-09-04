package chap14.andthencompose;

public class Address {
	private String country;
	private String city;
	
	public Address(String country, String city) {
		this.country=country;
		this.city=city;
	}

	public String getCity() {return city;}
	public String getCountry() {return country;	}
}