package com.pinyougou.solrutil.repository;

import com.pinyougou.pojo.TbItem;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ItemRepository extends SolrCrudRepository<TbItem,String>{

}
