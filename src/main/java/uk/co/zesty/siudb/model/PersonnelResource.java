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

@Entity
@JsonApiResource(type = "personnelresource")
public class PersonnelResource {

	
	public PersonnelResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	private Long Id;
	private Integer setId;
	private String personnelId;
	private String personnelIdType;
	private String personnelGivenName;
	private String personnelFamilyName;
	private String personnelPrefix;

	private String personnelResourceRole;
	private String personnelResourceGroup;

	private Date startDate;
	private Integer timeOffset;
	private  String timeOffsetUnits;
	private Integer duration;
	private String durationUnits;
	private String allowSubstitution;
	private String fillerStatusCode;
	
	
	
	
	
	private Appointment appointment;




	@JsonApiId
	@Id
	@GeneratedValue
	public Long getId() {
		return Id;
	}





	public void setId(Long id) {
		Id = id;
	}




	@JsonProperty("set-id")
	public Integer getSetId() {
		return setId;
	}





	public void setSetId(Integer setId) {
		this.setId = setId;
	}




	@JsonProperty("personnel-id")
	public String getPersonnelId() {
		return personnelId;
	}





	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}




	@JsonProperty("personnel-id-type")
	public String getPersonnelIdType() {
		return personnelIdType;
	}





	public void setPersonnelIdType(String personnelIdType) {
		this.personnelIdType = personnelIdType;
	}




	@JsonProperty("personnel-given-name")
	public String getPersonnelGivenName() {
		return personnelGivenName;
	}





	public void setPersonnelGivenName(String personnelGivenName) {
		this.personnelGivenName = personnelGivenName;
	}




	@JsonProperty("personnel-family-name")
	public String getPersonnelFamilyName() {
		return personnelFamilyName;
	}





	public void setPersonnelFamilyName(String personnelFamilyName) {
		this.personnelFamilyName = personnelFamilyName;
	}




	@JsonProperty("personnel-prefix")
	public String getPersonnelPrefix() {
		return personnelPrefix;
	}





	public void setPersonnelPrefix(String personnelPrefix) {
		this.personnelPrefix = personnelPrefix;
	}




	@JsonProperty("personnel-resource-role")
	public String getPersonnelResourceRole() {
		return personnelResourceRole;
	}





	public void setPersonnelResourceRole(String personnelResourceRole) {
		this.personnelResourceRole = personnelResourceRole;
	}




	@JsonProperty("personnel-resource-group")
	public String getPersonnelResourceGroup() {
		return personnelResourceGroup;
	}





	public void setPersonnelResourceGroup(String personnelResourceGroup) {
		this.personnelResourceGroup = personnelResourceGroup;
	}




	@JsonProperty("start-date")
	public Date getStartDate() {
		return startDate;
	}





	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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




	@JsonProperty("allow-substitution")
	public String getAllowSubstitution() {
		return allowSubstitution;
	}





	public void setAllowSubstitution(String allowSubstitution) {
		this.allowSubstitution = allowSubstitution;
	}




	@JsonProperty("filler-status-code")
	public String getFillerStatusCode() {
		return fillerStatusCode;
	}





	public void setFillerStatusCode(String fillerStatusCode) {
		this.fillerStatusCode = fillerStatusCode;
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
		builder.append("PersonnelResource [Id=").append(Id).append(", setId=").append(setId).append(", personnelId=")
				.append(personnelId).append(", personnelIdType=").append(personnelIdType)
				.append(", personnelGivenName=").append(personnelGivenName).append(", personnelFamilyName=")
				.append(personnelFamilyName).append(", personnelPrefix=").append(personnelPrefix)
				.append(", personnelResourceRole=").append(personnelResourceRole).append(", personnelResourceGroup=")
				.append(personnelResourceGroup).append(", startDate=").append(startDate).append(", timeOffset=")
				.append(timeOffset).append(", timeOffsetUnits=").append(timeOffsetUnits).append(", duration=")
				.append(duration).append(", durationUnits=").append(durationUnits).append(", allowSubstitution=")
				.append(allowSubstitution).append(", fillerStatusCode=").append(fillerStatusCode).append("]");
		return builder.toString();
	}
}
