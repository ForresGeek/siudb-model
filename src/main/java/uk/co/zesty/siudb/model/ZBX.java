package uk.co.zesty.siudb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * 
 *  Class used to serialize Cerner ZBX segments... Not sure that we'll need them..
 */

@Entity
public class ZBX {

	
	/*
	ZBX|10|ID|Patient Contact Needed^Patient Contact Needed||Y||||||||Event Detail
	*/
	
	
		private Long id;
		private String setId;		//ZBX-1
		private String code;		//ZBX-3.1
		private String note;		//ZMX-3.2
		private String flag;		//ZBX-5
		private String  noteType;	//ZBX-3
		private Appointment appointment;
		
		
		@ManyToOne(optional = true)
		@JoinColumn(name="ApptId")
		public Appointment getAppointment() {
			return appointment;
		}
		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}
		
		
		@Id 
		@GeneratedValue
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getSetId() {
			return setId;
		}
		public void setSetId(String setId) {
			this.setId = setId;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public String getNoteType() {
			return noteType;
		}
		public void setNoteType(String noteType) {
			this.noteType = noteType;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ZXB [id=").append(id).append(", setId=").append(setId).append(", code=").append(code)
					.append(", note=").append(note).append(", flag=").append(flag).append(", noteType=")
					.append(noteType).append("]");
			return builder.toString();
		}
		
	
		
	
	
}
