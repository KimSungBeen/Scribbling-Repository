package org.gwnu.tutorial.user;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import org.gwnu.tutorial.BR;

public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
