package com.garinetiquetas.apilcrst.repository;

import com.garinetiquetas.apilcrst.entity.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios,Integer>{

  
    
}
