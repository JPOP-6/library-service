package com.library.service.system.clients.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldNameConstants
public class UserDTO extends BaseDTO {

    private String name;

    private String username;

    private String email;

    private String password;

    private LocalDate localDate;
}
