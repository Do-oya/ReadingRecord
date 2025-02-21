package com.study.tobyspring.user.service;

import com.study.tobyspring.user.dao.UserDao;
import com.study.tobyspring.user.domain.Level;
import com.study.tobyspring.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void upgradeLevels() {
        User user = userDao.get("baby");
        boolean changed;
        if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
            user.setLevel(Level.SILVER);
            changed = true;
        }
        else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
            user.setLevel(Level.GOLD);
            changed = true;
        }
        else if (user.getLevel() == Level.GOLD) {
            changed = false;
        }
        else {
            changed = false;
        }
        if (changed) {
            userDao.update(user);
        }
    }
}
