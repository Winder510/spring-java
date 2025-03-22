package com.winder.dto.request.user;

import com.winder.enums.ErrorCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    private String userName;

    @Size(min = 8, message = "INVALID_PASSWORD")
    private String userPassword;

    @Email(message = "INVALID_EMAIL")
    private String userEmail;
}
