package com.example.playground.controller;

import com.example.playground.async.CountingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/count")
public class CountingController {

  private final CountingService countingService;

  @GetMapping
  public boolean startCount() {
    for (int i = 0; i < 3; i++) {
      countingService.aysnced();
    }
    return true;
  }
}
