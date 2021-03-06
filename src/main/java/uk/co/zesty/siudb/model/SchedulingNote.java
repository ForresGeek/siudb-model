package uk.co.zesty.siudb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;



@Entity
@JsonApiResource(type = "scheduling_note")
public class SchedulingNote {
	
	/* Class to hold NTE segments from Cerner Scheduling messages */
	

	private Long id;
	private String setId;
	private String noteType;
	private String note;
	
	
	//Linked to appointment
	private Appointment appointment;
	
	@JsonProperty("set_id")
	public String getSetId() {
		return setId;
	}
	public void setSetId(String setId) {
		this.setId = setId;
	}
	
	@JsonProperty("note_type")
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	
	@JsonProperty("note_text")
	@Column(columnDefinition="TEXT")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	@JsonApiId
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name="ApptId")
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SchedulingNote [id=").append(id).append(", setId=").append(setId).append(", noteType=")
				.append(noteType).append(", note=").append(note)
				.append("]");
		return builder.toString();
	}
	
	
}
