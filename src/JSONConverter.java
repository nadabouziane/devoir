import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JSONConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Méthode pour convertir un objet en JSON
    public static String convertToJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    // Méthode pour convertir un JSON en objet
    public static <T> T convertFromJson(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}
