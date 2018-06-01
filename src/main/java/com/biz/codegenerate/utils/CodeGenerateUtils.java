package com.biz.codegenerate.utils;

import com.biz.codegenerate.po.Test;
import freemarker.template.Template;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lingeng
 * @data 2018/5/31
 */
public class CodeGenerateUtils {

    private final String AUTHOR = "lingeng";
    private final String CURRENT_DATE = "2017/05/03";
    private final String tableName = "Test";
    private final String packageName = "com.biz.primus.ms.crm.utils";
    private final String tableAnnotation = "质量问题";

    private final String changeTableName = replaceUnderLineAndUpperCase(tableName);

    private final String diskPath = CodeGenerateUtils.class.getResource("").toString().replace("target/classes", "src/main/java").replace("file:", "");



    private final Class clazz = Test.class;


    public static void main(String[] args) throws Exception {

        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();


        codeGenerateUtils.generate();
    }

    public void  test(Object object){
        System.out.println(object.getClass().getResource(""));
        System.out.println(this.getClass().getResource(""));

        StackTraceElement stack[] = (new Throwable()).getStackTrace();  //获取线程运行栈信息
        for(int i=0;i<stack.length;i++) {
            StackTraceElement s = stack[i];
            System.out.format(" ClassName:%d\t%s\n", i, s.getClassName());
            System.out.format("MethodName:%d\t%s\n", i, s.getMethodName());
            System.out.format("  FileName:%d\t%s\n", i, s.getFileName());
            System.out.format("LineNumber:%d\t%s\n\n", i, s.getLineNumber());
        }

    }


    public void generate() {


        try {


            //生成Controller层文件
            generateControllerFile();


            //生成Repository文件
            generateRepositoryFile();

            //生成Dao文件
            generateDaoFile();

            //生成Repository文件
            generateRepositoryImplFile();


            //生成服务层接口文件
            generateServiceFile();


            //生成Ro文件
            generateRoFile();


            //生成Vo文件
            generateVoFile();

            //生成PO TO RO
            generatePoToRoFile();

            //生成VO TO PO
            generateVOToPOFile();

            //生成PO TO VO
            generatePoToVOFile();


            generateDedisDaoFile();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }



    private void generatePoToRoFile() throws Exception {

        final String suffix = changeTableName + "To" + changeTableName + "Ro.java";

        final String path = diskPath + suffix;
        final String templateName = "PoToRo.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateVOToPOFile() throws Exception {

        final String suffix = changeTableName + "VoTo" + changeTableName + ".java";
        final String path = diskPath + suffix;
        final String templateName = "VoToPo.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generatePoToVOFile() throws Exception {

        final String suffix = changeTableName + "To" + changeTableName + "Vo.java";
        final String path = diskPath + suffix;
        final String templateName = "PoToVo.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateRoFile() throws Exception {

        final String suffix = "Ro.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Ro.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass;

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {


            System.out.println(field.getType().getName() + "=======" + field.getName());

            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(field.getName());
            //获取字段类型
            columnClass.setColumnType(field.getType().getName());
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(field.getName()));
            //字段在数据库的注释
            columnClass.setColumnComment(field.getType().getName());
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }


    private void generateVoFile() throws Exception {

        final String suffix = "Vo.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Vo.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass;

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {


            System.out.println(field.getType().getName() + "=======" + field.getName());

            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(field.getName());
            //获取字段类型
            columnClass.setColumnType(field.getType().getName());
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(field.getName()));
            //字段在数据库的注释
            columnClass.setColumnComment(field.getType().getName());
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }


    private void generateControllerFile() throws Exception {
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }


    private void generateServiceFile() throws Exception {
        final String suffix = "Service.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Service.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateDedisDaoFile() throws Exception {
        final String suffix = "RedisDao.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "RedisDao.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }


    private void generateRepositoryFile() throws Exception {
        final String suffix = "Repository.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Repository.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }


    private void generateRepositoryImplFile() throws Exception {
        final String suffix = "RepositoryImpl.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "RepositoryImpl.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateDaoFile() throws Exception {
        final String suffix = "Dao.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Dao.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }


    private void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", tableName);
        dataMap.put("table_name", changeTableName);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        dataMap.put("package_name", packageName);
        dataMap.put("table_annotation", tableAnnotation);

        dataMap.put("po_path",clazz.getPackage().getName());
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

    public String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

}
