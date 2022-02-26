package com.eep.repository;

import com.eep.entity.Coches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("cocheJpaRepository")
public interface CocheJPARepository extends JpaRepository <Coches,Serializable> {

}
