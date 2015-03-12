package com.mayura.examples.persistant;

import com.mayura.examples.model.Teacher;
import org.hibernate.cache.spi.entry.CacheEntry;
import org.infinispan.commands.write.PutKeyValueCommand;
import org.infinispan.context.InvocationContext;
import org.infinispan.interceptors.base.BaseCustomInterceptor;

public class CacheInterceptor extends BaseCustomInterceptor {

    @Override
    public Object visitPutKeyValueCommand(InvocationContext ctx, PutKeyValueCommand command) throws Throwable {
        if (Teacher.class.getCanonicalName().equals( ((CacheEntry) command.getValue()).getSubclass())){
            System.out.println("Found Non Cache Object " );
            return null;
        } else {
            return invokeNextInterceptor(ctx, command);
        }
    }
}
