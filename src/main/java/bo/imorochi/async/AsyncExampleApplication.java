package bo.imorochi.async;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncExampleApplication { //implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AsyncExampleApplication.class);

//    @Autowired
//    private GitHubLookupService gitHubLookupService;

    public static void main(String[] args) {
        SpringApplication.run(AsyncExampleApplication.class, args);
    }

//    @Override
//    public void run(String...args) throws Exception {
//        // Start the clock
//        long start = System.currentTimeMillis();
//
//        // Kick of multiple, asynchronous lookups
//        CompletableFuture < User > page1 = gitHubLookupService.findUser("PivotalSoftware");
//        CompletableFuture < User > page2 = gitHubLookupService.findUser("CloudFoundry");
//        CompletableFuture < User > page3 = gitHubLookupService.findUser("Spring-Projects");
//        CompletableFuture < User > page4 = gitHubLookupService.findUser("RameshMF");
//
//        // Wait until they are all done
//        CompletableFuture.allOf(page1, page2, page3, page4).join();
//
//        // Print results, including elapsed time
//        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
//        logger.info("--> " + page1.get());
//        logger.info("--> " + page2.get());
//        logger.info("--> " + page3.get());
//        logger.info("--> " + page4.get());
//    }

}
