package com.hmstatus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmstatus.model.HmStatus;
import com.hmstatus.serviceImpl.HmStatusServiceImpl;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hmStatus")
@CrossOrigin(origins = "*")
public class HmStatusController {

	@Autowired
	private HmStatusServiceImpl hmStatusServiceImpl;

	@GetMapping("{vin}/{protocolVersion}/{messageType}")
	public ResponseEntity<List<HmStatus>> getDataByVinAndProtocolVer(@PathVariable("vin") String vin,
			@PathVariable("protocolVersion") String protocolVersion,  @PathVariable("messageType") String messageType) {
		return hmStatusServiceImpl.getDataByVinAndProtocolVer(vin, protocolVersion, messageType);
	}

	@GetMapping("/{messageType}")
	public ResponseEntity<List<HmStatus>> getDataByMessagetype(@PathVariable("messageType") String messageType) {
		return hmStatusServiceImpl.getDataByMessageType(messageType);
	}
	
	@GetMapping("{vin}/{protocolVersion}/cluster_id/{cluster_id}")
	public ResponseEntity<List<HmStatus>> getDataByVinProtocolVerAndCluster_id(@PathVariable("vin") String vin,
			@PathVariable("protocolVersion") String protocolVersion,  @PathVariable("cluster_id") int cluster_id) {
		return hmStatusServiceImpl.getDataByVinProtocolVerAndCluster_id(vin, protocolVersion, cluster_id);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HmStatus>> getAllHmStatusData() {
		return hmStatusServiceImpl.getAllHmStatusData();
	}

	@PostMapping("/save")
	public ResponseEntity<List<HmStatus>> saveHmStatusData(@RequestBody List<HmStatus> hmStatusList,
			HttpServletRequest request) {
		return hmStatusServiceImpl.saveHmStatusData(hmStatusList, request);
	}

	
}
