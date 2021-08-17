package cl.grupo8.entrega3.repositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;

@Configuration
public class DatabaseContext {

    @Value("${database.db}")
    private String dbName;

    @Value("${database.port1}")
    private Integer dbPort1;

    //@Value("${database.user}")
    //private String dbUser;

    //@Value("${database.password}")
    //private String dbPass;

    @Bean
    MongoDatabase database(){

        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress("localhost", dbPort1))
                                        //builder.hosts(Arrays.asList(new ServerAddress("hostOne", 27017),new ServerAddress("hostTwo", 27018))
                                ))
                        .build());
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database;

    }

}
