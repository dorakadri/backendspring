package tn.esprit.khaddempro.Controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.khaddempro.DAO.entities.FileEntity;
import tn.esprit.khaddempro.modals.ResponseData;
import tn.esprit.khaddempro.modals.ResponseMessage;
import tn.esprit.khaddempro.services.classes.FileServiceImpl;

@RestController
@RequestMapping("")

@CrossOrigin(exposedHeaders = {"Content-Disposition","Access-Control-Allow-Credentials"})
public class FileController {

	@Autowired
	  private FileServiceImpl fileServiceImpl;

	  @PostMapping("/upload")
	  public Integer uploadFile(@RequestParam("filef") MultipartFile file) {
	
	    try {
	    	FileEntity fileres=fileServiceImpl.saveFile(file);
	   
	
	      return fileres.getId();
	    } catch (Exception e) {
	    
	      return -1 ;
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseData>> getListFiles() {
	    List<ResponseData> files = fileServiceImpl.getAllFiles().map(fileData -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(fileData.getId().toString())
	          .toUriString();

	      return new ResponseData(
	    	  fileData.getName(),
	          fileDownloadUri,
	          fileData.getType(),
	          fileData.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
		  FileEntity fileData = fileServiceImpl.getFile(id);
		
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileData.getName())
		        .body(fileData.getData());
		  }
	
}