package com.skd.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Describe: 自定义插件，不支持Spring配置文件形式添加插件，需要使用 Java bean 方式 @ MybatisConfig
 * @Author: chenfan
 * @Date: 2020/5/15 17:48
 */
@Intercepts({
//        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
        @Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})
})
@Slf4j
public class ModifySqlPlugin implements Interceptor {

    public ModifySqlPlugin(){
        log.info("init ModifySqlPlugin");
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        // 分页参数信息
        RowBounds rowBounds = (RowBounds) metaObject.getValue("delegate.rowBounds");
        metaObject.setValue("delegate.rowBounds",rowBounds);
        // 获取预编译SQL
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        metaObject.setValue("delegate.boundSql.sql",sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        // 插件采用 动态代理方式，动态生成代理对象
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
