package uk.co.zesty.siudb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@Entity
@JsonApiResource(type = "patient_visit")
public class PatientVisit {

	/*
	 *  Essentially a wrapper for fields from PV1
	 *  - Appointment specialty
	 * 	- Clinician
	 * 
	 */
	public PatientVisit() {
		// TODO Auto-generated constructor stub
	}

	

	private String visitId;
	private String specialty;
	private Appointment appointment;
	private Long appointmentId;
	
	
	@JsonProperty("visit_id")
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	
	@JsonProperty("specialty")
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Apptid")
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	

	@Id  
	@JsonApiId()
    @GeneratedValue(generator="myGenerator")  
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(value="appointment", name = "property")) 
	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientVisit [visitId=").append(visitId).append(", specialty=").append(specialty)
				.append(", appointmentId=").append(appointmentId).append("]");
		return builder.toString();
	}
	
}
