package com.oniamey.exam.repository;

import com.oniamey.exam.entity.CaSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, Integer> {
}
