package codeamatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import codeamatic.support.FileStorage;
import codeamatic.support.MoveRepository;

/**
 * Entry-point for the application.
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Client uciClient() {
    return new StockfishClient();
  }

  @Bean
  public MoveRepository moveRepository() {
    return new FileStorage();
  }
}
