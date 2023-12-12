package lab.spec.demo.entity.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import lab.spec.demo.entity.Location;

import java.io.IOException;

public class LocationDatabind {
    public static class IdDeserializer extends JsonDeserializer<Location> {
        @Override
        public Location deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Location c = new Location();
                c.setLocationId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Location c = new Location();
                c.setLocationId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Location> {
        @Override
        public void serialize(Location entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getLocationId());
        }
    }
}


