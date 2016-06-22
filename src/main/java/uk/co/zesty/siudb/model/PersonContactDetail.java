package uk.co.zesty.siudb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
@Table(name="personContactDetails")
@JsonApiResource(type = "personcontactdetail")
public class PersonContactDetail {
	
	
	

	private Long Id;
	private Person person;
	private String contactDetail;		//e.g. lee@dyson.net
	private String contactType;			//e.g. EMAIL
	private String contactUse;			//e.g. HOME
	
	@JsonProperty("contact-detail")
	public String getContactDetail() {
		return contactDetail;
	}
	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}
	
	@JsonProperty("contact-type")
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
	@JsonProperty("contact-use")
	public String getContactUse() {
		return contactUse;
	}
	public void setContactUse(String contactUse) {
		this.contactUse = contactUse;
	}
	
	
	@JsonApiId
	@GeneratedValue
	@Id
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	//Many contect details to 1 person.
	//Contact details can't exist without person.
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name="PersonId")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonContactDetail [Id=").append(Id).append(", contactDetail=").append(contactDetail)
				.append(", contactType=").append(contactType).append(", contactUse=").append(contactUse).append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
}
