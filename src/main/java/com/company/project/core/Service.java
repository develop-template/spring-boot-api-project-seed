package com.company.project.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
  void save(T model);// 持久化

  void save(List<T> models);// 批量持久化

  void deleteById(Integer id);// 通过主鍵刪除

  void deleteByIds(String ids);// 批量刪除 eg：ids -> “1,2,3,4”

  void update(T model);// 更新

  T findById(Integer id);// 通过ID查找

  T findBy(String fieldName, Object value) throws TooManyResultsException; // 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束

  List<T> findByIds(String ids);// 通过多个ID查找//eg：ids -> “1,2,3,4”

  /**
   * example 参考文档 https://github.com/abel533/Mapper/wiki/6.example
   *
   * 单表查询示例 Condition condition = new Condition(Course.class);
   *
   * //设置 查询的列,like条件 condition.selectProperties("id", "user_id", "category_id",
   * "name").createCriteria() .andLike("name",
   * "1%").andCondition("user_id='1'").andGreaterThan("category_id", "1");
   * 
   * //去重 condition.setDistinct(true);
   * 
   * //排序 condition.orderBy("update_date").desc().orderBy("create_date").desc();
   * 
   * 
   * /* 动态sql
   * 
   * Example example = new Example(Country.class);
   * 
   * Example.Criteria criteria =example.createCriteria();
   * 
   * if(query.getCountryname() != null){ criteria.andLike("countryname", query.getCountryname() +
   * "%"); }
   * 
   * if(query.getId() != null){ criteria.andGreaterThan("id", query.getId()); }
   * 
   * List<Country> countries = mapper.selectByExample(example); PageHelper.startPage(page, size);
   * List<Course> list = courseService.findByCondition(condition); PageInfo pageInfo = new
   * PageInfo(list);
   * 
   * @param condition 继承自Example
   * @return
   */
  List<T> findByCondition(Condition condition);// 根据条件查找

  List<T> findAll();// 获取所有
}
