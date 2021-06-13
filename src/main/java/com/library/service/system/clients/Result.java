package com.library.service.system.clients;

import com.library.service.system.clients.dto.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class Result<T extends BaseDTO> {
    private boolean isSuccess;
    private String error;
    private List<T> data;
}
