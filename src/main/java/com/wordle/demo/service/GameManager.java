package com.wordle.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.jooq.db.tables.Words.WORDS;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@Slf4j
public class GameManager {
    @Autowired
    DSLContext dslContext;

    @GetMapping("/random")
    public String greeting() {
        int randomNumber = (int) (Math.random() * 386);
        List<String> fetch = (List<String>) dslContext.select(WORDS.WORD).from(WORDS).where(WORDS.ID.eq(randomNumber)).fetch(0);
        return fetch.get(0);
    }
}