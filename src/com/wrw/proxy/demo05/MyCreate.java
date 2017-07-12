package com.wrw.proxy.demo05;
import java.lang.reflect.Method;
public class MyCreate implements com.wrw.proxy.demo05.moveable{
    com.wrw.proxy.demo05.InvocationHandler h;
    public MyCreate(InvocationHandler h) {
        this.h = h;
    }
@Override
public void move() {
    try {
    Method md = com.wrw.proxy.demo05.moveable.class.getMethod("move");
    h.invoke(this, md);
    }catch(Exception e) {e.printStackTrace();}
}
}