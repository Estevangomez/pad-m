package padm.io.pad_m;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import padm.io.pad_m.fileserver.FilesStorageService;

@SpringBootApplication
public class PadMApplication implements CommandLineRunner {

	@Resource
  	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(PadMApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}

}
