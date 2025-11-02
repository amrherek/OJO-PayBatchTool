package com.atos.paybatch.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    // HikariCP basic settings (defaults for batch processing)
    @Value("${spring.datasource.hikari.minimum-idle:1}")
    private int minimumIdle;

    @Value("${spring.datasource.hikari.maximum-pool-size:3}")
    private int maximumPoolSize; // small pool since no parallelism

    @Value("${spring.datasource.hikari.idle-timeout:300000}") // 5 min
    private long idleTimeout;

    @Value("${spring.datasource.hikari.max-lifetime:1800000}") // 30 min
    private long maxLifetime;

    @Value("${spring.datasource.hikari.connection-timeout:30000}") // 30 sec
    private long connectionTimeout;

    @Value("${spring.datasource.hikari.validation-timeout:5000}") // 5 sec
    private long validationTimeout;

    @Value("${spring.datasource.hikari.keepalive-time:0}") // disable unless needed
    private long keepAliveTime;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        // Basic DB settings
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setUsername(dbUsername);
        hikariConfig.setPassword(dbPassword);
        hikariConfig.setDriverClassName(driverClassName);

        // Pool size: very small, since batch runs serially
        hikariConfig.setMinimumIdle(minimumIdle);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);

        // Timeouts
        hikariConfig.setIdleTimeout(idleTimeout);
        hikariConfig.setMaxLifetime(maxLifetime);
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setValidationTimeout(validationTimeout);

        // Auto-commit disabled; handled explicitly in batch
        hikariConfig.setAutoCommit(false);
        hikariConfig.setPoolName("BatchPaymentHikariPool");

        // Oracle optimizations
        hikariConfig.addDataSourceProperty("oracle.jdbc.fastConnectionValidation", "true");
        hikariConfig.addDataSourceProperty("oracle.jdbc.implicitStatementCacheSize", "50");

        // Keepalive disabled: no need for extra pings since batch runs frequently
        if (keepAliveTime > 0) {
            hikariConfig.setKeepaliveTime(keepAliveTime);
        }

        return new HikariDataSource(hikariConfig);
    }
}
