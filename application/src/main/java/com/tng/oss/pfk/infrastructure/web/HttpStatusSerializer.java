package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class HttpStatusSerializer extends StdSerializer<HttpStatus> {

    protected HttpStatusSerializer(JavaType type) {
        super(type);
    }

    public HttpStatusSerializer() {
        super(HttpStatus.class);
    }

    @Override
    public void serialize(HttpStatus httpStatus, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(httpStatus.value());
    }
}
