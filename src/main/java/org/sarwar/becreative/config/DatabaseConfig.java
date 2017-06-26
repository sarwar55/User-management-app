package org.sarwar.becreative.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("org.sarwar.becreative.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
