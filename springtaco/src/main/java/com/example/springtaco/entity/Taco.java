package com.example.springtaco.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {
   private long id;
   private Date createdAt;
   @NotBlank(message = "Name is required")
   @Size(min = 5, message = "Name must be at least 5 characters long")
   private String name;
   @Size(min = 1,message = "You must choose at least 1 ingredient")
   private List<String> ingredients;
}
