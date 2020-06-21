package com.codeGym.Product.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResult<E> {
    private String code;
    private boolean success;
    private String message = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<E> data;
}
