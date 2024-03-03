package com.hmstatus.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hmstatus.model.HmStatus;

import javax.servlet.http.HttpServletRequest;


public interface HmStatusService{

	ResponseEntity<List<HmStatus>> getDataByVinAndProtocolVer (String vin, String protocolVersion, String messageType);

	ResponseEntity<List<HmStatus>> getDataByMessageType(String messageType);
	
	ResponseEntity<List<HmStatus>> getDataByVinProtocolVerAndCluster_id(String vin, String protocolVersion, int cluster_id);

	ResponseEntity<List<HmStatus>> saveHmStatusData(List<HmStatus> hmStatusList, HttpServletRequest request);

	ResponseEntity<List<HmStatus>> getAllHmStatusData();
}
