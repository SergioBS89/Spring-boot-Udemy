
package com.everis.dar.springairline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.dar.springairline.entities.User;

public interface IUserRepository extends JpaRepository<User,Long>{
    
}