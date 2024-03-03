package com.hmstatus.model;

import lombok.Data;

@Data
public class HmStatusDTO {

	private String messageType;

	private Integer cluster_id;

	private boolean status;

	public String getMessagetype() {
		return messageType;
	}

	public void setMessagetype(String messageType) {
		this.messageType = messageType;
	}

	public Integer getCluster_id() {
		return cluster_id;
	}

	public void setCluster_id(Integer cluster_id) {
		this.cluster_id = cluster_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HmStatusDTO [messageType=" + messageType + ", cluster_id=" + cluster_id + ", status=" + status + "]";
	}

	public HmStatusDTO(String messageType, Integer cluster_id, boolean status) {
		this.messageType = messageType;
		this.cluster_id = cluster_id;
		this.status = status;
	}

	public HmStatusDTO() {
	}

	
}
