package uk.co.zesty.siudb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Loosely - a wrapper for AIG segment.
 * 
 */
@Entity
public class GeneralResource {

	private Long id;
	
	private Integer setId;  //AIG-1
	private String segmentActionCode; //AIG-2
	private String resourceId; //AIG-3
	private String resourceType; //AIG-4
	private Date startTime; //AIG-8
	private Integer timeOffset; //AIG-9
	private String timeOffsetUnits; //AIG-10
	private Integer duration;	//AIG-11
	private String durationUnits;  //AIG-12
	
	
	private Appointment appointment;
	
	public GeneralResource() {
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public String getResourceType() {
		return resourceType;
	}


	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Integer getTimeOffset() {
		return timeOffset;
	}


	public void setTimeOffset(Integer timeOffset) {
		this.timeOffset = timeOffset;
	}


	public String getTimeOffsetUnits() {
		return timeOffsetUnits;
	}


	public void setTimeOffsetUnits(String timeOffsetUnits) {
		this.timeOffsetUnits = timeOffsetUnits;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public String getDurationUnits() {
		return durationUnits;
	}


	public void setDurationUnits(String durationUnits) {
		this.durationUnits = durationUnits;
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
		builder.append("GeneralResource [id=").append(id).append(", setId=").append(setId)
				.append(", segmentActionCode=").append(segmentActionCode).append(", resourceId=").append(resourceId)
				.append(", resourceType=").append(resourceType).append(", startTime=").append(startTime)
				.append(", timeOffset=").append(timeOffset).append(", timeOffsetUnits=").append(timeOffsetUnits)
				.append(", duration=").append(duration).append(", durationUnits=").append(durationUnits).append("]");
		return builder.toString();
	}

}
