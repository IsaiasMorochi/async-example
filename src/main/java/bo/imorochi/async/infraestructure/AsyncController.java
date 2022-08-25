package bo.imorochi.async.infraestructure;

import bo.imorochi.async.application.GitHubLookupService;
import bo.imorochi.async.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/")
public class AsyncController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @GetMapping
    public void initialize() throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture <User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture < User > page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture < User > page3 = gitHubLookupService.findUser("Spring-Projects");
        CompletableFuture < User > page4 = gitHubLookupService.findUser("RameshMF");

        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3, page4).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
        logger.info("--> " + page4.get());
    }

}
