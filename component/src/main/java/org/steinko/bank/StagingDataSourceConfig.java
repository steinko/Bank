package org.steinko.bank;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("staging")
@Configuration
public class StagingDataSourceConfig {
	
	/**
	 * Get the data source.
	 * @return datasource
	 */
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgres.Driver");
        //CHECKSTYLE:OFF
        dataSourceBuilder.url(
          "jdbc:postgresql://dbinstance24885b8.cquqlhmuebcb"
        + ".eu-north-1.rds.amazonaws.com:5432/mydb"
        );
        //CHECKSTYLE:ON
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("SA");
        return dataSourceBuilder.build();
    }

}