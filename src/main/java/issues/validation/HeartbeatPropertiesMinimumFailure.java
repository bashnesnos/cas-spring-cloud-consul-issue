package issues.validation;

import javax.annotation.PostConstruct;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

/**
 *
 * Taken from spring cloud consul https://github.com/spring-cloud/spring-cloud-consul/blob/master/spring-cloud-consul-discovery/src/main/java/org/springframework/cloud/consul/discovery/HeartbeatProperties.java
 *
 */

@Validated
public class HeartbeatPropertiesMinimumFailure {

    boolean enabled = false;

    @Min(1)
    private int ttlValue = 30;

    @NotNull
    private String ttlUnit = "s";

    @DecimalMin("0.1")
    @DecimalMax("0.9")
    private double intervalRatio = 2.0 / 3.0;

    @PostConstruct
    public void init() {

    }

    public String getTtl() {
        return ttlValue + ttlUnit;
    }
}
