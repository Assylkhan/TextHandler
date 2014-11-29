package com.epam.action;

import com.epam.entity.TextComponent;
import com.epam.entity.TextComposite;

import java.util.*;
import java.util.regex.Pattern;

public class Action {

    public static TextComposite removeFromText(TextComposite text, int wordLength){
        TextComposite newText = new TextComposite();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants", Locale.getDefault());
        Pattern p = Pattern.compile(resourceBundle.getString("consonants"));
        for (TextComponent sentence : text.getChilds()){
            TextComposite newSentence = new TextComposite();
            TextComposite convertedSentence = (TextComposite) sentence;
            for (TextComponent token : convertedSentence.getChilds()){
                if (!(token.toString().length() == wordLength && p.matcher(token.toString()).find()))
                    newSentence.add(token);
            }
            newText.add(newSentence);
        }
        return newText;
    }
}