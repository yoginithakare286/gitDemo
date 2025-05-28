package com.yts.revaux.ntQuote.service;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



import com.jcraft.jsch.ChannelSftp;

import com.jcraft.jsch.JSch;

import com.jcraft.jsch.JSchException;

import com.jcraft.jsch.Session;

import com.jcraft.jsch.SftpException;

import com.yts.revaux.admin.web.rest.AdminRestController;

import com.yts.revaux.ntQuote.dto.NtQuoteDTO;

import com.yts.revaux.ntQuote.entity.NtQuoteList;

import com.yts.revaux.ntQuote.mapper.NtQuoteMapper;

import com.yts.revaux.ntQuote.repository.NTQuoteListRepository;





@Service

@Transactional

public class NtQuoteListService {

    private static final Logger logger = LoggerFactory.getLogger(AdminRestController.class);



	private final NTQuoteListRepository ntQuoteListRepository;

	private final NtQuoteMapper ntQuoteMapper;

	

	public NtQuoteListService(NTQuoteListRepository ntQuoteListRepository,

			                  NtQuoteMapper ntQuoteMapper) {

		

		this.ntQuoteListRepository = ntQuoteListRepository;

		this.ntQuoteMapper = ntQuoteMapper;

	}

	

	

	public List<NtQuoteDTO> getAllQuotes() {

        List<NtQuoteList> quotes = ntQuoteListRepository.findAll();



        System.out.println(" Raw Entity Data from DB: " + quotes); // Debugging



        if (quotes.isEmpty()) {

            System.out.println("⚠ No quotes found in the database!");

        }



        List<NtQuoteDTO> dtos = ntQuoteMapper.toDto(quotes);

        System.out.println(" Mapped DTOs: " + dtos); // Check mapped DTOs



        return dtos;

    }



	public void uploadMoldManualFile(byte[] fileBytes, String fileName, Long id) {

		logger.info("Upload Mold mannual Attach Files - Service method invoked with fileName: " + fileName + ", id: " + id);

		logger.info("Data size: " + fileBytes.length + " bytes");



		String remoteBasePath = "/home/CPS/NtQuote/MoldManual/" + id + "/";

		logger.info("remoteBasePath = " + remoteBasePath);

		logger.info("fileName = " + fileName);



		List<String> filePaths = new ArrayList<>();



		try {

			JSch jsch = new JSch();

			Session session = jsch.getSession("ytsolutions", "192.168.1.203", 22);

			session.setPassword("yts123#");

			session.setConfig("StrictHostKeyChecking", "no");

			session.connect();



			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");

			sftpChannel.connect();



			// Ensure the base directory exists

			createMoldMannualDirectoriesToUploadFile(sftpChannel, remoteBasePath);



			// Upload the new file to the dynamically created directory

			String remoteFilePath = remoteBasePath + fileName;

			logger.info("Attempting to upload new Mold Mannual file to: " + remoteFilePath);

			sftpChannel.put(new ByteArrayInputStream(fileBytes), remoteFilePath);



			// Add the uploaded file path to the list

			filePaths.add(remoteFilePath);

			logger.info("Added Mold Mannual file Path to list: " + remoteFilePath);



			// Disconnect SFTP session

			sftpChannel.disconnect();

			session.disconnect();



			logger.info("Mold Mannual  File uploaded successfully to: " + remoteFilePath);



			String filePathString = String.join(",", filePaths); // Join list into a single string

			System.out.println("filePathString = " + filePathString );

			ntQuoteListRepository.uploadMoldMannualDocIntoDatabase(id, filePathString);



			// Call DAO method to update the database with the list of file paths

			//ntQuoteListRepository.uploadMoldMannualDocIntoDatabase(id,filePaths);



		} catch (JSchException | SftpException e) {

			logger.error("Error Mold mannual  file: " + e.getMessage(), e);

		}

		

	}



	

	private void createMoldMannualDirectoriesToUploadFile(ChannelSftp sftpChannel, String remoteBasePath)

			throws SftpException {

		String[] dirs = remoteBasePath.split("/");

		String currentPath = "";

		for (String dir : dirs) {

			if (!dir.isEmpty()) {

				currentPath += "/" + dir;

				try {

					logger.info("Attempting to change directory to: " + currentPath);

					sftpChannel.cd(currentPath);

				} catch (SftpException e) {

					logger.info("MoldMannual Directory not found, attempting to create: " + currentPath);

					try {

						sftpChannel.mkdir(currentPath);

						sftpChannel.cd(currentPath);

					} catch (SftpException mkdirException) {

						logger.error("Failed to create MoldMannual directory: " + currentPath + " due to: "

								+ mkdirException.getMessage());

						throw mkdirException;

					}

				}

			}

		}

	}





	

	public boolean checkMoldMannualFileExists(Long id, String remoteFilePath) {

	    remoteFilePath = remoteFilePath.trim(); // Remove accidental spaces



	    logger.info("Checking Mold Manual File Exists - id: {}, remoteFilePath: '{}'", id, remoteFilePath);



	    int count = ntQuoteListRepository.countMoldManualFile(id, remoteFilePath);



	    logger.info("File existence count: {}", count);

	    

	    return count > 0;

	}





	public void overwriteMoldManualAttachment(byte[] fileBytes, String fileName, Long id) {

        logger.info("overwrite Mold Mannual_Files Attachment Service method invoked with fileName: {}, id: {}", fileName, id);

        logger.info("Data size: {} bytes", fileBytes.length);



    	String remoteBasePath = "/home/CPS/NtQuote/MoldManual/" + id + "/";

        logger.info("remoteBasePath = {}", remoteBasePath);

        logger.info("fileName = {}", fileName);



        List<String> filePaths = new ArrayList<>();



        try {

            JSch jsch = new JSch();

            Session session = jsch.getSession("ytsolutions", "192.168.1.203", 22);

            session.setPassword("yts123#");

            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();



            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");

            sftpChannel.connect();



            // Ensure the base directory exists

            createBuyerCadDirectories(sftpChannel, remoteBasePath);



            // Upload the new file to the dynamically created directory

            String remoteFilePath = remoteBasePath + fileName;

            logger.info("Attempting to overwrite mold mannual Files Attachment with new file: {}", remoteFilePath);

            sftpChannel.put(new ByteArrayInputStream(fileBytes), remoteFilePath);



            // Add the uploaded file path to the list

            filePaths.add(remoteFilePath);

            logger.info("Added filePath to list: {}", remoteFilePath);



            // Disconnect SFTP session

            sftpChannel.disconnect();

            session.disconnect();



            logger.info("mold mannual Files  overwritten successfully to: {}", remoteFilePath);



            // Call DAO method to update the database with the list of file paths

            ntQuoteListRepository.overwriteMoldManualAttachment(id, remoteFilePath);

        } catch (JSchException | SftpException e) {

            logger.error("Error overwriting Mold Mannual_Files: {}", e.getMessage(), e);

        }

    }

//	public void overwriteMoldManualAttachment(byte[] fileBytes, String fileName, Long id) {
//	    logger.info("overwrite Mold Manual File invoked with fileName: {}, id: {}", fileName, id);
//	    logger.info("Data size: {} bytes", fileBytes.length);
//
//	    String remoteBasePath = "/home/CPS/NtQuote/MoldManual/" + id + "/";
//	    String remoteFilePath = remoteBasePath + fileName;
//	    logger.info("Remote file path = {}", remoteFilePath);
//
//	    Session session = null;
//	    ChannelSftp sftpChannel = null;
//
//	    try {
//	        JSch jsch = new JSch();
//	        session = jsch.getSession("ytsolutions", "192.168.1.203", 22);
//	        session.setPassword("yts123#");
//	        session.setConfig("StrictHostKeyChecking", "no");
//	        session.connect();
//
//	        sftpChannel = (ChannelSftp) session.openChannel("sftp");
//	        sftpChannel.connect();
//
//	        // Ensure directory exists
//	        createBuyerCadDirectories(sftpChannel, remoteBasePath);
//
//	        // **Delete the old file before overwriting**
//	        try {
//	            sftpChannel.rm(remoteFilePath);
//	            Thread.sleep(2000); // Small delay before re-uploading
//	            logger.info("Deleted old file: {}", remoteFilePath);
//	        } catch (SftpException e) {
//	            logger.warn("Old file not found or could not be deleted: {}", e.getMessage());
//	        }
//
//	        // **Upload the new file**
//	        logger.info("Uploading new file to: {}", remoteFilePath);
//	        sftpChannel.put(new ByteArrayInputStream(fileBytes), remoteFilePath);
//
//	        // **Verify the uploaded file content**
//	        try (InputStream stream = sftpChannel.get(remoteFilePath)) {
//	            byte[] downloadedFileBytes = stream.readAllBytes();
//	            if (!Arrays.equals(downloadedFileBytes, fileBytes)) {
//	                logger.error("File content mismatch after upload! The old file may still be present.");
//	            } else {
//	                logger.info("File successfully replaced.");
//	            }
//	        }
//
//	        logger.info("Mold Manual File overwritten successfully: {}", remoteFilePath);
//
//	        // **Update database with correct file path**
//	        ntQuoteListRepository.overwriteMoldManualAttachment(id, remoteFilePath);
//
//	    } catch (JSchException e) {
//	        logger.error("JSch Exception while overwriting Mold Manual File: {}", e.getMessage(), e);
//	    } catch (SftpException e) {
//	        logger.error("SFTP Exception while overwriting Mold Manual File: {}", e.getMessage(), e);
//	    } catch (IOException e) {
//	        logger.error("IO Exception while overwriting Mold Manual File: {}", e.getMessage(), e);
//	    } catch (InterruptedException e) {
//	        Thread.currentThread().interrupt(); // Restore interrupted status
//	        logger.error("Thread interrupted while overwriting Mold Manual File: {}", e.getMessage(), e);
//	    } finally {
//	        if (sftpChannel != null && sftpChannel.isConnected()) {
//	            sftpChannel.disconnect();
//	        }
//	        if (session != null && session.isConnected()) {
//	            session.disconnect();
//	        }
//	    }
//	}


    private void createBuyerCadDirectories(ChannelSftp sftpChannel, String remoteBasePath) throws SftpException {

        String[] folders = remoteBasePath.split("/");

        String path = "";

        for (String folder : folders) {

            if (!folder.isEmpty()) {

                path += "/" + folder;

                try {

                    sftpChannel.cd(path);

                } catch (SftpException e) {

                    sftpChannel.mkdir(path);

                    sftpChannel.cd(path);

                }

            }

        }

    }

    
	  public void removeMoldManualFile(Long id, String remoteFilePath) 
	  {
		 try {
			  
			  	ntQuoteListRepository.removeMoldManualFile(id, remoteFilePath); 
			  } 
		 catch(Exception e) {
			 logger.error("Error removing MoldManual file path from the database: " +
			 e.getMessage(), e); }
	  
	  }





	public Optional<NtQuoteList> getQuoteById(Long id) {
		// TODO Auto-generated method stub
	
        return ntQuoteListRepository.findById(id);
    }

	 

}