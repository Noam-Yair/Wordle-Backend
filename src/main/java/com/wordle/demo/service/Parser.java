package com.wordle.demo.service;

import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public List<String> getAll5LetterWords(){
        List<String> retList = new ArrayList<>();
        try {
            File nounsObj = new File("src/main/resources/nouns.txt");
            Scanner nounsReader = new Scanner(nounsObj);
            while (nounsReader.hasNextLine()) {
                String data = nounsReader.nextLine();
                String[] split = data.split("\t");
                if (split[0].length()==5)
                    retList.add(split[0]);
            }
            File verbsObj = new File("src/main/resources/verbs.txt");
            Scanner verbsReader = new Scanner(verbsObj);
            while (verbsReader.hasNextLine()) {
                String data = verbsReader.nextLine();
                String[] split = data.split("\t");
                if (split[0].length()==5)
                    retList.add(split[0]);
            }
            File adjObj = new File("src/main/resources/adjectives.txt");
            Scanner adjReader = new Scanner(adjObj);
            while (adjReader.hasNextLine()) {
                String data = adjReader.nextLine();
                String[] split = data.split("\t");
                if (split[0].length()==5)
                    retList.add(split[0]);
            }
            nounsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return retList;
    }
}
