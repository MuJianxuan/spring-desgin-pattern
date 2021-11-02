package org.designpattern.spring.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class Subscriber implements Subscribe {

    private int id;

    @Override
    public int id() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void notifyExecute(ApplicationEvent event) {
        System.out.println("notify ...............");
    }

    @Override
    public int hashCode() {
        return id();
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null) return false;
        if( obj instanceof Subscribe){
            Subscribe subscribe = (Subscribe) obj;
            return subscribe.id() == id();
        }
        return false;
    }
}
