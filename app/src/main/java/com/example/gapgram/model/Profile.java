package com.example.gapgram.model;


public class Profile {
    private Long _id;
    private String firstname;
    private String lastname;
    private String email;

    // سازنده بدون پارامتر
    public Profile() {
    }

    // سازنده با پارامترها
    public Profile(Long _id, String firstname, String lastname, String email) {
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    // Getter و Setter برای _id
    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    // Getter و Setter برای firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter و Setter برای lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter و Setter برای email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // نمایش اطلاعات برای Debugging یا Logging
    @Override
    public String toString() {
        return "ProfileForm{" +
                "_id=" + _id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
