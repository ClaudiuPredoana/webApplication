package com.predoana.app.web.config;

import org.springframework.context.annotation.ConditionContext;

import java.lang.reflect.AnnotatedType;
import java.util.Map;
import java.util.concurrent.locks.Condition;

public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedType Metadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes
                (DatabaseType.class.getName());
        String type = (String) attributes.get("value");
        String enabledDBType = System.getProperty("dbType","MYSQL");
        return (enabledDBType != null && type != null && enabledDBType.equals(type);
    } }

