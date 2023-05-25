package com.companyname.earl.photozclone.web;

import com.companyname.earl.photozclone.model.Photo;
import com.companyname.earl.photozclone.service.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
//REST stands for Representational State Transfer, Used to create stateless reliable web APIs -
// Application Programming Interface - API -
public class PhotozController {

    //@Autowired // Has the same effect as the constructor beneath
    private final PhotozService photozService;
    public PhotozController(/*@Autowired*/PhotozService photozService){
        this.photozService = photozService;
    }
    //private List<Photo> db = List.of(new Photo("1", "hello.jpg"));
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photozService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return photozService.get(id);
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
