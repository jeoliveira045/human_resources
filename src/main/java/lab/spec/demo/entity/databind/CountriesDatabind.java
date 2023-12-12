package lab.spec.demo.entity.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import lab.spec.demo.entity.Countries;

import java.io.IOException;

public class CountriesDatabind {
    public static class IdDeserializer extends JsonDeserializer<Countries> {
        @Override
        public Countries deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Countries c = new Countries();
                c.setCountryId(node.toString());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Countries c = new Countries();
                c.setCountryId(id.toString());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Countries> {
        @Override
        public void serialize(Countries entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getCountryId());
        }
    }
}


