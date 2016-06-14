package uk.co.zesty.siudb.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;




/* 
 *  Cerner Appointment looks like tjios 
 * SCH|14148575.000^HNAMSCHEVID|000278378181^UBRNAP|||||Gynaecology New^^^Gynaecology New||20|MINUTES|^^20^20160701093000^20160701095000|||||1^SYSTEM^SYSTEM^^^^^^PERPRIID^PRSNL^^^PRSNLPRID^""||||1^SYSTEM^SYSTEM^^^^^^PERPRIID^PRSNL^^^PRSNLPRID^""|||||Confirmed 
 */


@Entity
@Transactional
@Table(
		uniqueConstraints={@UniqueConstraint(columnNames = {"eventid"})},
	    indexes = { @Index(columnList="eventid"),@Index(columnList="guid") }
		) 
public class Appointment {

	
	private Long id;
	

	private String guid;
	


	private String eventId;		//PlaceAppointmentId  SCH-1
	private String fillerId;	//Filler appointment Id  SCH-2
	private String occurence;	//Occurence Number		SCH-3
	private String eventReason;		//SCH-6... This is a repeating field.. do we need to store it as such ??
	private String appointmentReason;		//SCH-7
	private String apptType;		//SCH-8
	private Date apptStart;			//SCH-11.4
	private Date apptEnd;			//SCH-11.5
	private String apptDuration;		//SCH-9
	private Integer apptDurationMinutes;	//SCH-11.3
	private String durationUnits;		//SCH-10
	private LocationResource locationResource;
	private String enteredBy;			//SCH-20
	private String parentPlacerAptId;	//SCH-23
	private String parentFillerApptId; //SCH-24
	private String status;				//SCH-25

	private Person person;
	
	private Set <ZBX> zbxList;
	private Set <SchedulingNote> schedulingNotes;
	//private Resource resource;
	private PatientVisit visit;
	private Set<PersonnelResource> personnelResources;
	private Set<GeneralResource>	generalResources;

	
	
	
	public Appointment()
	{
		zbxList = new HashSet<ZBX>();
		schedulingNotes = new HashSet<SchedulingNote>();
		personnelResources = new HashSet<PersonnelResource>();
		generalResources = new HashSet<GeneralResource>();
		
		//Zesty API Accesses via GUID
		this.guid = UUID.randomUUID().toString();
	}
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getApptStart() {
		return apptStart;
	}

	public void setApptStart(Date apptStart) {
		this.apptStart = apptStart;
	}

	public Date getApptEnd() {
		return apptEnd;
	}

	public void setApptEnd(Date apptEnd) {
		this.apptEnd = apptEnd;
	}

	public String getApptDuration() {
		return apptDuration;
	}

	public void setApptDuration(String apptDuration) {
		this.apptDuration = apptDuration;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//Many appointments for one person
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PersonId")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getFillerId() {
		return fillerId;
	}

	public void setFillerId(String fillerId) {
		this.fillerId = fillerId;
	}

	public String getOccurence() {
		return occurence;
	}

	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}

	public String getEventReason() {
		return eventReason;
	}

	public void setEventReason(String eventReason) {
		this.eventReason = eventReason;
	}

	public String getAppointmentReason() {
		return appointmentReason;
	}

	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}

	public String getApptType() {
		return apptType;
	}

	public void setApptType(String apptType) {
		this.apptType = apptType;
	}

	public Integer getApptDurationMinutes() {
		return apptDurationMinutes;
	}

	public void setApptDurationMinutes(Integer apptDurationMinutes) {
		this.apptDurationMinutes = apptDurationMinutes;
	}

	public String getDurationUnits() {
		return durationUnits;
	}

	public void setDurationUnits(String durationUnits) {
		this.durationUnits = durationUnits;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getParentPlacerAptId() {
		return parentPlacerAptId;
	}

	public void setParentPlacerAptId(String parentPlacerAptId) {
		this.parentPlacerAptId = parentPlacerAptId;
	}

	public String getParentFillerApptId() {
		return parentFillerApptId;
	}

	public void setParentFillerApptId(String parentFillerApptId) {
		this.parentFillerApptId = parentFillerApptId;
	}
	
	
	@Column(nullable = false)
	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	

	

	
	@OneToMany(mappedBy = "appointment", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<SchedulingNote> getSchedulingNotes() {
		return schedulingNotes;
	}

	public void setSchedulingNotes(Set<SchedulingNote> schedulingNotes) {
		this.schedulingNotes = schedulingNotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentReason == null) ? 0 : appointmentReason.hashCode());
		result = prime * result + ((apptDuration == null) ? 0 : apptDuration.hashCode());
		result = prime * result + ((apptDurationMinutes == null) ? 0 : apptDurationMinutes.hashCode());
		result = prime * result + ((apptEnd == null) ? 0 : apptEnd.hashCode());
		result = prime * result + ((apptStart == null) ? 0 : apptStart.hashCode());
		result = prime * result + ((apptType == null) ? 0 : apptType.hashCode());
		result = prime * result + ((durationUnits == null) ? 0 : durationUnits.hashCode());
		result = prime * result + ((enteredBy == null) ? 0 : enteredBy.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventReason == null) ? 0 : eventReason.hashCode());
		result = prime * result + ((fillerId == null) ? 0 : fillerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locationResource == null) ? 0 : locationResource.hashCode());
		result = prime * result + ((occurence == null) ? 0 : occurence.hashCode());
		result = prime * result + ((parentFillerApptId == null) ? 0 : parentFillerApptId.hashCode());
		result = prime * result + ((parentPlacerAptId == null) ? 0 : parentPlacerAptId.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((schedulingNotes == null) ? 0 : schedulingNotes.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentReason == null) {
			if (other.appointmentReason != null)
				return false;
		} else if (!appointmentReason.equals(other.appointmentReason))
			return false;
		if (apptDuration == null) {
			if (other.apptDuration != null)
				return false;
		} else if (!apptDuration.equals(other.apptDuration))
			return false;
		if (apptDurationMinutes == null) {
			if (other.apptDurationMinutes != null)
				return false;
		} else if (!apptDurationMinutes.equals(other.apptDurationMinutes))
			return false;
		if (apptEnd == null) {
			if (other.apptEnd != null)
				return false;
		} else if (!apptEnd.equals(other.apptEnd))
			return false;
		if (apptStart == null) {
			if (other.apptStart != null)
				return false;
		} else if (!apptStart.equals(other.apptStart))
			return false;
		if (apptType == null) {
			if (other.apptType != null)
				return false;
		} else if (!apptType.equals(other.apptType))
			return false;
		if (durationUnits == null) {
			if (other.durationUnits != null)
				return false;
		} else if (!durationUnits.equals(other.durationUnits))
			return false;
		if (enteredBy == null) {
			if (other.enteredBy != null)
				return false;
		} else if (!enteredBy.equals(other.enteredBy))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventReason == null) {
			if (other.eventReason != null)
				return false;
		} else if (!eventReason.equals(other.eventReason))
			return false;
		if (fillerId == null) {
			if (other.fillerId != null)
				return false;
		} else if (!fillerId.equals(other.fillerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationResource == null) {
			if (other.locationResource != null)
				return false;
		} else if (!locationResource.equals(other.locationResource))
			return false;
		if (occurence == null) {
			if (other.occurence != null)
				return false;
		} else if (!occurence.equals(other.occurence))
			return false;
		if (parentFillerApptId == null) {
			if (other.parentFillerApptId != null)
				return false;
		} else if (!parentFillerApptId.equals(other.parentFillerApptId))
			return false;
		if (parentPlacerAptId == null) {
			if (other.parentPlacerAptId != null)
				return false;
		} else if (!parentPlacerAptId.equals(other.parentPlacerAptId))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (schedulingNotes == null) {
			if (other.schedulingNotes != null)
				return false;
		} else if (!schedulingNotes.equals(other.schedulingNotes))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Appointment [id=").append(id).append(", eventId=").append(eventId).append(", fillerId=")
				.append(fillerId).append(", occurence=").append(occurence).append(", eventReason=").append(eventReason)
				.append(", appointmentReason=").append(appointmentReason).append(", apptType=").append(apptType)
				.append(", apptStart=").append(apptStart).append(", apptEnd=").append(apptEnd).append(", apptDuration=")
				.append(apptDuration).append(", apptDurationMinutes=").append(apptDurationMinutes)
				.append(", durationUnits=").append(durationUnits).append(", location=").append(locationResource)
				.append(", enteredBy=").append(enteredBy).append(", parentPlacerAptId=").append(parentPlacerAptId)
				.append(", parentFillerApptId=").append(parentFillerApptId).append(", status=").append(status)
				.append(", schedulingNotes=").append(schedulingNotes != null ? toString(schedulingNotes, maxLen) : null)
				.append(", visit=").append(visit).append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}


	

	@OneToOne(mappedBy = "appointment", cascade=CascadeType.ALL)
	@JoinColumn(name="PVisitId")
	public PatientVisit getVisit() {
		return visit;
	}

	public void setVisit(PatientVisit visit) {
		this.visit = visit;
	}

	/*
	@OneToOne(mappedBy = "appointment", cascade=CascadeType.ALL)
	@JoinColumn(name="LocationId")
	public LocationResource getLocation() {
		return locationResource;
	}

	public void setLocation(LocationResource locationResource) {
		this.locationResource = locationResource;
	}
	 */
	
	
	@OneToMany(mappedBy = "appointment", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<PersonnelResource> getPersonnelResources() {
		return personnelResources;
	}

	public void setPersonnelResources(Set<PersonnelResource> personnelResources) {
		this.personnelResources = personnelResources;
	}

	@OneToMany(mappedBy = "appointment", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<GeneralResource> getGeneralResources() {
		return generalResources;
	}

	public void setGeneralResources(Set<GeneralResource> generalResources) {
		this.generalResources = generalResources;
	}


	@OneToOne(mappedBy = "appointment", cascade=CascadeType.ALL)
	@JoinColumn(name="LocationId")
	public LocationResource getLocationResource() {
		return locationResource;
	}


	public void setLocationResource(LocationResource locationResource) {
		this.locationResource = locationResource;
	}

	
	@OneToMany(mappedBy = "appointment", cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<ZBX> getZbxList() {
		return zbxList;
	}


	public void setZbxList(Set<ZBX> zbxList) {
		this.zbxList = zbxList;
	}
	
	
}
