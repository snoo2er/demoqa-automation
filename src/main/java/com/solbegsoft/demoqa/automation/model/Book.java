package com.solbegsoft.demoqa.automation.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Book {
    private String book;
    private String title;
    private String subTitle;
    private String author;
    @SerializedName("publish_date")
    private String publishDate;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
