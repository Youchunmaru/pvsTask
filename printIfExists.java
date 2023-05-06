import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class printIfExists {

  private record Pair(Path path, boolean isDirectory){};
  public static void printIfExists(String... paths) throws IOException{

    Arrays.stream(paths)
      .map(Path::of)
      .map(path -> new Pair(path, Files.isDirectory(path)))
      .forEach(System.out::println);

    Arrays.stream(paths)
      .map(Path::of)
      .forEach(path -> System.out.println(path + " is a Dir:" + Files.isDirectory(path)));
  }
}
