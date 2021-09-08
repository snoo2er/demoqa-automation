package com.solbegsoft.demoqa.automation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    @SerializedName("userName")
    @Expose
    private String login;
    @NonNull
    @SerializedName("password")
    @Expose
    private String password;
}
