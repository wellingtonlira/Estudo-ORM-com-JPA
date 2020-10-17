package com.example.projetojpa3;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @GetMapping
    public ResponseEntity getUm() {
        return ResponseEntity.ok(1);
    }

    @GetMapping(value = "/imagem-loka", produces = "image/jpg")
    @ResponseBody
    public ResponseEntity getImagem() {
        return ResponseEntity.ok("só que não");
    }

    @GetMapping(value = "/zip-loko", produces = "application/x-7z-compressed")
    @ResponseBody
    public ResponseEntity getZip() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("content-Disposition", "attachment; filename=lokao.zip");

        return new ResponseEntity("conteud Zip fake", headers, HttpStatus.OK);
    }
}
