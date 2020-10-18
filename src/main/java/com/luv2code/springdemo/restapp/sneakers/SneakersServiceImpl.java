package com.luv2code.springdemo.restapp.sneakers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@Service
public class SneakersServiceImpl implements SneakersService {
    @Autowired
    SneakersRepository sneakersRepository;



    @Override
    public void upLoadImage(MultipartFile file) throws IOException {
SneakersModel sneakersModel=new SneakersModel();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       sneakersModel.setName(fileName);
        sneakersModel.setType_img(file.getContentType());
        sneakersModel.setPicByte(file.getBytes());
        sneakersRepository.save(sneakersModel);

    }
    @Override
    public List<ResponseFile> getAllImages() {
           Stream<SneakersModel> allImages=sneakersRepository.findAll().stream();

        List<ResponseFile> files = allImages.map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/sneakers_img/")
                    .path(dbFile.getName())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType_img(),
                    dbFile.getPicByte().length);
        }).collect(Collectors.toList());

        return files;
    }

    @Override
    public ResponseEntity<byte []>  getImageByName(String name) {

      SneakersModel allImages=sneakersRepository.findByName(name);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + allImages.getName() + "\"")
                .body(allImages.getPicByte());

    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
