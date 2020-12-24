package dev.ashetm.wallet.common.configuration;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public abstract class GraphQLCommonConfiguration {

    protected GraphQL graphQL(Resource resource) throws IOException {
        File file = resource.getFile();
        GraphQLSchema graphQLSchema = buildSchema(file);

        return GraphQL.newGraphQL(graphQLSchema)
                .build();
    }

    private GraphQLSchema buildSchema(File file) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    protected abstract RuntimeWiring buildWiring();

}
