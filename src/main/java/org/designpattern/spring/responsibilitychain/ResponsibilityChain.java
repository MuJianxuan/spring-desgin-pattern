package org.designpattern.spring.responsibilitychain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public abstract class ResponsibilityChain implements Handler {

    /**
     * 下一个节点
     */
    private ResponsibilityChain nextChain;

    public void doHandle(){
        if( this.isSupport() ){
            this.handle();
        }
        if( nextChain != null){
            nextChain.doHandle();
        }
    }

    public void setNextChain(ResponsibilityChain finallyNextChain) {
        this.setFinallyNextChain( this,finallyNextChain);
    }

    private void setFinallyNextChain(ResponsibilityChain nextChain, ResponsibilityChain finallyNextChain){
        if( nextChain.nextChain != null){
            this.setFinallyNextChain( nextChain.nextChain,finallyNextChain);
        }else {
            nextChain.nextChain = finallyNextChain;
        }
    }


}
