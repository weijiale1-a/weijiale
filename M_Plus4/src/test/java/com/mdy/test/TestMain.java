package com.mdy.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * MP代码生成器：需要导入velocity-engine-core依赖
 * */
public class TestMain {
	public static void main(String[] args) {
		//1、全局配置
		GlobalConfig gc=new GlobalConfig();
		gc.setActiveRecord(false)//是否开启AR模式
		.setAuthor("mdy")//设置作者
		.setBaseColumnList(true)//是否在xml中生成基础列
		.setBaseResultMap(true)//是否在xml中生成resultMap
		.setFileOverride(true)//是否覆盖上一次生成的代码
		.setIdType(IdType.AUTO)//设置主键策略为自适应
		.setOutputDir(".\\src\\main\\java");//设置代码生成的位置
		
		//2、数据源配置
		DataSourceConfig dsc=new DataSourceConfig();
		dsc.setUsername("group4")
		.setPassword("123456")
		.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8")
		.setDriverName("com.mysql.jdbc.Driver")
		.setDbType(DbType.ORACLE);//数据库类型
		
		//3、策略配置
		StrategyConfig sc=new StrategyConfig();
		sc.setCapitalMode(true)//是否开启全局大写命名
		.setDbColumnUnderline(true)//数据库字段是否采用下划线命名
		.setNaming(NamingStrategy.underline_to_camel)//设置下划线到驼峰的命名方式
//		.setTablePrefix("tb_")//设置表前缀
		.setInclude("depinfo","empinfo");//设置需要生成的表
		
		//4、包配置
		PackageConfig pc=new PackageConfig();
		pc.setParent("com.mdy")//基础父包
		.setEntity("entity")//实体类所在包
		.setMapper("dao")//dao接口类所在包
		.setXml("mapper")//xml映射文件所在包
		.setService("service")//业务层包
		.setServiceImpl("service.impl")
		.setController("controller");//控制层包
		
		//5、整合配置
		AutoGenerator generator=new AutoGenerator();
		generator.setGlobalConfig(gc)
		.setDataSource(dsc)
		.setStrategy(sc)
		.setPackageInfo(pc);
		
		//6、生成
		generator.execute();
	}
}
