package org.example.userwork.service;

import lombok.RequiredArgsConstructor;
import org.example.userwork.dto.UserRequest;
import org.example.userwork.dto.UserResponse;
import org.example.userwork.entity.User;
import org.example.userwork.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    //생성
    @Transactional
    public UserResponse save(UserRequest  userRequest) {
        User user=new User(userRequest.getName(), userRequest.getEmail(), userRequest.getAge());
        User saveuser =userRepository.save(user);

        return new UserResponse(
                saveuser.getId(),saveuser.getName(),saveuser.getEmail(),saveuser.getAge()
        );
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 사람 없어")
        );
        return new UserResponse(
                user.getId(),user.getName(),user.getEmail(),user.getAge()
        );
    }

    //전체 조회
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail(),user.getAge());
            userResponseList.add(userResponse);
        }
        return userResponseList;
    }

    //단건
    @Transactional
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(
                 () -> new IllegalArgumentException("그런 사람이 없쓰요~")
        );
        user.updateUser(userRequest.getName(), userRequest.getEmail(), userRequest.getAge());
        return new UserResponse(user.getId(),user.getName(),user.getEmail(),user.getAge());
   }

   @Transactional
    public void deleteUser(Long id) {
       User user = userRepository.findById(id).orElseThrow(
               () -> new IllegalArgumentException("그런 사람이 없쓰요~")
       );
       userRepository.delete(user);

   }
}
