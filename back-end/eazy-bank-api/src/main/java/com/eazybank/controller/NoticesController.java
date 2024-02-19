package com.eazybank.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.eazybank.entity.Notice;
import com.eazybank.service.NoticesService;
import com.eazybank.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = Constants.ALLOWED_ORIGIN)
public class NoticesController {

    private final NoticesService service;

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(service.getNotices());
    }

}
