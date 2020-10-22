package com.kafka.collector.util;

import org.slf4j.MDC;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author eddie.lee
 * @projectName springboot-kafka
 * @package com.kafka.collector.util
 * @className InputMDC
 * @description
 * @date created in 2020-10-20 11:38
 * @modified by
 */
@Component
public class InputMDC implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        InputMDC.environment = environment;
    }

    public static void putMDC() {
        MDC.put("ip", NetUtil.getLocalIp());
        MDC.put("hostName", NetUtil.getLocalHostName());
        MDC.put("applicationName", environment.getProperty("spring.application.name"));
    }

}
