package cn.javabus.boot.common.initializer;

import cn.javabus.boot.common.constant.CommonConstants;
import cn.javabus.boot.common.util.SpringContextUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

/**
 * @author ouzhx on 2018/9/19.
 */
//@Log4j2
@Import(SpringContextUtil.class)
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String configUrl = environment.getProperty("spring.cloud.config.uri");

        if (StringUtils.isEmpty(configUrl)) {
            //log.info("{} 正在自动配置configServer url:{}", appName, CommonConstants.config_server_url);
            System.setProperty("spring.cloud.config.uri", CommonConstants.config_server_url);
        } else {
           // log.info("{} 使用外部指定configServer url:{}", appName, configUrl);
        }
        //配置中心地址
        System.setProperty("spring.cloud.nacos.config.server-addr","configserver:8848");

        System.setProperty("spring.cloud.config.username", "configserver");
        System.setProperty("spring.cloud.config.password", "hcfAI123456");
        System.setProperty("xxl.job.admin.addresses","http://xxljobadmin:10001/xxl-job-admin");

    }
}
