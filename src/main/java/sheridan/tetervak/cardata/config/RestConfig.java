package sheridan.tetervak.cardata.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import sheridan.tetervak.cardata.data.Car;
import sheridan.tetervak.cardata.data.Owner;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(@NonNull RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Owner.class);
        config.exposeIdsFor(Car.class);

        cors.addMapping("/**")
                .allowedOriginPatterns("http://localhost:*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
    }
}
