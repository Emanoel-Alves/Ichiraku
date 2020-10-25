package br.ufc.api.Ichirakubackend.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(path = "/upload")
public class Upload {
	
	@Value("${folder}")
	String folder;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> uploadFile(String resource, String id, MultipartFile file) {
		try {
			new FileUtil().uploadFile(file.getInputStream(), folder, resource, id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
