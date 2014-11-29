package com.epam.runner;

import com.epam.textHandler.TextHandler;
import com.epam.action.Action;
import com.epam.entity.TextComposite;
import com.epam.fileHandling.FileHandling;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Runner {
    private static Logger logger = Logger.getLogger(Runner.class);
    public static void main(String[] args) {

        TextComposite text = new TextComposite();
        TextComposite changedText = new TextComposite();
        try {
            text = TextHandler.parse(FileHandling.read("text.txt"));
            changedText = Action.removeFromText(text, 3);
            FileHandling.write(text, "D:/newText.txt");
        } catch (IOException e){
            logger.debug(e);
        } catch (NullPointerException e){
            logger.debug(e);
        } catch (Exception e){
            logger.debug(e);
        }
        logger.info(text);
        logger.info(changedText);
        System.out.println(text);
    }
}
