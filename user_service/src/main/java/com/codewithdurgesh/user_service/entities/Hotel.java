package com.codewithdurgesh.user_service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Hotel {
    private Long id;
    private String name;
    private String location;
    private String about;
}
