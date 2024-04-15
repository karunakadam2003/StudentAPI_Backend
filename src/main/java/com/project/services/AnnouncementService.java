package com.project.services;
//AnnouncementService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.Announcement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AnnouncementService {

 @PersistenceContext
 private EntityManager entityManager;

 @Transactional
 public Announcement createAnnouncement(Announcement announcement) {
     entityManager.persist(announcement);
     return announcement;
 }

 @Transactional(readOnly = true)
 public List<Announcement> getAllAnnouncements() {
     return entityManager.createQuery("SELECT a FROM Announcement a", Announcement.class).getResultList();
 }
}
