package com.company.project.core;

/**
 * 项目常量
 * @author ouzhx
 */
public final class ProjectConstant {
  public static final String BASE_PACKAGE = "com.company.project";// 项目基础包名称，根据自己公司的项目修改

  public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";// Model所在包
  public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";// Mapper所在包
  public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";// Service所在包
  public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";// ServiceImpl所在包
  public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";// Controller所在包

  public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";// Mapper插件基础接口的完全限定名


  public static final String PROJECT_PATH = System.getProperty("user.dir");// D:\gitrepository\training
  public static final String JAVA_PATH = "/src/main/java"; // java文件路径
  public static final String RESOURCES_PATH = "/src/main/resources";// 资源文件路径
  /**
   * 自定义生成实体类 包路径
   */
  public static final String DOMAIN_PATH =
      PROJECT_PATH + JAVA_PATH + "/com/rencaijia/training/domain/";

}
