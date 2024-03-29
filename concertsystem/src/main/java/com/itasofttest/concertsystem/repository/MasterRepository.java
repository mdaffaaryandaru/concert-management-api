package com.itasofttest.concertsystem.repository;

import com.itasofttest.concertsystem.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository <Master, Integer> {

}
