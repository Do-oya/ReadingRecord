package com.study.tobyspring.user.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
public class User {
    String id;
    String name;
    String password;
}
