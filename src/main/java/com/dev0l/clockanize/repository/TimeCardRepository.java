package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Integer> {

}