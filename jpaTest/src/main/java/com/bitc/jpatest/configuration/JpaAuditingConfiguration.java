package com.bitc.jpatest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 공통 Entity 사용 방법 2(Application, JpaAuditingConfiguration 둘중 하나만 써야함)
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {
}
// 이렇게 저장만 하고 끝