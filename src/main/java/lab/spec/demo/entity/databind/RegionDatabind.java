package lab.spec.demo.entity.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import lab.spec.demo.entity.Region;

import java.io.IOException;

public class RegionDatabind {
    public static class IdDeserializer extends JsonDeserializer<Region> {
        @Override
        public Region deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Region c = new Region();
                c.setRegionId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Region c = new Region();
                c.setRegionId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Region> {
        @Override
        public void serialize(Region entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getRegionId());
        }
    }
}


