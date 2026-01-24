package com.example.gerenciadordepeladas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciadordepeladas.Entity.TimeEntity;

public interface TimeRepository extends JpaRepository <TimeEntity,Long>{
    

}
