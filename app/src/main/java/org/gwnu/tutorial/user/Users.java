package org.gwnu.tutorial.user;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.util.Observable;

public class Users {
    ObservableField<String> name = new ObservableField<>();
    ObservableInt age = new ObservableInt();
    ObservableBoolean isConfirm = new ObservableBoolean();

    public Users(String name, int age, boolean isConfirm) {
        this.name.set(name);
        this.age.set(age);
        this.isConfirm.set(isConfirm);
    }
}
