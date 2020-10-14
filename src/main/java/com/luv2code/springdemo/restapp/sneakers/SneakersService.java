package com.luv2code.springdemo.restapp.sneakers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


public interface SneakersService {
void upLoadImage(MultipartFile file) throws IOException;
ResponseEntity<byte []> getImageByName(String name);
List<ResponseFile>  getAllImages();
}
