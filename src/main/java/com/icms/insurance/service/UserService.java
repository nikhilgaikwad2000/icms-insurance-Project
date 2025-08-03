package com.icms.insurance.service;

import com.icms.insurance.entity.User;

public interface UserService {

    public String saveUser(User user);

    public String login(String email, String password);

    public User findByEmail (String email);




}
