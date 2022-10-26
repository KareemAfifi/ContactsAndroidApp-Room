package com.example.contactapproom.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.contactapproom.db.entity.Contact;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactsAppDatabase extends RoomDatabase {
    //Linking DAO to Database

    public abstract ContactDAO getContactDAO();


}
