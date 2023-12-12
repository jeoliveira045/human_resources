package lab.spec.demo.entity.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import lab.spec.demo.entity.Department;

import java.io.IOException;

public class DepartmentDatabind {
    public static class IdDeserializer extends JsonDeserializer<Department> {
        @Override
        public Department deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Department c = new Department();
                c.setDepartmentId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Department c = new Department();
                c.setDepartmentId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Department> {
        @Override
        public void serialize(Department entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getDepartmentId());
        }
    }
}


