package uk.co.zesty.siudb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
//@Table(uniqueConstraints={
//	    @UniqueConstraint(columnNames = {"identifier", "identifiertype","identifierassigningauthority"})
//	}) 
public class PersonIdentifier {


	private Long Id;
	
	private String identifierType; 	//e.g. 'NHSNMBR'
	private String identifier;  // e.g. '1234567890'
	private String identifierAssigningAuthority; //e.g. 'RQW'
	

	private Person person;


	public String getIdentifierType() {
		return identifierType;
	}


	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getIdentifierAssigningAuthority() {
		return identifierAssigningAuthority;
	}


	public void setIdentifierAssigningAuthority(String identifierAssigningAuthority) {
		this.identifierAssigningAuthority = identifierAssigningAuthority;
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
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonIdentifier [Id=").append(Id).append(", identifierType=").append(identifierType)
				.append(", identifier=").append(identifier).append(", identifierAssigningAuthority=")
				.append(identifierAssigningAuthority).append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result
				+ ((identifierAssigningAuthority == null) ? 0 : identifierAssigningAuthority.hashCode());
		result = prime * result + ((identifierType == null) ? 0 : identifierType.hashCode());
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
		PersonIdentifier other = (PersonIdentifier) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (identifierAssigningAuthority == null) {
			if (other.identifierAssigningAuthority != null)
				return false;
		} else if (!identifierAssigningAuthority.equals(other.identifierAssigningAuthority))
			return false;
		if (identifierType == null) {
			if (other.identifierType != null)
				return false;
		} else if (!identifierType.equals(other.identifierType))
			return false;
		return true;
	}
	
	
	
}
