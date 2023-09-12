package br.com.fiap.challenge.services;

import br.com.fiap.challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServices   {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
