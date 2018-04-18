package com.ken.web.config;

        import com.alibaba.druid.support.http.WebStatFilter;

        import javax.servlet.annotation.WebFilter;
        import javax.servlet.annotation.WebInitParam;

/**
 * @author zgquan(108563)
 * @date 2018/4/16 0016
 * @since
 */
@WebFilter(
        filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                /** 忽略资源 */
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*,/static/*"),
                @WebInitParam(name = "profileEnable", value = "true"),
                /** 监控当前COOKIE的用户 */
                @WebInitParam(name = "principalCookieName", value = "USER_COOKIE"),
                /** 监控当前SESSION的用户 */
                @WebInitParam(name = "principalSessionName", value = "USER_SESSION"),
                /** 监控单个url访问数据库情况 */
                @WebInitParam(name = "profileEnable", value = "true"),

                @WebInitParam(name = "sessionStatMaxCount", value = "2000")
        }
)
public class DruidWebStatFilter extends WebStatFilter {

}
