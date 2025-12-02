import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class AocUtils {

    public static List<String> input(int year, int day) {
        try {
            String filename = "_" + year + "/aoc" + day + ".txt";
            Path path = Path.of(Objects.requireNonNull(AocUtils.class.getResource(filename)).toURI());
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> input(Class<?> clazz) {
        String classname = clazz.getSimpleName();
        int year = Integer.parseInt(classname.substring(3, 7));
        int day = Integer.parseInt(classname.substring(10, 12));
        return input(year, day);
    }
}
