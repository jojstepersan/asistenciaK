package com.example.jojstepersan.test.Entities;

/**
 * Created by jojstepersan on 9/19/17.
 */

public class Record
    {
    private int id;
    private int computer;
    private int studentId;
    private String studentName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getComputer() {
            return computer;
        }

        public void setComputer(int computer) {
            this.computer = computer;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public Record(int id) {
            this.id = id;
        }

        public Record(int id, int computer, int studentId, String studentName) {
            this.id = id;
            this.computer = computer;
            this.studentId = studentId;
            this.studentName = studentName;
        }
    }
