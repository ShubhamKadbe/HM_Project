package com.hmstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hmstatus.model.HmStatus;

@Repository
public interface HmStatusRepository extends JpaRepository<HmStatus, Integer> {

//	@Query(value = "select * from hm_status_tbl s where s.vin = :vin and s.ProtocolVersion = :protocolVersion", nativeQuery = true)
//	@Query(value = "select h1.* from hm_status_tbl h1 INNER JOIN (select DISTINCT cluster_id, MAX(created_time_stamp) AS MaxTime from hm_status_tbl GROUP BY cluster_id) h2 ON h1.cluster_id = h2.cluster_id and h1.created_time_stamp = h2.MaxTime "
//			+ "WHERE h1.vin = :vin and h1.ProtocolVersion = :protocolVersion and h1.messageType= :messageType", nativeQuery = true)
	
	@Query(value = "select h1.* from hm_status_tbl h1 INNER JOIN (select DISTINCT cluster_id, MAX(created_time_stamp) AS MaxTime from hm_status_tbl where ProtocolVersion = :protocolVersion GROUP BY cluster_id) h2 ON h1.cluster_id = h2.cluster_id and h1.created_time_stamp = h2.MaxTime "
			+ "WHERE h1.vin = :vin and h1.ProtocolVersion = :protocolVersion and h1.messageType= :messageType and created_time_stamp >= DATE_ADD(NOW() , INTERVAL -24 HOUR)", nativeQuery = true)
	List<HmStatus> findByVinAndProtocolVer(@Param("vin") String vin, @Param("protocolVersion") String protocolVersion, @Param ("messageType") String messageType);

//	@Query(value = "select * from hm_status_tbl h1 INNER JOIN (select DISTINCT cluster_id, MAX(created_time_stamp) AS MaxTime from hm_status_tbl GROUP BY cluster_id) h2 ON h1.cluster_id=h2.cluster_id and h1.created_time_stamp=h2.created_time_stamp WHERE messageType= :messageType", nativeQuery = true)
//	@Query(value = "select * from hm_status_tbl s where s.messageType= :messageType", nativeQuery = true)
	@Query(value = "select h1.* from hm_status_tbl h1 INNER JOIN (select DISTINCT cluster_id, MAX(created_time_stamp) "
			+ "AS MaxTime from hm_status_tbl GROUP BY cluster_id) h2 ON h1.cluster_id = h2.cluster_id and h1.created_time_stamp = h2.MaxTime WHERE h1.messageType= :messageType and created_time_stamp >= DATE_ADD(NOW() , INTERVAL -24 HOUR)", nativeQuery = true)
	List<HmStatus> findByMessageType(@Param("messageType") String messageType);

	
	@Query(value = "select h1.* from hm_status_tbl h1 INNER JOIN (select DISTINCT cluster_id, MAX(created_time_stamp) AS MaxTime from hm_status_tbl where ProtocolVersion = :protocolVersion GROUP BY cluster_id) h2 ON h1.cluster_id = h2.cluster_id and h1.created_time_stamp = h2.MaxTime "
			+ "WHERE h1.vin = :vin and h1.ProtocolVersion = :protocolVersion and h1.cluster_id= :cluster_id and created_time_stamp >= DATE_ADD(NOW() , INTERVAL -24 HOUR)", nativeQuery = true)
	List<HmStatus> findByVinProtocolVerAndCluster_id(@Param("vin") String vin, @Param("protocolVersion") String protocolVersion, @Param ("cluster_id")int cluster_id);
	
	

	
}
