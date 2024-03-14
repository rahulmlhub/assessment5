package com.ass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long courseId;
   private String courseName;
   private int duration;
   private boolean availability;

}
