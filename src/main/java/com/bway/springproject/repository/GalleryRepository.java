package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Integer>{

}
