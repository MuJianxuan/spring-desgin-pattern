package org.designpattern.spring.creationtype.builder;

/**
 *
 * 创建型： 建造者
 *   构建复杂对象，可能缺少某些参数；也可以用于构建要求参数性对象
 *    Builder 对象是辅助创建  原对象的，返回的是 当前对象，这里一个思考的问题是，静态类下，线程安全的考虑，就是我当前构建对象（Builder 要对当前线程可见）
 * 构建 事件 >> 状态 >> 次态
 * @author Rao StateKeyBuilder
 * @Date 2021-10-25
 **/
public class Key {

    /**
     * 业务
     */
    private String business;
    /**
     * 触发事件
     */
    private String triggerEvent;
    /**
     * 初态
     */
    private String initState;
    /**
     * 终态
     */
    private String nextState;

    public Key(){}

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(String triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    public String getInitState() {
        return initState;
    }

    public void setInitState(String initState) {
        this.initState = initState;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "Key{" +
                "business='" + business + '\'' +
                ", triggerEvent='" + triggerEvent + '\'' +
                ", initState='" + initState + '\'' +
                ", nextState='" + nextState + '\'' +
                '}';
    }

    public static class KeyBuilder {

        /**
         * 业务
         */
        private String business;
        /**
         * 触发事件
         */
        private String triggerEvent;
        /**
         * 初态
         */
        private String initState;
        /**
         * 终态
         */
        private String nextState;

        /**
         * 本质是返回创建一个对象。
         * @return
         */
        public static KeyBuilder builder(){
            return new KeyBuilder();
        }

        public KeyBuilder business(String business){
            this.business = business;
            return this;
        }

        public KeyBuilder triggerEvent(String event){
            this.triggerEvent = event;
            return this;
        }

        public KeyBuilder initState(String initState){
            this.initState = initState;
            return this;
        }

        public KeyBuilder nextState(String nextState){
            this.nextState = nextState;
            return this;
        }

        /**
         * 状态key
         * @return
         */
        public Key build(){
            Key key = new Key();
            key.setBusiness( this.business);
            key.setTriggerEvent( this.triggerEvent);
            key.setInitState( this.initState);
            key.setNextState( this.nextState);
            return key;
        }
    }





}
