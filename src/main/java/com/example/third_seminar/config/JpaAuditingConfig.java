package com.example.third_seminar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//@EnableJpaAuditing
// 이 어노테이션이 class 를 만들면서 자동으로 만들어진다고 해서
//어노테이션을 붙이면 자꾸 overriding 되는 에러가 나서 없앴다
public class JpaAuditingConfig {
}
