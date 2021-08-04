package id.co.bca.magenta.api.merchantcare.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import id.co.bca.magenta.api.merchantcare.MainApp;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses=MainApp.class)
public class DbConfig {
	private static final Logger logger = LoggerFactory.getLogger(DbConfig.class);

	@Bean
	public DataSource dataSourceEmsmh() throws SQLException {
		SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(StaticVariable.getProp("ems.db.emsmh.username"));
        dataSource.setPassword(StaticVariable.getProp("ems.db.emsmh.password"));
        dataSource.setServerName(StaticVariable.getProp("ems.db.emsmh.host"));
        dataSource.setPortNumber(Integer.parseInt(StaticVariable.getProp("ems.db.emsmh.port")));
        dataSource.setDatabaseName(StaticVariable.getProp("ems.db.emsmh.catalog"));

        return dataSource;
	}

	@Bean
	public DataSource dataSourceEms() throws SQLException {
		SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(StaticVariable.getProp("ems.db.ems.username"));
        dataSource.setPassword(StaticVariable.getProp("ems.db.ems.password"));
        dataSource.setServerName(StaticVariable.getProp("ems.db.ems.host"));
        dataSource.setPortNumber(Integer.parseInt(StaticVariable.getProp("ems.db.ems.port")));
        dataSource.setDatabaseName(StaticVariable.getProp("ems.db.ems.catalog"));

        return dataSource;
	}
	
	@Bean
	public DataSource dataSourceMagenmc() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(StaticVariable.getProp("magenta.db.magenmc.url"));
		dataSource.setUser(StaticVariable.getProp("magenta.db.magenmc.username"));
		dataSource.setPassword(StaticVariable.getProp("magenta.db.magenmc.password"));
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		
		return dataSource;
	}
	
	@Bean
	public DataSource dataSourceMagenms() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(StaticVariable.getProp("magenta.db.magenms.url"));
		dataSource.setUser(StaticVariable.getProp("magenta.db.magenms.username"));
		dataSource.setPassword(StaticVariable.getProp("magenta.db.magenms.password"));
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager txManagerEmsmh(
    		@Qualifier("dataSourceEmsmh") DataSource dataSource) throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager txManagerEms(
    		@Qualifier("dataSourceEms") DataSource dataSource) throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager txManagerMagenmc(
    		@Qualifier("dataSourceMagenmc") DataSource dataSource) throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager txManagerMagenms(
    		@Qualifier("dataSourceMagenms") DataSource dataSource) throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplateEmsmh(
    		@Qualifier("dataSourceEmsmh") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplateEms(
    		@Qualifier("dataSourceEms") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplateMagenmc(
    		@Qualifier("dataSourceMagenmc") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplateMagenms(
    		@Qualifier("dataSourceMagenms") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}
