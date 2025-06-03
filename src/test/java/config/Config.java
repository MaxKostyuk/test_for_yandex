package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.InputStream;

public class Config {
    private static final Config INSTANCE;
    private final String baseUrl;


    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.yaml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            RawConfig raw = mapper.readValue(in, RawConfig.class);
            INSTANCE = new Config(raw.baseUrl);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.yaml", e);
        }
    }

    public static Config get() {
        return INSTANCE;
    }


    private Config(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }


    private static class RawConfig {
        public String baseUrl;
    }
}