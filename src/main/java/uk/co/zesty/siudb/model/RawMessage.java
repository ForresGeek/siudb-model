/**
 * 
 */
package uk.co.zesty.siudb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

/**
 * @author lee
 * 
 * 
 * Class to hold an audit record of the raw HL7 message we receive as input
 * 
 * 
 */
@Entity
@Table(name="rawMessage")
public class RawMessage implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2984290203649856615L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="rawText",length=2048)
	private String rawText;

	@Column(name="msgId")
	private String msgId;
	
	@Column(name="msgType")
	private String msgType;
	
	
	@Column(name="dtmReceived")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtmReceived;
	
	@Column(name="processedFlag")
	private Boolean processedFlag;
	
	@Column(name="processedStatus")
	private String processedStatus;
	
	@Column(name="dtmProcessed")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtmProcessed;

	
	
	
	
	@Column(name="statusMessage")
	private String statusMessage;

	@JsonApiId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("raw-text")
	public String getRawText() {
		return rawText;
	}

	public void setRawText(String rawText) {
		this.rawText = rawText;
	}

	@JsonProperty("msg-id")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@JsonProperty("msg-type")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@JsonProperty("date-time-received")
	public Date getDtmReceived() {
		return dtmReceived;
	}

	public void setDtmReceived(Date dtmReceived) {
		this.dtmReceived = dtmReceived;
	}

	@JsonProperty("processed-flag")
	public Boolean getProcessedFlag() {
		return processedFlag;
	}

	public void setProcessedFlag(Boolean processedFlag) {
		this.processedFlag = processedFlag;
	}

	
	@JsonProperty("processed-status")
	public String getProcessedStatus() {
		return processedStatus;
	}

	public void setProcessedStatus(String processedStatus) {
		this.processedStatus = processedStatus;
	}

	
	@JsonProperty("date-time-processed")
	public Date getDtmProcessed() {
		return dtmProcessed;
	}

	public void setDtmProcessed(Date dtmProcessed) {
		this.dtmProcessed = dtmProcessed;
	}

	
	
	@JsonProperty("status-message")
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RawMessage [id=").append(id).append(", rawText=").append(rawText).append(", msgId=")
				.append(msgId).append(", msgType=").append(msgType).append(", dtmReceived=").append(dtmReceived)
				.append(", processedFlag=").append(processedFlag).append(", processedStatus=").append(processedStatus)
				.append(", dtmProcessed=").append(dtmProcessed).append(", statusMessage=").append(statusMessage)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rawText == null) ? 0 : rawText.hashCode());
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
		RawMessage other = (RawMessage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rawText == null) {
			if (other.rawText != null)
				return false;
		} else if (!rawText.equals(other.rawText))
			return false;
		return true;
	}
	
	
	
	
}
