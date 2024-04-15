package com.project.controller;
//AnnouncementController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.entities.Announcement;
import com.project.services.AnnouncementService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AnnouncementController {

 private final AnnouncementService announcementService;

 @Autowired
 public AnnouncementController(AnnouncementService announcementService) {
     this.announcementService = announcementService;
 }

 @PostMapping("/createAnnouncement")
 public ResponseEntity<Announcement> createAnnouncement( @RequestBody Announcement announcement) {
     Announcement createdAnnouncement = announcementService.createAnnouncement(announcement);
     return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
 }

 @GetMapping("/getAllAnnouncements")
 public ResponseEntity<List<Announcement>> getAllAnnouncements() {
     List<Announcement> announcements = announcementService.getAllAnnouncements();
     return new ResponseEntity<>(announcements, HttpStatus.OK);
 }
}
