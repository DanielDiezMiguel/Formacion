package com.bosonit.BS4;

import lombok.Data;

@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "simple")
@Data
public class ConfigurationProperties {
   private String var1;
   private int var2;
}
