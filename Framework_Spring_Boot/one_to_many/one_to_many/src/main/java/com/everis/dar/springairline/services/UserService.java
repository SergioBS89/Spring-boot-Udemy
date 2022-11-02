package com.everis.dar.springairline.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.dar.springairline.entities.User;
import com.everis.dar.springairline.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public List<User> findAll() {

        return iUserRepository.findAll();

    }

    public User findById(Long id) {

        Optional<User> opt = iUserRepository.findById(id);

        if (opt.isEmpty()) {
            return null;
        } else {
            return iUserRepository.findById(id).get();
        }
    }

    public void updateUser(User user, Long id) {

        user = iUserRepository.findById(id).get();

        iUserRepository.save(user);

    }

    public void deleteUser(Long id) {

        User u = iUserRepository.findById(id).get();
        iUserRepository.delete(u);
    }

}