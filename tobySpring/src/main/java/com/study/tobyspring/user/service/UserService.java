package com.study.tobyspring.user.service;

import com.study.tobyspring.user.dao.UserDao;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

}
