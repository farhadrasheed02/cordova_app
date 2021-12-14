package com.example.simplified;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class list_item  {
    private String head;
    private String desc;


   public list_item(String heading, String description) {
        this.head = heading;
        this.desc = description;

    }
         public String getHead () {
            return head;
        }

        public String getDesc () {
            return desc;
        }
    }