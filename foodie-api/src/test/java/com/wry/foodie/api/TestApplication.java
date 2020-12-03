package com.wry.foodie.api;

import com.wry.foodie.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 *      REQUIRED: 父方法有事务子方法就加入事务，父方法没有事务子方法就新建事务
 *      SUPPORTS: 父方法有事务子方法就加入事务，父方法没有事务子方法就以非事务方法运行
 *      MANDATORY：父方法有事务子方法就加入事务，父方法没有事务子方法就抛出异常
 *      REQUIRES_NEW:父方法有事务子方法就暂停父方法的事务，并新建事务运行，父方法没有事务子方法就新建事务
 *      NOT_SUPPORTED:父方法有事务子方法就暂停父方法的事务，子方法并以非事务方法运行,父方法没有事务子方法就以非事务方法运行
 *      NEVER:父方法有事务子方法就抛出异常，父方法没有事务子方法就以非事务方法运行
 *      NESTED：父方法有事务子方法就新建事务（嵌套事务，独立提交或回滚），并一起提交，父方法没有事务子方法就新建事务
 *              如果主事务提交，子事务也会一起提交，
 *              如果主事务回滚，子事务也会一起回滚，
 *
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FoodieApiApplication.class)
public class TestApplication {
   
}
