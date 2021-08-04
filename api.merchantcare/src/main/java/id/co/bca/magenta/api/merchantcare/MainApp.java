package id.co.bca.magenta.api.merchantcare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class MainApp extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApp.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(/*@Value("${springdoc.version}") String appVersion*/) {		
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("MAGENTA REST API").version("2.0")
						.description("REST API for BCA Magenta")
						.contact(new Contact()
                                .name("Cosmas Dedy Kurniawan"))
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
