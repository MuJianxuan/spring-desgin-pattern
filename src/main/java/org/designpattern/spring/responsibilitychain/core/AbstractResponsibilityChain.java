package org.designpattern.spring.responsibilitychain.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rao
 * @Date 2021-11-01
 **/
public abstract class AbstractResponsibilityChain<T> implements InitializingBean ,ResponsibilityChain<T> {

    @Resource
    private List<ChainNode<T>> chainNodeList;

    /**
     * 主节点
     */
    private ChainNode<T> mainNode;

    @Override
    public void execute(T param) {
        Optional.ofNullable(mainNode).orElseThrow(() -> new RuntimeException("Missing master node!"))
                .execute(param);
    }

    /**
     * order  基于注解的order排序 {@link AnnotationAwareOrderComparator#sort}
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        // 获取
        if (! CollectionUtils.isEmpty( chainNodeList)){
            // 正序排序？
            chainNodeList.sort( Comparator.comparingInt(ChainNode::order));
            chainNodeList.forEach( chainNode -> {

                if( this.mainNode == null){
                    this.setMainNode( chainNode);
                }
                // 责任链构建
                else {
                    this.mainNode.buildFinallyChainNode( (AbstractChainNode<T>) chainNode);
                }

            });

        }

        // 缺少打印信息


    }

    /**
     * 设置 主节点
     * @param mainNode
     */
    private void setMainNode(ChainNode<T> mainNode) {
        this.mainNode = mainNode;
    }


}
