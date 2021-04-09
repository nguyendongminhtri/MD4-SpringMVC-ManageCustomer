import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("controllers")
public class WebConfig implements WebMvcConfigurer {
//    private ApplicationContext applicationContext;
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/views");
        resolver.setSuffix(".jsp");
        return resolver;
    }
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setCacheable(false);
//        templateResolver.setApplicationContext(applicationContext);
//
//        templateResolver.setPrefix("/views");
//
//        templateResolver.setSuffix(".html");
//
//        templateResolver.setTemplateMode(TemplateMode.HTML);
////        templateResolver.setTemplateMode(TemplateMode.TEXT);
//        templateResolver.setCharacterEncoding("UTF-8");
//
//
//        return templateResolver;
//
//    }
//
//    //    @Bean
////    public ViewResolver configureViewResolver()
////    {
////        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
////        viewResolve.setPrefix("/views");
////        viewResolve.setSuffix(".jsp");
////        return viewResolve;
////    }
//    @Bean
//
//    public TemplateEngine templateEngine() {
//
//        TemplateEngine templateEngine = new SpringTemplateEngine();
//
//        templateEngine.setTemplateResolver(templateResolver());
//
//        return templateEngine;
//
//    }
//
//
//    @Bean
//
//    public ThymeleafViewResolver viewResolver() {
//
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//
//        viewResolver.setTemplateEngine(templateEngine());
//
//        viewResolver.setCharacterEncoding("UTF-8");
//        viewResolver.setOrder(1);
//        return viewResolver;
//
//    }

}
