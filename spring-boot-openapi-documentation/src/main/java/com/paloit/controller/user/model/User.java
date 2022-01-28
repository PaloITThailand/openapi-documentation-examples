package com.paloit.controller.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Schema(description = "User resource")
public class User {

    @Schema(
        description = "User ID",
        example = "11",
        accessMode = AccessMode.READ_ONLY
    )
    @Range
    private Long id;

    @Schema(
        description = "Username",
        example = "username"
    )
    @NotEmpty
    private String username;

    @Schema(
        description = "First name",
        example = "Elvis"
    )
    @NotEmpty
    private String firstName;

    @Schema(
        description = "Last name",
        example = "Presley"
    )
    @NotEmpty
    private String lastName;

    @Schema(
        description = "Email",
        example = "elvis.presley@palo-it.com"
    )
    @Email
    @NotNull
    private String email;


}

