package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDetails {
    private String accountId;
    private String accountEmail;
    private String role;
}
