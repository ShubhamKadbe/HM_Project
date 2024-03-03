package com.hmstatus.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hmstatus.model.HmStatus;
import com.hmstatus.model.HmStatusDTO;
import com.hmstatus.repository.HmStatusRepository;
import com.hmstatus.service.HmStatusService;

import javax.servlet.http.HttpServletRequest;

@Service
public class HmStatusServiceImpl implements HmStatusService {
	
	@Autowired
	private HmStatusRepository hmStatusRepository;

//	@Override
//	public ResponseEntity<List<HmStatusDTO>> getData (String vin, String protocolVersion) {
//		try {
//			List<HmStatus> hmStatusList = hmStatusRepository.findByVinAndProtocolVer(vin, protocolVersion);
//			List<HmStatusDTO> hmStatusDTOList = convertToHmStatusDTOList(hmStatusList);
//			return ResponseEntity.ok().body(hmStatusDTOList);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}

	@Override
	public ResponseEntity<List<HmStatus>> getDataByVinAndProtocolVer(String vin, String protocolVersion, String messageType ) {
		try {
			List<HmStatus> hmStatusList = hmStatusRepository.findByVinAndProtocolVer(vin, protocolVersion, messageType);
//			List<HmStatusDTO> hmStatusDTOList = convertToHmStatusDTOList(hmStatusList);
			return ResponseEntity.ok().body(hmStatusList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<List<HmStatus>> getDataByMessageType(String messageType) {
		try {
			List<HmStatus> hmStatusList = hmStatusRepository.findByMessageType(messageType);
//			List<HmStatusDTO> hmStatusDTOList = convertToHmStatusDTOList(hmStatusList);
			return ResponseEntity.ok().body(hmStatusList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Override
	public ResponseEntity<List<HmStatus>> getDataByVinProtocolVerAndCluster_id(String vin, String protocolVersion, int cluster_id) {
		try {
			List<HmStatus> hmStatusList = hmStatusRepository.findByVinProtocolVerAndCluster_id(vin, protocolVersion, cluster_id);
//			List<HmStatusDTO> hmStatusDTOList = convertToHmStatusDTOList(hmStatusList);
			return ResponseEntity.ok().body(hmStatusList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<List<HmStatus>> saveHmStatusData( List<HmStatus> hmStatusList,
			HttpServletRequest request) {
		Timestamp currenTimestamp = new Timestamp(System.currentTimeMillis());

		hmStatusList.forEach(hmStatus -> hmStatus.setCreated_time_stamp(currenTimestamp.toString()));

		List<HmStatus> listHmStatus = hmStatusRepository.saveAll(hmStatusList);
		return ResponseEntity.ok().body(listHmStatus);
	}

	@Override
	public ResponseEntity<List<HmStatus>> getAllHmStatusData() {
		return ResponseEntity.ok().body(hmStatusRepository.findAll());
	}

	private List<HmStatusDTO> convertToHmStatusDTOList(List<HmStatus> hmStatusList) {
		List<HmStatusDTO> hmStatusDTOList = new ArrayList<HmStatusDTO>();
		hmStatusList.forEach(hmStatus -> {
			HmStatusDTO hmStatusDTO = new HmStatusDTO();
			hmStatusDTO.setMessagetype(hmStatus.getMessageType());
			hmStatusDTO.setCluster_id(hmStatus.getCluster_id());
			hmStatusDTO.setStatus(hmStatus.isStatus());
			hmStatusDTOList.add(hmStatusDTO);
			
		});
		return hmStatusDTOList;
	}

	

	
}