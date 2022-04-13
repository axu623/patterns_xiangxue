package src.main.com.enjoy.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationProxyOrder {

    private  Object target;

    public  InvocationProxyOrder(Object o){
        this.target = o;
    }


    public Object getProxy (){

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("incovation proxy order");
                Object invoke = method.invoke(target, args);
                return proxy;
            }
        })

    }

}
