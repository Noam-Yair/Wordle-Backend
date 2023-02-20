package com.wordle.demo.service;

//import com.wordle.demo.dao.WordDAO;
import jakarta.annotation.PostConstruct;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jooq.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.jooq.db.tables.Words.WORDS;


@Service
@PropertySource("classpath:application.properties")
public class DataFillerService {
    String userName = "postgres";
    String password = "password";
    String url = "jdbc:postgresql://127.0.0.1:5432/";

    @Transactional
    public void insertToDB(String word, DSLContext dslContext){

        try {
            dslContext.insertInto(WORDS)
                    .columns(WORDS.WORD)
                    .values(word)
                    .execute();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void fillData() throws SQLException {
        Parser parser = new Parser();
        List<String> all5LetterWords = parser.getAll5LetterWords();
        Connection conn = DriverManager.getConnection(url, userName, password);
        DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
        all5LetterWords.forEach(word -> insertToDB(word, create));

    }

}
