package com.springbootjpamysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({
      "classpath:application.properties",
})
public class DbConnectionInfo {

   private Environment fEnvironment;

   public DbConnectionInfo(Environment pEnvironment) {
      fEnvironment = pEnvironment;
   }

   public String getUrl() {
      System.out.println("XIN CHAO " + fEnvironment.getProperty("spring.datasource.url"));
      return fEnvironment.getProperty("spring.datasource.url");
   }
}