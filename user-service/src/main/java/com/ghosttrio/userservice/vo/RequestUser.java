package com.ghosttrio.userservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestUser(
        String email,
        String name,
        String pwd
) {
}
