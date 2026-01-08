package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

}
