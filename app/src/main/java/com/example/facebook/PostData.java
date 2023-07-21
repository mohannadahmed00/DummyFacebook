package com.example.facebook;

public class PostData {
    String colorCode;
    String author;
    String time;
    String content;
    int numOfLikes;
    int numOfShares;

    public PostData(String colorCode,String author, String time, String content, int numOfLikes, int numOfShares) {
        this.colorCode = colorCode;
        this.author = author;
        this.time = time;
        this.content = content;
        this.numOfLikes = numOfLikes;
        this.numOfShares = numOfShares;
    }
}
