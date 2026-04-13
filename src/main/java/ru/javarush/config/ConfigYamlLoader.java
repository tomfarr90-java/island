package ru.javarush.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.javarush.dto.OrganismConfig;
import ru.javarush.dto.OrganismStats;
import ru.javarush.repository.ConfigRepository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigYamlLoader {
    public static void loadConfig() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try(InputStream is = ConfigYamlLoader.class.getClassLoader().getResourceAsStream("OrganismConfig.yaml")) {
            OrganismConfig config = mapper.readValue(is, OrganismConfig.class);
            Map<String, OrganismStats> processedStats = new HashMap<>();
            config.getOrganismSettings().forEach((name,stats) -> {
                Map<String, Integer> probabilities = config.getEatingProbabilities().get(name);
                stats.setChanceEat(probabilities);
                processedStats.put(name.toUpperCase(),stats);
            });
            ConfigRepository.init(processedStats);
            System.out.println("Конфигурация успешно загружена. Загружено существ: " + processedStats.size());
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке OrganismConfig.yaml");
            e.printStackTrace();
        }

    }
}

