package ru.mirea.lukanina.employeedb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public int salary;
}
