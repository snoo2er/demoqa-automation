package com.solbegsoft.demoqa.automation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserResponse {
    @SerializedName("userID")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String userName;
    @SerializedName("books")
    @Expose
    private List<Book> books;
}
