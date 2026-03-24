package sheridan.tetervak.cardata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;

@Configuration
public class ValidationConfig implements RepositoryRestConfigurer {

    private final Validator validator; // This is the default Hibernate Validator bean

    public ValidationConfig(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        // Registering the validator to trigger for specific events
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }
}
