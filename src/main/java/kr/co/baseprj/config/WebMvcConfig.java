package kr.co.baseprj.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

  private final HandlerInterceptor interceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor)
        .addPathPatterns("/index")
        .addPathPatterns("/system/**")
        .addPathPatterns("/user/**")
        .addPathPatterns("/eduMng/**")
        .addPathPatterns("/admMgmt/**")
        .excludePathPatterns("/system/login")
        .excludePathPatterns("/system/loginProc")
        .excludePathPatterns("/static/**")
    ;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
  }
}
