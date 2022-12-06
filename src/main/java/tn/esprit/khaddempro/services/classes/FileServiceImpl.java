package tn.esprit.khaddempro.services.classes;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.khaddempro.DAO.entities.FileEntity;


@Service
public class FileServiceImpl {

	@Autowired
	private tn.esprit.khaddempro.DAO.repository.FileRepository fileRepository;
	
	
	
	public FileEntity saveFile(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileEntity fileData = new FileEntity(fileName, file.getContentType(), file.getBytes());

	    return fileRepository.save(fileData);
	  }

	  public FileEntity getFile(Integer id) {
	    return fileRepository.findById(id).get();
	  }
	  
	  public Stream<FileEntity> getAllFiles() {
	    return fileRepository.findAll().stream();
	  }
	
	
}