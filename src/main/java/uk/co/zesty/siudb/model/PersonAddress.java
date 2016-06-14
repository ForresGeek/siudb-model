package uk.co.zesty.siudb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PersonAddress {

	//Definiton based on HL7v2.3 XAD structure.
	private Person person;
	private Long id;
	private String streetAddress;
	private String otherDesignation;
	private String city;
	private String stateOrProvince;
	private String zipOrPostCode;
	private String addressType;
	private String otherGeographicDesignation;
	private String County;
	private String censusTract;
	
	
	public PersonAddress() {
		// TODO Auto-generated constructor stub
		
		
	}


	@ManyToOne(optional = false)
	@JoinColumn(name="PersonId")
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getOtherDesignation() {
		return otherDesignation;
	}


	public void setOtherDesignation(String otherDesignation) {
		this.otherDesignation = otherDesignation;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStateOrProvince() {
		return stateOrProvince;
	}


	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}


	public String getZipOrPostCode() {
		return zipOrPostCode;
	}


	public void setZipOrPostCode(String zipOrPostCode) {
		this.zipOrPostCode = zipOrPostCode;
	}


	public String getAddressType() {
		return addressType;
	}


	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	public String getOtherGeographicDesignation() {
		return otherGeographicDesignation;
	}


	public void setOtherGeographicDesignation(String otherGeographicDesignation) {
		this.otherGeographicDesignation = otherGeographicDesignation;
	}


	public String getCounty() {
		return County;
	}


	public void setCounty(String county) {
		County = county;
	}


	public String getCensusTract() {
		return censusTract;
	}


	public void setCensusTract(String censusTract) {
		this.censusTract = censusTract;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonAddress [id=").append(id).append(", streetAddress=").append(streetAddress)
				.append(", otherDesignation=").append(otherDesignation).append(", city=").append(city)
				.append(", stateOrProvince=").append(stateOrProvince).append(", zipOrPostCode=").append(zipOrPostCode)
				.append(", addressType=").append(addressType).append(", otherGeographicDesignation=")
				.append(otherGeographicDesignation).append(", County=").append(County).append(", censusTract=")
				.append(censusTract).append("]");
		return builder.toString();
	}

}
