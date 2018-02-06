package fr.imie.malah.noteapp.utils;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by malah on 20/11/17.
 */

public abstract class CustomTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textChanged();
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public abstract void textChanged();
}
