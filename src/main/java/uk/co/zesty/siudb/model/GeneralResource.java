package uk.co.zesty.siudb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

/*
 * Loosely - a wrapper for AIG segment.
 * 
 */
@Entity
@JsonApiResource(type = "generalresource")
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
	@JsonApiId
	public Long getId() {
		return id;
	}


	
	
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("set-id")
	public Integer getSetId() {
		return setId;
	}


	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	@JsonProperty("segment-action-code")
	public String getSegmentActionCode() {
		return segmentActionCode;
	}


	public void setSegmentActionCode(String segmentActionCode) {
		this.segmentActionCode = segmentActionCode;
	}

	@JsonProperty("resource-id")
	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@JsonProperty("resource-type")
	public String getResourceType() {
		return resourceType;
	}


	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@JsonProperty("start-time")
	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonProperty("time-offset")
	public Integer getTimeOffset() {
		return timeOffset;
	}


	public void setTimeOffset(Integer timeOffset) {
		this.timeOffset = timeOffset;
	}

	@JsonProperty("time-offset-units")
	public String getTimeOffsetUnits() {
		return timeOffsetUnits;
	}


	public void setTimeOffsetUnits(String timeOffsetUnits) {
		this.timeOffsetUnits = timeOffsetUnits;
	}

	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@JsonProperty("duration-units")
	public String getDurationUnits() {
		return durationUnits;
	}


	public void setDurationUnits(String durationUnits) {
		this.durationUnits = durationUnits;
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
		builder.append("GeneralResource [id=").append(id).append(", setId=").append(setId)
				.append(", segmentActionCode=").append(segmentActionCode).append(", resourceId=").append(resourceId)
				.append(", resourceType=").append(resourceType).append(", startTime=").append(startTime)
				.append(", timeOffset=").append(timeOffset).append(", timeOffsetUnits=").append(timeOffsetUnits)
				.append(", duration=").append(duration).append(", durationUnits=").append(durationUnits).append("]");
		return builder.toString();
	}

}
