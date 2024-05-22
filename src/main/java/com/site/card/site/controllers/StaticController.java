package com.site.card.site.controllers;

import com.site.card.site.dto.PalImage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/static")
public class StaticController {

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(value = "/pal/{name}")
    @ResponseStatus(HttpStatus.OK)
    public PalImage getPalImgUrl() {
        return new PalImage("http://localhost:8080/lamball.jpg");
    }
}
