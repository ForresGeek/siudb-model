package uk.co.zesty.siudb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SchedulingNote {
	
	/* Class to hold NTE segments from Cerner Scheduling messages */
	

	private Long id;
	private Integer setId;
	private String noteType;
	private String note;
	
	
	//Linked to appointment
	private Appointment appointment;
	
	public Integer getSetId() {
		return setId;
	}
	public void setSetId(Integer setId) {
		this.setId = setId;
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	
	@Column(columnDefinition="TEXT")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
