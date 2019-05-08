package cn.huacloud.tax;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author ouzhx on 2018/5/5.
 *
 *     TODO    需要启动项目 Application 然后才能运行测试类
 */
public class SwaggerTest extends Tester {
  private static URL API_DOC_HOST = null;

  static {
      try {
          API_DOC_HOST = new URL("http://localhost:8080/v2/api-docs");
      } catch (MalformedURLException e) {
      e.printStackTrace();
      }
  }

  @Test
  public void generateAsciiDocs() throws Exception {
    // 输出Ascii格式
    Swagger2MarkupConfig config =
        new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC).build();

    Swagger2MarkupConverter.from(API_DOC_HOST).withConfig(config).build()
        .toFolder(Paths.get("src/docs/asciidoc/generated"));
  }

  @Test
  public void generateMarkdownDocs() throws Exception {
    // 输出Markdown格式
    Swagger2MarkupConfig config =
        new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.MARKDOWN).build();

    Swagger2MarkupConverter.from(API_DOC_HOST).withConfig(config).build()
        .toFolder(Paths.get("src/docs/markdown/generated"));
  }

  @Test
  public void generateConfluenceDocs() {
    // 输出Confluence使用的格式
    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
        .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP).build();

    Swagger2MarkupConverter.from(API_DOC_HOST).withConfig(config).build()
        .toFolder(Paths.get("src/docs/confluence/generated"));
  }

  @Test
  public void generateAsciiDocsToFile() {
    // 输出Ascii到单文件
    Swagger2MarkupConfig config =
        new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC).build();

    Swagger2MarkupConverter.from(API_DOC_HOST).withConfig(config).build()
        .toFile(Paths.get("src/docs/asciidoc/generated/all"));
  }

  @Test
  public void generateMarkdownDocsToFile() {
    // 输出Markdown到单文件
    Swagger2MarkupConfig config =
        new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.MARKDOWN).build();

    Swagger2MarkupConverter.from(API_DOC_HOST).withConfig(config).build()
        .toFile(Paths.get("src/docs/markdown/generated/all"));
  }
}
