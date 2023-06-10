package com.food.order.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDTO {

    private Long id;
    @NotBlank(message = "fist name must not be blank")
    private String firstName;
    @NotBlank (message = "last name must not be blank")
    private String lastName;
    @NotBlank (message = "email must not be blank")
    private String email;
}
