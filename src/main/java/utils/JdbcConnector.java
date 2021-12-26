package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcConnector {

    private static final Logger LOGGER = LogManager.getLogger(JdbcConnector.class.getName());
    private static JdbcTemplate jdbcTemplate;

    private static DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ConfProperties.getProperty("jdbc_driver"));
        dataSource.setUrl(ConfProperties.getProperty("db_url"));
        dataSource.setUsername(ConfProperties.getProperty("db_username"));
        dataSource.setPassword(ConfProperties.getProperty("db_password"));
        return dataSource;
    }

    private JdbcConnector() {
        throw new IllegalStateException();
    }

    public static JdbcTemplate getJdbcTemplate() {
        try {
            jdbcTemplate = new JdbcTemplate(mysqlDataSource());
        } catch (Exception e) {
            LOGGER.error("Error connecting to database");
        }
        return jdbcTemplate;
    }

}
