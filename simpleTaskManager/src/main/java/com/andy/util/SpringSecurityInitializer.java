package com.andy.util;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Andrew on 22.03.2017.
 */

/*объявление DelegatingFilterProxy который делегирует фильтрацию фактическим фильтрам*/
/*перхватывает все запросы*/
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
