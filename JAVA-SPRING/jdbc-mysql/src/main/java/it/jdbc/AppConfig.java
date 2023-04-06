package it.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("it.jdbc")
public class AppConfig {
    @Bean
    public DataSource getDataSource()
    {
        // Posto dove sono salvate informazioni > nel nostro caso un db. Un progetto
        // può dialogare con più db, con getDataSource() specifichiamo con quale db deve 
        // comunicare.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcmysql");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean JdbcTemplate getJdbcTemplate()
    {
        // Connessione che apre un canale di comunicazione con il db. Tutte 
        // le operazioni (creare, update, destroy, ...) passano per mezzo di 
        // jbdctemplate > gestisce le risorse per comunicare con il db. 
        return new JdbcTemplate(getDataSource());
    }
}
