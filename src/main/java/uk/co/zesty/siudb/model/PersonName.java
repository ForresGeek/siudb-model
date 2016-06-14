package uk.co.zesty.siudb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PersonName {
	
	
	private Long Id;
	private String surname;
	private String forename;
	private String othername;
	private String title;
	private String nameType;
	private Person person;
	

	public PersonName() {
		// TODO Auto-generated constructor stub
		
		
	
		
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getForename() {
		return forename;
	}


	public void setForename(String forename) {
		this.forename = forename;
	}


	public String getOthername() {
		return othername;
	}


	public void setOthername(String othername) {
		this.othername = othername;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNameType() {
		return nameType;
	}


	public void setNameType(String nameType) {
		this.nameType = nameType;
	}


	@ManyToOne(cascade=CascadeType.ALL)
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
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}

}
