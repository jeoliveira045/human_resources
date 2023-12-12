package lab.spec.demo.entity.databind;

import lab.spec.demo.entity.Employees;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class EmployeesDatabind {
    public static class IdDeserializer extends JsonDeserializer<Employees> {
        @Override
        public Employees deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Employees c = new Employees();
                c.setEmployeeId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Employees c = new Employees();
                c.setEmployeeId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Employees> {
        @Override
        public void serialize(Employees entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getEmployeeId());
        }
    }
}


