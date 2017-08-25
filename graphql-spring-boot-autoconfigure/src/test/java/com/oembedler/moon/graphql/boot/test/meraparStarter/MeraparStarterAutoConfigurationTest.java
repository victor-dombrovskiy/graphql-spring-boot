package com.oembedler.moon.graphql.boot.test.meraparStarter;

import com.oembedler.moon.graphql.boot.MeraparStarterAutoConfiguration;
import com.oembedler.moon.graphql.boot.test.AbstractAutoConfigurationTest;
import graphql.schema.GraphQLSchema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:java.lang.RuntimeException@gmail.com">oEmbedler Inc.</a>
 */
public class MeraparStarterAutoConfigurationTest extends AbstractAutoConfigurationTest {

    public MeraparStarterAutoConfigurationTest() {
        super(MeraparStarterAutoConfiguration.class);
    }

    @Configuration
    @ComponentScan("com.oembedler.moon.graphql.boot.test.meraparStarter")
    static class BaseConfiguration {
    }

    @Test
    public void appContextLoads() {
        load(BaseConfiguration.class);

        Assert.assertNotNull(this.getContext().getBean(GraphQLSchema.class));
    }
}
