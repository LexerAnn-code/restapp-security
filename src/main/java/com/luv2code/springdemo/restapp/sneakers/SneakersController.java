package com.luv2code.springdemo.restapp.sneakers;


import com.luv2code.springdemo.restapp.util.Compressor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.composer.Composer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static com.luv2code.springdemo.restapp.util.Compressor.compressBytes;

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
//    public static byte[] compressBytes(byte[] data) {
//        Deflater deflater = new Deflater();
//        deflater.setInput(data);
//        deflater.finish();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//        }
//        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//        return outputStream.toByteArray();
//    }
        // uncompress the image bytes before returning it to the angular application
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
    @GetMapping("/allsneakers")
    public ResponseEntity<List<ResponseFile>> getListFiles(){
      return ResponseEntity.status(HttpStatus.OK).body(sneakersService.getAllImages());

    }

}
