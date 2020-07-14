package com.kafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.pojo.CustomObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class CustomDeserializer implements Deserializer<CustomObject> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public CustomObject deserialize(String s, byte[] data) {
        CustomObject object = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            object = mapper.readValue(data, CustomObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void close() {

    }
}
