package uk.co.zesty.siudb.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToMany;

import javax.persistence.Id;
import javax.persistence.Index;

@Entity
@Table(
	    indexes = { @Index(columnList="surname,forename"),@Index(columnList="guid") }
		) 
@JsonApiResource(type = "person")
public class Person {
	

	private Long Id;
	
	private String guid;
	
	private String sex;
	private String surname;
	private String forename;
	private String otherNames;
	private String Title;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
		
	private Set <PersonIdentifier> identifiers;
	private Set <PersonContactDetail> contacts;
	private Set <PersonAddress> addresses;
	
	
	private Set <Appointment> appointments;
	
	
	
	
	
	@JsonApiToMany
	@JsonProperty
	@OneToMany(mappedBy = "person", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<Appointment> getAppointments() {
		return appointments;
	}




	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}




	public Person()
	{
		identifiers = new HashSet<PersonIdentifier>();
		contacts = new HashSet<PersonContactDetail>();
		addresses = new HashSet<PersonAddress>();
		appointments = new HashSet<Appointment>();
		this.guid = UUID.randomUUID().toString();
	}
	
	
	
	
	@JsonProperty
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonProperty
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@JsonProperty
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	@JsonProperty
	public String getOtherNames() {
		return otherNames;
	}
	
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	
	
	@JsonProperty
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	
	@JsonProperty
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@JsonProperty()
	@JsonApiIncludeByDefault
	@OneToMany(mappedBy = "person", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<PersonIdentifier> getIdentifiers() {
		return identifiers;
	}
	
	public void setIdentifiers(Set<PersonIdentifier> identifiers) {
		this.identifiers = identifiers;
	}
	
	@JsonApiToMany(lazy=false)
	@JsonProperty
	@JsonApiIncludeByDefault
	@OneToMany(mappedBy = "person", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<PersonContactDetail> getContacts() {
		return contacts;
	}
	
	public void setContacts(Set<PersonContactDetail> contacts) {
		this.contacts = contacts;
	}
	
	@JsonApiToMany
	@JsonProperty
	@OneToMany(mappedBy = "person", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<PersonAddress> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(Set<PersonAddress> addresses) {
		this.addresses = addresses;
	}
	
	
	
	@JsonApiId
	@Column(nullable = false)
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Person [Id=").append(Id).append(", sex=").append(sex).append(", surname=").append(surname)
				.append(", forename=").append(forename).append(", otherNames=").append(otherNames).append(", Title=")
				.append(Title).append(", dob=").append(dob).append(", identifiers=")
				.append(identifiers != null ? toString(identifiers, maxLen) : null).append(", contacts=")
				.append(contacts != null ? toString(contacts, maxLen) : null).append(", addresses=")
				.append(addresses != null ? toString(addresses, maxLen) : null).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((identifiers == null) ? 0 : identifiers.hashCode());
		result = prime * result + ((otherNames == null) ? 0 : otherNames.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (forename == null) {
			if (other.forename != null)
				return false;
		} else if (!forename.equals(other.forename))
			return false;
		if (identifiers == null) {
			if (other.identifiers != null)
				return false;
		} else if (!identifiers.equals(other.identifiers))
			return false;
		if (otherNames == null) {
			if (other.otherNames != null)
				return false;
		} else if (!otherNames.equals(other.otherNames))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}

