package org.voidmirror.own;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
@EnableR2dbcRepositories
public class Binderr {

    public static void main(String[] args) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(Paths.get("./src/main/resources/schema.sql").toAbsolutePath().toString()));
            System.out.println(bf.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("Hello world!");
        SpringApplication.run(Binderr.class, args);
    }
}