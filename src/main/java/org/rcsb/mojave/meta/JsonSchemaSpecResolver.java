package org.rcsb.mojave.meta;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created on 6/6/22.
 *
 * @author Yana Rose
 * @since 1.5.0
 */
public class JsonSchemaSpecResolver {

    public String getSpecification(Draft version) throws IOException {
        switch (version) {
            case VERSION_07:
                return getResourceAsString(Draft.VERSION_07.value());
            default:
                throw new RuntimeException("Unsupported version of JSON Schema specification");
        }
    }

    private String getResourceAsString(String name) throws IOException {
        InputStream is = getClass().getResourceAsStream("/" + name);
        if (is == null)
            throw new IOException("Failed to locate JSON Schema specification");

        StringWriter writer = new StringWriter();
        IOUtils.copy(is, writer, StandardCharsets.UTF_8);
        return writer.toString();
    }

    public enum Draft {

        VERSION_07("json-schema-spec/json-schema-draft-07.json");

        private final String value;
        Draft(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
}
