package com.yts.revaux.ntQuote.repository;



import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.yts.revaux.ntQuote.entity.NtQuoteList;



@Repository

public interface NTQuoteListRepository extends JpaRepository<NtQuoteList, Long> {



	// count to check the mold mannual file exist or not
     @Query(value = "SELECT COUNT(*) FROM nt_quote " +

            "WHERE id = :id " +

            "AND (mold_manual LIKE CONCAT('%', :remoteFilePath, '%'))", 

    nativeQuery = true)

int countMoldManualFile(@Param("id") Long id, @Param("remoteFilePath") String remoteFilePath);





	// Overwrite the mold mannual file
	 @Modifying

	 @Transactional

	  @Query(value = "UPDATE nt_quote " +

              "SET mold_manual = array_append(array_remove(COALESCE(mold_manual, ARRAY[]::TEXT[]), :filePath), :filePath) " +

              "WHERE id = :id", nativeQuery = true)

	 void overwriteMoldManualAttachment(@Param("id") Long id, @Param("filePath") String remoteFilePath);


	 
// Upload mold manual file 
	 @Modifying

	 @Transactional

	 @Query("UPDATE NtQuoteList n SET n.moldManual = CONCAT(COALESCE(n.moldManual, ''), ',', :filePathString) " +

	        "WHERE n.id = :id")

	 void uploadMoldMannualDocIntoDatabase(@Param("id") Long id, 	                                  

	                                       @Param("filePathString") String filePathString);

// Delete mold manual file 
	 @Modifying
	 @Transactional
	 @Query(value = "UPDATE nt_quote " +
	                "SET mold_manual = REPLACE(mold_manual, :remoteFilePath, '') " +
	                "WHERE id = :id", nativeQuery = true)
	 void removeMoldManualFile(@Param("id") Long id, @Param("remoteFilePath") String remoteFilePath);




}

