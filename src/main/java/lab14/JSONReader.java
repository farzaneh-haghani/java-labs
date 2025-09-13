package lab14;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class JSONReader {

    public static List<Customer> readCustomers(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath),
                new TypeReference<List<Customer>>() {
                });
    }

    public static Library readLibrary(String content) throws JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Library.class, new libraryDeserializer());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        return mapper.readValue(content, Library.class);
    }
}
