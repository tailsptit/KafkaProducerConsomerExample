package com.kafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.pojo.CustomObject;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomSerializer  implements Serializer<CustomObject> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, CustomObject object) {
        byte[] val = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            val = mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return val;
    }

    @Override
    public void close() {

    }
}
