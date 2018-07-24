package com.pinyougou.solrutil;

import com.pinyougou.pojo.TbItem;
import com.pinyougou.solrutil.config.HttpSolrContext;
import com.pinyougou.solrutil.repository.ItemRepository;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HttpSolrContext.class)
public class SolrUtilTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void addOne(){
        List<TbItem> list = new ArrayList<TbItem>();
        TbItem item =new TbItem();

        item.setId(5L);
        item.setBrand("魅族");
        item.setCategory("手机");
        item.setGoodsId(5L);
        item.setPrice(new BigDecimal(100));
        item.setSeller("魅族专卖店");
        item.setTitle("魅族8");
        list.add(item);

//        SolrInputDocument document =new SolrInputDocument();
//        document.addField("id",item.getId());
//        document.addField("item_");
//        document.addChildDocuments();
        System.out.println(item);
        itemRepository.save(item);
    }

}