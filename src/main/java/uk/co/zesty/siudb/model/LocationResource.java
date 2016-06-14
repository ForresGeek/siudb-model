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

import io.katharsis.resource.annotations.JsonApiResource;


@Entity
public class LocationResource {
	
	
	private Long appointmentId;
	private Appointment appointment;
	
	private Integer setId;
	private String segmentActionCode ;
	private String locationType;
	private String locationGroup;
	
	//These are all from AIL-3
	private String pointOfCare;
	private String facility;
	private String building;
	private String bed;
	private String floor;
	private String room;
	
	public LocationResource() {
		// TODO Auto-generated constructor stub
		//Cerner uses AIL segmetn for this.. only 5 fields are populated.
		/*
		 * AIL-1: Set ID - AIL (SI)
AIL-2: Segment Action Code (ID) optional
AIL-3: Location Resource ID (PL)
AIL-4: Location Type (CE) optional
AIL-5: Location Group (CE) optional
AIL-6: Start Date/Time (TS) optional
AIL-7: Start Date/Time Offset (NM) optional
AIL-8: Start Date/Time Offset Units (CE) optional
AIL-9: Duration (NM) optional
AIL-10: Duration Units (CE) optional
AIL-11: Allow Substitution Code (IS) optional
AIL-12: Filler Status Code (CE) optional
		 */
				
	}



	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ApptId")
	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public Integer getSetId() {
		return setId;
	}


	public void setSetId(Integer setId) {
		this.setId = setId;
	}


	public String getSegmentActionCode() {
		return segmentActionCode;
	}


	public void setSegmentActionCode(String segmentActionCode) {
		this.segmentActionCode = segmentActionCode;
	}


	public String getLocationType() {
		return locationType;
	}


	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}


	public String getLocationGroup() {
		return locationGroup;
	}


	public void setLocationGroup(String locationGroup) {
		this.locationGroup = locationGroup;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("setId=").append(setId).append(", segmentActionCode=")
				.append(segmentActionCode).append(", locationType=").append(locationType).append(", locationGroup=")
				.append(locationGroup).append(", pointOfCare=").append(pointOfCare).append(", facility=")
				.append(facility).append(", building=").append(building).append(", bed=").append(bed).append(", floor=")
				.append(floor).append("]");
		return builder.toString();
	}


	public String getPointOfCare() {
		return pointOfCare;
	}


	public void setPointOfCare(String pointOfCare) {
		this.pointOfCare = pointOfCare;
	}


	public String getFacility() {
		return facility;
	}


	public void setFacility(String facility) {
		this.facility = facility;
	}


	public String getBuilding() {
		return building;
	}


	public void setBuilding(String building) {
		this.building = building;
	}


	public String getBed() {
		return bed;
	}


	public void setBed(String bed) {
		this.bed = bed;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}

/*
	public Long getLocationId() {
		return locationId;
	}


	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
*/
	
	
	//These funky annotations lock the Location and the appointment in a one-to-one where the promary key of the appointment is also the primary key of the location 
	// i.e. a foreign key
	
	@Id  
    @GeneratedValue(generator="myGenerator")  
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(value="appointment", name = "property")) 
	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

}
