package com.biokes.apiBank.services;

import com.biokes.apiBank.services.interfaces.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private SongService songService;
    @Test
    @Sql(scripts = {"/db/localTrends.sql"})
    void testThatAllLocalSongsCanBeGotten(){
        assertEquals(4,songService.getLocalTrends().size());
    }
}
