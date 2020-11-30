package javacourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Applnit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

        @Override
        protected Class<?>[] getServletConfigClasses () {
            return new Class<?>[]{
                    DataConfig.class
            };
        }

        @Override
        protected String[] getServletMappings () {
            return new String[]{"/"};
        }
    }


