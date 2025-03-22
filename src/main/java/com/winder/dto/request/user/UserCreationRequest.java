package com.winder.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreationRequest {
    private String userName;

    @Size(min = 8, message = "Password must be at least 8 charaters")
    private String userPassword;

    @Email(message = "Email not in the right format")
    private String userEmail;
}
