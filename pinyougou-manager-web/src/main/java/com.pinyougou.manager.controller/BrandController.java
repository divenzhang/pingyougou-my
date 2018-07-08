package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int page,int rows){
        return brandService.findByPage(brand,page,rows);
    }
    @RequestMapping("/save")
    public Result save(@RequestBody TbBrand brand){
        try{
            brandService.save(brand);

            return new Result(true,"保存成功!");
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败!");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
        return brandService.findById(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try{
            brandService.update(brand);

            return new Result(true,"修改成功!");
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败!");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try{
            brandService.delete(ids);

            return new Result(true,"删除成功!");
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败!");
        }
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
