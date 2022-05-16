package com.devphub.repository;

import com.devphub.model.NameTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameTagRepository extends JpaRepository<NameTag, Long> {

}
