package padm.io.pad_m.fileserver;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
  private final Path root = Paths.get("./uploads");

  private String pdfDir = "documentos";
  private String pdfVerify = "verify";
  
  @Override
  public void init() {
    try {
      Files.createDirectories(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!", e);
    }
  }

	@Override
	public void verify(MultipartFile file) {
		 StringBuilder fileNames = new StringBuilder();	       
	        try {
	        	//if (!Files.exists(fileNameAndPath)) {
	        		fileNames.append(file.getOriginalFilename());
	        		Files.write  (root.resolve(pdfVerify), file.getBytes());
	        	//}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Ocorreu um erro: " + e.getMessage());
			}
		
	}
	
  @Override
  public String save(MultipartFile file) {
    // Chama a versão sobrecarregada do método save que não usa subdiretório
    return save(file, "");
  }

  @Override
  public String save(MultipartFile file, String subDirectory) {
    try {
      Path targetPath = root.resolve(subDirectory);
      Files.createDirectories(targetPath);  // Cria o diretório se não existir

      String uniqueFileName = generateUniqueFileName(Objects.requireNonNull(file.getOriginalFilename()));
      Path filePath = targetPath.resolve(uniqueFileName);

      try (InputStream inputStream = file.getInputStream()) {
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
      }

      return uniqueFileName;
    } catch (IOException | NoSuchAlgorithmException e) {
      throw new RuntimeException("Could not save the file: " + e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    // Chama a versão sobrecarregada do método load que não usa subdiretório
    return load(filename, "");
  }

  @Override
  public Resource load(String filename, String subDirectory) {
    try {
      Path file = root.resolve(subDirectory).resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() && resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage(), e);
    }
  }

  @Override
  public boolean delete(String filename) {
    // Chama a versão sobrecarregada do método delete que não usa subdiretório
    return delete(filename, "");
  }

  @Override
  public boolean delete(String filename, String subDirectory) {
    try {
      Path file = root.resolve(subDirectory).resolve(filename);
      return Files.deleteIfExists(file);
    } catch (IOException e) {
      throw new RuntimeException("Error: " + e.getMessage(), e);
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    // Chama a versão sobrecarregada do método loadAll que não usa subdiretório
    return loadAll("");
  }

  @Override
  public Stream<Path> loadAll(String subDirectory) {
    try {
      Path subDirPath = root.resolve(subDirectory);
      if (Files.notExists(subDirPath)) {
        throw new RuntimeException("Subdirectory does not exist!");
      }

      return Files.walk(subDirPath, 1)
              .filter(path -> !path.equals(subDirPath))
              .map(subDirPath::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!", e);
    }
  }

  private String generateUniqueFileName(String originalFilename) throws NoSuchAlgorithmException {
    // Gerar hash do nome do arquivo original
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hashBytes = digest.digest(originalFilename.getBytes());
    StringBuilder sb = new StringBuilder();
    for (byte b : hashBytes) {
      sb.append(String.format("%02x", b));
    }

    // Adicionar uma extensão ao arquivo original se necessário
    String extension = originalFilename.contains(".") ?
            originalFilename.substring(originalFilename.lastIndexOf(".")) : "";
    return sb.toString() + extension;
  }
}
