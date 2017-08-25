package com.oembedler.moon.graphql.boot;

import com.merapar.graphql.GraphQlFields;
import com.merapar.graphql.GraphQlProperties;
import com.merapar.graphql.schema.GraphQlSchemaBuilderImpl;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Andrew Potter
 */
@Configuration
@ConditionalOnClass(GraphQlFields.class)
@EnableConfigurationProperties(GraphQlProperties.class)
public class MeraparStarterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(GraphQlFields.class)
    GraphQlSchemaBuilderImpl schemaBuilder(GraphQlProperties properties, List<GraphQlFields> fields) {
        return new GraphQlSchemaBuilderImpl(properties, fields);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(GraphQlSchemaBuilderImpl.class)
    GraphQLSchema schema(GraphQlSchemaBuilderImpl schemaBuilder) {
        schemaBuilder.postConstruct();
        return schemaBuilder.getSchema();
    }
}
