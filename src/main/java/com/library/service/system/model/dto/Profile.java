package com.library.service.system.model.dto;

import com.library.service.system.clients.dto.BaseDTO;
import com.library.service.system.clients.dto.BookDTO;
import com.library.service.system.clients.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldNameConstants
public class Profile extends BaseDTO {
    private UserDTO userDTO;

    private List<BookDTO> books;
}
