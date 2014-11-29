package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> childs = new ArrayList<>();

    public TextComposite(){

    }
    public TextComposite(List<TextComponent> childs){
        this.childs = childs;
    }

    public void add(TextComponent child){
        childs.add(child);
    }

    public void remove(TextComponent child){
        childs.remove(child);
    }

    public List<TextComponent> getChilds() {
        return childs;
    }

    public void setChilds(List<TextComponent> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
//        Pattern sentencePattern = Pattern.compile("(\\S.+?[.!?])(?=\\s+|$)");
//        Pattern tokenPattern = Pattern.compile("([\\w':;-]+)|([.,!?])");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= childs.size()-1; i++) {
            if (i!=childs.size()-2)
                stringBuilder.append(childs.get(i).toString()+" ");
            else
                stringBuilder.append(childs.get(i).toString());
        }
        return String.valueOf(stringBuilder).replaceAll("[\\n]{2,}", "\n").replaceAll("[\\s]{2,}", " ");
    }
}