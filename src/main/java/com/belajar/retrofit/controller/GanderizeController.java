package com.belajar.retrofit.controller;


import com.belajar.retrofit.dto.BaseResponse;
import com.belajar.retrofit.service.GenderizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ganderize")
public class GanderizeController {
    private final GenderizeService genderizeService;

    public GanderizeController(GenderizeService genderizeService) {
        this.genderizeService = genderizeService;
    }

    @GetMapping("/{name}")
    public BaseResponse getGender(@PathVariable String name) throws IOException {
        return genderizeService.getGender(name);
    }
}
