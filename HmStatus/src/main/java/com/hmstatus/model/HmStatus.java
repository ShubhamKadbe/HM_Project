package com.hmstatus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "hm_status_tbl")
public class HmStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "vin", length = 50)
	private String vin;

	@Column(name = "BU", length = 10)
	@JsonProperty("BU")
	private String bU;

	@Column(name = "deviceType", length = 50)
	@JsonProperty("deviceType")
	private String deviceType;

	@Column(name = "messageType", length = 150)
	@JsonProperty("messageType")
	private String messageType;

	@Column(name = "protocolVersion", length = 10)
	@JsonProperty("protocolVersion")
	private String protocolVersion;

	@Column(name = "status")
	private boolean status;

	@Column(name = "cluster_id")
	private int cluster_id;

	@Column(name = "created_time_stamp")
	private String created_time_stamp;

	@Column(name = "l4_forwarding_status")
	private Boolean l4_forwarding_status;

	@Column(name = "status_Code_API")
	private String status_Code_API;

	public HmStatus() {

	}

	public HmStatus(int id, String vin, String bU, String deviceType, String messageType, String protocolVersion,
			boolean status, int cluster_id, String created_time_stamp, Boolean l4_forwarding_status,
			String status_Code_API) {
		this.id = id;
		this.vin = vin;
		this.bU = bU;
		this.deviceType = deviceType;
		this.messageType = messageType;
		this.protocolVersion = protocolVersion;
		this.status = status;
		this.cluster_id = cluster_id;
		this.created_time_stamp = created_time_stamp;
		this.l4_forwarding_status = l4_forwarding_status;
		this.status_Code_API = status_Code_API;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getbU() {
		return bU;
	}

	public void setbU(String bU) {
		this.bU = bU;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCluster_id() {
		return cluster_id;
	}

	public void setCluster_id(int cluster_id) {
		this.cluster_id = cluster_id;
	}

	public String getCreated_time_stamp() {
		return created_time_stamp;
	}

	public void setCreated_time_stamp(String created_time_stamp) {
		this.created_time_stamp = created_time_stamp;
	}

	public Boolean isL4_forwarding_status() {
		return l4_forwarding_status;
	}


	public void setL4_forwarding_status(Boolean l4_forwarding_status) {
			this.l4_forwarding_status = l4_forwarding_status;
	}

	public String getStatus_Code_API() {
		return status_Code_API;
	}

	public void setStatus_Code_API(String status_Code_API) {
		this.status_Code_API = status_Code_API;
	}

}
