package padm.io.pad_m;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

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
		
		 MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
	        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
	        System.out.printf("Heap usado: %.2f MB / Máximo: %.2f MB%n",
	                heap.getUsed() / 1024.0 / 1024.0,
	                heap.getMax() / 1024.0 / 1024.0);
	        
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}

}
