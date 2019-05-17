import com.company.project.core.ProjectConstant;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.project.core.ProjectConstant.*;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 *
 * 改动CodeGenerator 类的配置 需要 mvn clean install才能生效
 */
public class CodeGenerator {
  private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);
  // JDBC配置，请修改为你项目的实际配置
  private static final String JDBC_URL = "jdbc:mysql://dbserver:3306/tax_market_dev?useSSL=false&characterEncoding=utf8";
  private static final String JDBC_USERNAME = "apple";
  private static final String JDBC_PASSWORD = "X0dxeLpK";
  private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

  private static final String PROJECT_PATH = ProjectConstant.PROJECT_PATH;// 项目在硬盘上的基础路径
  private static final String TEMPLATE_FILE_PATH =
      PROJECT_PATH + "/src/test/resources/generator/template";// 模板位置

  private static final String JAVA_PATH = "/src/main/java"; // java文件路径
  private static final String RESOURCES_PATH = "/src/main/resources";// 资源文件路径

  private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);// 生成的Service存放路径
  private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);// 生成的Service实现存放路径
  private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);// 生成的Controller存放路径

  private static final String AUTHOR = "ouzhx";// @author
  private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());// @date

  public static void main(String[] args) {
    genCode("msg");
    // genCodeByCustomModelName("输入表名","输入自定义Model名称");
  }

  /**
   * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。 如输入表名称 "t_user_detail" 将生成
   * TUserDetail、TUserDetailMapper、TUserDetailService ...
   * 
   * @param tableNames 数据表名称...
   */
  public static void genCode(String... tableNames) {
    for (String tableName : tableNames) {
      genCodeByCustomModelName(tableName, null);
    }
  }

  /**
   * 通过数据表名称，和自定义的 Model 名称生成代码 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成
   * User、UserMapper、UserService ...
   * 
   * @param tableName 数据表名称
   * @param modelName 自定义的 Model 名称
   */
  public static void genCodeByCustomModelName(String tableName, String modelName) {
    genModelAndMapper(tableName, modelName);
    genService(tableName, modelName);
    genController(tableName, modelName);
  }


  public static void genModelAndMapper(String tableName, String modelName) {
    Context context = new Context(ModelType.FLAT);
    context.setId("Potato");
    context.setTargetRuntime("MyBatis3Simple");
    context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
    context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

    JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
    jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
    jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
    jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
    jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
    context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

    PluginConfiguration pluginConfiguration = new PluginConfiguration();
    pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
    pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
    context.addPluginConfiguration(pluginConfiguration);

    JavaModelGeneratorConfiguration javaModelGeneratorConfiguration =
        new JavaModelGeneratorConfiguration();
    javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
    javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
    context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

    SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
    sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
    sqlMapGeneratorConfiguration.setTargetPackage("mapper");
    context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

    JavaClientGeneratorConfiguration javaClientGeneratorConfiguration =
        new JavaClientGeneratorConfiguration();
    javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
    javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
    javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
    context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

    TableConfiguration tableConfiguration = new TableConfiguration(context);
    tableConfiguration.setTableName(tableName);
    if (StringUtils.isNotEmpty(modelName))
      tableConfiguration.setDomainObjectName(modelName);
    tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
    context.addTableConfiguration(tableConfiguration);

    List<String> warnings;
    MyBatisGenerator generator;
    try {
      Configuration config = new Configuration();
      config.addContext(context);
      config.validate();

      boolean overwrite = true;
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      warnings = new ArrayList<String>();
      generator = new MyBatisGenerator(config, callback, warnings);
      generator.generate(null);
    } catch (Exception e) {
      throw new RuntimeException("生成Model和Mapper失败", e);
    }

    if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
      throw new RuntimeException("生成Model和Mapper失败：" + warnings);
    }
    if (StringUtils.isEmpty(modelName))
      modelName = tableNameConvertUpperCamel(tableName);

    String javaDomainPath = DOMAIN_PATH + modelName + ".java";
    deleteAnnotation(javaDomainPath);

    logger.info(modelName + ".java 生成成功");
    logger.info(modelName + "Mapper.java 生成成功");
    logger.info(modelName + "Mapper.xml 生成成功");
  }

  public static void genService(String tableName, String modelName) {
    try {
      freemarker.template.Configuration cfg = getConfiguration();

      Map<String, Object> data = new HashMap<>();
      data.put("date", DATE);
      data.put("author", AUTHOR);
      String modelNameUpperCamel =
          StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
      data.put("modelNameUpperCamel", modelNameUpperCamel);
      data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
      data.put("basePackage", BASE_PACKAGE);

      File file = new File(
          PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      cfg.getTemplate("service.ftl").process(data, new FileWriter(file));
      logger.info(modelNameUpperCamel + "Service.java 生成成功");

      File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL
          + modelNameUpperCamel + "ServiceImpl.java");
      if (!file1.getParentFile().exists()) {
        file1.getParentFile().mkdirs();
      }
      cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(file1));
      logger.info(modelNameUpperCamel + "ServiceImpl.java 生成成功");
    } catch (Exception e) {
      throw new RuntimeException("生成Service失败", e);
    }
  }

  public static void genController(String tableName, String modelName) {
    try {
      freemarker.template.Configuration cfg = getConfiguration();

      Map<String, Object> data = new HashMap<>();
      data.put("date", DATE);
      data.put("author", AUTHOR);
      String modelNameUpperCamel =
          StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
      data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
      data.put("modelNameUpperCamel", modelNameUpperCamel);
      data.put("modelNameLowerCamel",
          CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
      data.put("basePackage", BASE_PACKAGE);

      File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel
          + "Controller.java");
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      // cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
      cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

      logger.info(modelNameUpperCamel + "Controller.java 生成成功");
    } catch (Exception e) {
      throw new RuntimeException("生成Controller失败", e);
    }

  }

  private static freemarker.template.Configuration getConfiguration() throws IOException {
    freemarker.template.Configuration cfg =
        new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
    cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
    return cfg;
  }

  private static String tableNameConvertLowerCamel(String tableName) {
    return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
  }

  private static String tableNameConvertUpperCamel(String tableName) {
    return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

  }

  private static String tableNameConvertMappingPath(String tableName) {
    tableName = tableName.toLowerCase();// 兼容使用大写的表名
    return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
  }

  private static String modelNameConvertMappingPath(String modelName) {
    String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
    return tableNameConvertMappingPath(tableName);
  }

  private static String packageConvertPath(String packageName) {
    return String.format("/%s/",
        packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
  }

  /**
   * 删除文件中包含jpa注解的行(包含@的),同时添加自定义注解
   *
   * @param fileName
   * @return
   */
  private static void deleteAnnotation(String fileName) {
    System.out.println("开始自定义生成java domain: " + fileName);
    BufferedReader br = null;
    String line = null;
    StringBuffer buf = new StringBuffer();

    try {
      // 根据文件路径创建缓冲输入流
      br = new BufferedReader(new FileReader(fileName));

      // 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
      int publicCount = 0;
      while ((line = br.readLine()) != null) {
        if (line.contains("@Id")){
          //丢弃@Id
          continue;
        }
        if (line.contains("public") && publicCount > 0) {
          buf.append("} ");
          // 通过第二个public 来确定 getter setter 方法的开始位置
          // 结束循环,后面的getter setter 方法不再生成
          break;
        }
        if (line.contains("@Column") || line.contains("javax.persistence.Column")) {
          // 丢弃@Column注解和导入包
        } else if (line.contains("@GeneratedValue")) {
          String shortLine = line.substring(2, line.length());
          if (buf.indexOf("@Id")<0){
            buf.append("  @Id\r\n").append(shortLine).append("\r\n");
          }
        } else if (line.contains("public")) {
          // publicCount =0 时,第一个public 代表类所在行
          // 类名前面添加lombok 注解
          buf.append("import lombok.Getter;\r\nimport lombok.Setter;\r\n")
              .append("/**\r\n @author " + AUTHOR + " on " + DATE + " \r\n */\r\n")
              .append("@Setter\r\n@Getter\r\n").append(line).append("\r\n");
          publicCount = publicCount + 1;
        } else {
          if (publicCount == 0) {
            // 如果不用修改, 则按原来的内容回写
            buf.append(line).append("\r\n");
          } else {
            // 所有字段 去除两个空格
            if (line != null && line.trim().length() > 0 && !line.startsWith("}")) {
              String shortLine = line.substring(2, line.length());
              buf.append(shortLine).append("\r\n");
            }
          }

        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭流
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          br = null;
        }
      }
    }
    write(fileName, buf.toString());
  }

  private static void write(String filePath, String content) {
    BufferedWriter bw = null;

    try {
      // 根据文件路径创建缓冲输出流
      bw = new BufferedWriter(new FileWriter(filePath));
      // 将内容写入文件中
      bw.write(content);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭流
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          bw = null;
        }
      }
    }
  }

}
