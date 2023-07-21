package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Henry", "Isabella", "John", "Kate", "Liam", "Mia", "Nora", "Oliver", "Penny", "Quinn", "Ryan", "Sophia", "Thomas", "Victoria", "William", "Xander", "Yara", "Zoe"};
    private static final String[] POSTS_ONE_LINE = {"Just had the best meal of my life!", "Can't believe it's already Friday!", "So proud of my team for winning the championship!", "New haircut, new me!", "Feeling grateful for all the love and support in my life!", "Excited to announce my new job!", "Just finished a great book, highly recommend!", "Can't wait to travel again!", "Life is too short to not chase your dreams!", "So happy to be surrounded by such amazing people!"};
    RecyclerView recyclerView;
    ArrayList<PostData> posts;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        posts = new ArrayList<>();
        createDummyPosts();
        adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);
    }

    private void createDummyPosts() {
        for (int i = 0; i < 10; i++) {
            posts.add(new PostData(getRandomColor(), getRandomName(), getRandomNumber(12) + " hrs .", getRandomPost(), getRandomNumber(500), getRandomNumber(300)));
        }
    }

    String getRandomColor() {
        Random random = new Random();
        int color = Color.argb(56, random.nextInt(156), random.nextInt(256), random.nextInt(256));
        return String.format("#%06X", 0xFFFFFF & color);
    }

    String getRandomName() {
        Random random = new Random();
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }

    String getRandomPost() {
        Random random = new Random();
        int index = random.nextInt(POSTS_ONE_LINE.length);
        return POSTS_ONE_LINE[index];
    }

    int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
}