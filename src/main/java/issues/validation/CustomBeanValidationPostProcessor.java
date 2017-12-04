package issues.validation;

import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

import java.lang.annotation.ElementType;

import javax.validation.Configuration;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.TraversableResolver;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * Taken from CAS as is https://github.com/apereo/cas/blob/master/core/cas-server-core-util-api/src/main/java/org/apereo/cas/util/spring/CustomBeanValidationPostProcessor.java
 */
public class CustomBeanValidationPostProcessor extends BeanValidationPostProcessor {

    /**
     * Instantiates a new custom bean validation post processor.
     */
    public CustomBeanValidationPostProcessor() {
        setAfterInitialization(true);
        final Configuration<?> configuration = Validation.byDefaultProvider().configure();
        configuration.traversableResolver(new TraversableResolver() {

            @Override
            public boolean isReachable(final Object traversableObject, final Node traversableProperty,
                                       final Class<?> rootBeanType,
                                       final Path pathToTraversableObject, final ElementType elementType) {
                return true;
            }

            @Override
            public boolean isCascadable(final Object traversableObject, final Node traversableProperty,
                                        final Class<?> rootBeanType,
                                        final Path pathToTraversableObject, final ElementType elementType) {
                return true;
            }
        });

        final Validator validator = configuration.buildValidatorFactory().getValidator();
        setValidator(validator);

    }
}