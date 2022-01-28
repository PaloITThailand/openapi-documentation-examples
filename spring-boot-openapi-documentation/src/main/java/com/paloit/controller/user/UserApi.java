package com.paloit.controller.user;

import com.paloit.controller.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "User API", description = "API to perform CRUD operations on users")
public interface UserApi {

    @Operation(summary = "Retrieves all users")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Users successfully retrieved")
        }
    )
    ResponseEntity<List<User>> getUsers();

    @Operation(summary = "Retrieves user by ID")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "User successfully retrieved"),
            @ApiResponse(
                responseCode = "404",
                description = "User not found"
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    ResponseEntity<User> getUserById(
        @Parameter(
            description = "User ID",
            example = "123"
        ) Long userId
    );

    @Operation(summary = "Delete user by ID")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "User successfully deleted"),
            @ApiResponse(
                responseCode = "404",
                description = "User not found"
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    ResponseEntity<User> deleteUserById(
        @Parameter(description = "User ID", example = "123") Long userId
    );

    @Operation(summary = "Creates a new user")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "User successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    ResponseEntity<User> createUser(@Parameter User user);

    @Operation(summary = "Update an existing user")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "User successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    ResponseEntity<User> updateUserById(
        @Parameter(description = "User ID", example = "123") Long userId,
        @Parameter User userUpdate
    );

}
