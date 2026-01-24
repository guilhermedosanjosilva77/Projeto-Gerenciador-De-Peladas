package com.example.gerenciadordepeladas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciadordepeladas.Entity.JogadorEntity;

public interface JogadorRepository extends JpaRepository <JogadorEntity, Long> {

    
}
