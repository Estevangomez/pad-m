package padm.io.pad_m.fileserver;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
public interface FilesStorageService {
  public void init();

  public String save(MultipartFile file);

  String save(MultipartFile file, String subDirectory);

  public Resource load(String filename);

  public void verify(MultipartFile file);
  
  Resource load(String filename, String subDirectory);

  public boolean delete(String filename);

  boolean delete(String filename, String subDirectory);

  public void deleteAll();

  public Stream<Path> loadAll();

  Stream<Path> loadAll(String subDirectory);
}
