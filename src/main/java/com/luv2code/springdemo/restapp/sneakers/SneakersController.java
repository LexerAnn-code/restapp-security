package com.luv2code.springdemo.restapp.sneakers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;


@RestController
@RequestMapping("sneakers_img")
public class SneakersController {
    @Autowired
    SneakersService sneakersService;
    @Autowired
    static byte[] compressBytes;


    @PostMapping
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        sneakersService.upLoadImage(file);
}

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]>  getImage(@PathVariable("imageName") String imageName) throws IOException {
        return sneakersService.getImageByName(imageName);

    }

    @GetMapping("/allsneakers")
    public ResponseEntity<List<ResponseFile>> getListFiles(){
      return ResponseEntity.status(HttpStatus.OK).body(sneakersService.getAllImages());

    }

}
