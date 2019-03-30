package com.hh.test.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement;

public class CustomerContextHolder {
	Logger log = LoggerFactory.getLogger(getClass());
	
    public static final String DATA_SOURCE_TEST = "dataSource";
    public static final String DATA_SOURCE_XNEWS = "dataSource2";
    //用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
//        System.out.println("当前使用的数据源："+dataSource);
        if (StringUtils.isEmpty(dataSource)) {
            return DATA_SOURCE_TEST;
        }else {
            return dataSource;
        }
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
