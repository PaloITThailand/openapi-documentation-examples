package com.paloit.controller.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Error model used for error cases")
public class ErrorModel {

    @Schema(
        description = "Cause of the error",
        example = "User 123"
    )
    private String cause;
    @Schema(
        description = "Cause of the error",
        example = "User not found"
    )
    private String message;

}
