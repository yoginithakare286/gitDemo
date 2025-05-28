package com.yts.revaux.ntQuote.web.rest;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.yts.revaux.ntQuote.dto.NtQuoteDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteList;
import com.yts.revaux.ntQuote.service.NtQuoteListService;

import jakarta.servlet.http.HttpServletResponse;



@RestController

@RequestMapping("/api/ntQuotes") 

public class NtQuoteListController {

   

	private static final Logger logger = LoggerFactory.getLogger(NtQuoteListController.class);

    private final NtQuoteListService ntQuoteListService;



    public NtQuoteListController(NtQuoteListService ntQuoteListService) {

    	this.ntQuoteListService = ntQuoteListService;

    }

    

    // fetch nt quote data

    @GetMapping("/nt-quotes-data")

    public ResponseEntity<List<NtQuoteDTO>> getAllQuotes() {

        logger.info("Fetching all NT Quotes");

        List<NtQuoteDTO> quotes = ntQuoteListService.getAllQuotes();



        if (quotes.isEmpty()) {

            logger.warn(" No NT Quotes found!");

            return ResponseEntity.noContent().build(); // 204 No Content

        }



        return ResponseEntity.ok(quotes); // 200 OK with data

    }

    

    // check Mold Mannual File Exists

    @PostMapping("/checkMoldMannualFileExists")

    public ResponseEntity<Map<String, Boolean>> checkBuyerCadFileExists(

            @RequestParam("id") Long id,

            @RequestParam("fileName") String fileName) {



        logger.info("Checking if Mold Mannual  file exists -> id: {},  fileName: {}", id, fileName);



        // Generate remote file path

        String remoteFilePath = generateRemoteMoldMannualFilePath(id, fileName);

        logger.info("Generated remote file path: {}", remoteFilePath);



        // Check if file exists

        boolean exists = ntQuoteListService.checkMoldMannualFileExists(id,  remoteFilePath);



        logger.info("File existence check result: {}", exists);



        // Prepare response

        Map<String, Boolean> response = new HashMap<>();

        response.put("exists", exists);



        return ResponseEntity.ok(response);

    }

    

    private String generateRemoteMoldMannualFilePath(Long id, String fileName) {

		logger.info("generate Remote Mold Mannual File Path id = " + id + " fileName = " + fileName);

		String remoteBasePath = "/home/CPS/NtQuote/MoldManual/";

		String currentPath = remoteBasePath + id ;

		logger.info("currentPath  = " + currentPath);

		return currentPath + "/" + fileName;

	}

    

   // upload Mold Manual File

    @PostMapping("/uploadMoldManualFile")

    public ResponseEntity<Map<String, Object>> uploadMoldManualFile(

            @RequestParam("files") MultipartFile[] files, 

            @RequestParam("id") Long id) throws IOException {



        logger.info("id in uploadMoldManualFile: {}", id);

        logger.info("files in uploadMoldManualFile: {}", Arrays.toString(files));



        if (files.length == 0) {

            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "No files provided"));

        }



        for (MultipartFile file : files) {

            if (file.isEmpty()) {

                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Empty file provided"));

            }



            byte[] fileBytes = file.getBytes();

            String fileName = file.getOriginalFilename();

            ntQuoteListService.uploadMoldManualFile(fileBytes, fileName, id);

        }



        return ResponseEntity.ok(Map.of("success", true, "message", "Files uploaded successfully"));

    }



    

    // Overwrite mold mannual file

    @ResponseBody

    @PostMapping("/overwriteMoldManualAttachment")

    public String updateOverwriteBuyerAttachCadFile(@RequestParam("files") MultipartFile[] files,

                                                    @RequestParam("id") Long id) throws IOException {

        logger.error("Controller -- overwrite mold mannual File id ===== " + id);

        logger.info("overwrite Mold Mannual File line  ===== " + id);



        for (MultipartFile file : files) {

            if (file.isEmpty()) {

                return "Empty Mold Mannual file provided";

            }



            byte[] fileBytes = file.getBytes();

            String fileName = file.getOriginalFilename();

            ntQuoteListService.overwriteMoldManualAttachment(fileBytes, fileName, id);

        }



        return "Mold Mannual  Files overwritten successfully for line: " + id;

    }

    

    private static final String REMOTE_MOLD_FILE_BASE_PATH = "/home/CPS/NtQuote/MoldManual/";
    private static final String SFTP_HOST = "192.168.1.203";
    private static final int SFTP_PORT = 22;
    private static final String SFTP_USER = "ytsolutions";
    private static final String SFTP_PASSWORD = "yts123#";
    
    @GetMapping("/downloadMoldManualFile")
    public void downloadMoldManualFile(@RequestParam("id") String id, @RequestParam("filePath") String filePath, HttpServletResponse response) throws IOException {
        logger.info("Downloading Mold Manual file - filePath: {}", filePath);

        // Decode file path in case of special characters
        String decodedFilePath = java.net.URLDecoder.decode(filePath, "UTF-8");
        logger.info("Decoded filePath: {}", decodedFilePath);

        // Extract file name
        String fileName = new File(decodedFilePath).getName();
        
        // Construct full SFTP file path
        String remoteFilePath = REMOTE_MOLD_FILE_BASE_PATH + "/" + id + "/" + fileName;
        logger.info("Remote Mold Manual file path: {}", remoteFilePath);

        // Set response headers for file download
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        try {
            // Establish SFTP connection
            JSch jsch = new JSch();
            Session session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
            session.setPassword(SFTP_PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            // Download file via SFTP
            InputStream inputStream = sftpChannel.get(remoteFilePath);
            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            // Close SFTP connection
            sftpChannel.disconnect();
            session.disconnect();

            logger.info("Mold Manual file downloaded successfully: {}", fileName);

        } catch (Exception e) {
            logger.error("Error downloading Mold Manual file: {}", e.getMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error downloading file: " + e.getMessage());
        }
    }

    // delete mold manual file
     @PostMapping("/deleteMoldManualFile")
   //  public void downloadMoldManualFile(@RequestParam("id") String id, @RequestParam("filePath") String filePath, HttpServletResponse response) throws IOException {

     public ResponseEntity<String> deleteMoldManualFile(@RequestBody Map<String, String> formData) {
 		String filePath = formData.get("filePath");
 	//	Long id = formData.get("id");
 		 // Convert "id" to Long
         Long id;
         try {
             id = Long.parseLong(formData.get("id"));
         } catch (NumberFormatException e) {
             logger.error("Invalid ID format: {}", formData.get("id"));
             return ResponseEntity.badRequest().body("Invalid ID format.");
         }

 		logger.error("In delete Mold Manual File controller");

 		logger.info("Received id: " + id);

 		String decodedFilePath;
 		try {
 			decodedFilePath = java.net.URLDecoder.decode(filePath, "UTF-8");
 		} catch (UnsupportedEncodingException e) {
 			logger.error("Error decoding  Mold Manual File path: " + e.getMessage(), e);
 			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error decoding cad file path");
 		}

 		String remoteFilePath = decodedFilePath;
 		logger.info("Remote  Mold Manual file path = " + remoteFilePath);

 		try {
 			JSch jsch = new JSch();
 			Session session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
 			session.setPassword(SFTP_PASSWORD);
 			session.setConfig("StrictHostKeyChecking", "no");
 			session.connect();

 			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
 			sftpChannel.connect();

 			try {
 				sftpChannel.lstat(remoteFilePath);
 				sftpChannel.rm(remoteFilePath);
 				logger.info(" Mold Manual File deleted from server: " + remoteFilePath);
 			} catch (SftpException e) {
 				if (e.id == ChannelSftp.SSH_FX_NO_SUCH_FILE) {
 					logger.error(" Mold Manual File not found on the server: " + remoteFilePath);
 				} else {
 					throw e;
 				}
 			} finally {
 				sftpChannel.disconnect();
 				session.disconnect();
 			}

 			ntQuoteListService.removeMoldManualFile(id, remoteFilePath);

 			return ResponseEntity.ok(" Mold Manual File (if present) and its path removed successfully.");
 		} catch (Exception e) {
 			logger.error("Error deleting  Mold Manual file or removing path: " + e.getMessage(), e);
 			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the request");
 		}
 	}
     

     @GetMapping("/getQuoteById")
     public ResponseEntity<?> getQuoteById(@RequestParam Long id) {
         Optional<NtQuoteList> quote = ntQuoteListService.getQuoteById(id);
         if (quote.isPresent()) {
             return ResponseEntity.ok(quote.get());
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body(Collections.singletonMap("error", "Quote not found"));
         }
     }

}