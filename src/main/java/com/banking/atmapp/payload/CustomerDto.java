package com.banking.atmapp.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerDto {
    private String username;
    private Integer salary;
    private String permitDay;
}
