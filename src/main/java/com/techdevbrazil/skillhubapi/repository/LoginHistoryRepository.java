package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

}
