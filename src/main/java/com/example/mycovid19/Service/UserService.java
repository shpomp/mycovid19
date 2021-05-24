package com.example.mycovid19.Service;

import com.example.mycovid19.DTO.UserDTO;
import com.example.mycovid19.Model.User;
import com.example.mycovid19.Model.UserContactData;
import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder BCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserDetails userDetails = userRepository.findByEmail(email).getUserCredentials();
    return userDetails;
  }

  public boolean signUpUser(UserDTO userDTO) {
    String encodedPassword = BCryptPasswordEncoder.encode(userDTO.getPassword());
    User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDateOfBirth(),
        new UserContactData(userDTO.getPhoneNumber(), userDTO.getStreetName(), userDTO.getHomeNumber(),
            userDTO.getDistrict()),
        new UserCredentials(userDTO.getEmail(), encodedPassword));
    return userRepository.addUser(user);
  }
}
