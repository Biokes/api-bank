package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
