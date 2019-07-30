package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;

public class PropertiesHelper {

    private static Properties property = new Properties();

    static {
        getConfig();
    }

    private static void getConfig() {
        FileInputStream fis;

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            try {
                property.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }

    public static String getDataFromTxt(String file, String key) {
        String separator = "===";
        Map<String, String> map = new HashMap<>();

        try (Stream<String> lines = Files.lines(Paths.get("src", "test", "resources", "data").resolve(file))) {
            lines.filter(line -> line.contains(separator)).forEach(
                    line -> map.putIfAbsent(line.split(separator)[0], line.split(separator)[1])
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.get(key);
    }

    /**
     * преобразует файл из каталога src/test/resources/data в структуру даных для датапровайдера типа 'имя-значение'
     */
    public static Object[][] getDataProviderFromTxt(String file) throws IOException {
        List<String> lines = readAllLines(Paths.get("src", "test", "resources", "data").resolve(file));

        int count = lines.get(0).split("===").length;

        Object[][] res = new Object[lines.size()][count];

        for (int i = 0; i < lines.size(); i++) {
            List<String> tmpS = Arrays.asList(lines.get(i).split("==="));
            for (int j = 0; j < count; j++) {
                res[i][j] = tmpS.get(j);
            }
        }
        return res;
    }
}


