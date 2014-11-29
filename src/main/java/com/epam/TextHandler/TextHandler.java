package com.epam.TextHandler;

import com.epam.entity.TextComponent;
import com.epam.entity.TextComposite;
import com.epam.entity.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {
    public static TextComposite parse(StringBuilder stringBuilder) throws NullPointerException {
        Pattern p = Pattern.compile("(\\S.+?[.!?])(?=\\s+|$)");
        Matcher sentenceMatcher = p.matcher(stringBuilder);
        TextComposite text = new TextComposite();
        while (sentenceMatcher.find()) {
            TextComposite newSentence = new TextComposite();
            Matcher tokenMatcher = Pattern.compile("([\\w':;-]+)|([.,!?])").matcher(sentenceMatcher.group());
            while (tokenMatcher.find()) {
                Token token = new Token(tokenMatcher.group());
                newSentence.add(token);
            }
            text.add(newSentence);
        }
        return text;
    }
}