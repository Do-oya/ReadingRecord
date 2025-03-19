package chapter01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class App {

    public static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassLoader classLoader = App.class.getClassLoader();
            Statement statement = new Statement();

            // plays.json 파일 로드
            InputStream playStream = classLoader.getResourceAsStream("chapter01/plays.json");
            Map<String, Play> plays = objectMapper.readValue(playStream, objectMapper.getTypeFactory().constructMapType(Map.class, String.class, Play.class));

            // invoices.json 파일 로드
            InputStream invoicesStream = classLoader.getResourceAsStream("chapter01/invoices.json");
            List<Invoice> invoices = objectMapper.readValue(invoicesStream, new TypeReference<>(){});

            // 각 Invoice 처리
            for (Invoice invoice : invoices) {
                String result = statement.statement(invoice, plays);
                logger.info("\n{}", result);
            }
        } catch (IOException e) {
            logger.error("Error", e);
        }
    }
}
