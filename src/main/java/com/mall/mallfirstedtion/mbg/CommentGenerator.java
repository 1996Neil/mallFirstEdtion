package com.mall.mallfirstedtion.mbg;

import com.sun.xml.internal.bind.v2.model.core.ReferencePropertyInfo;
import io.swagger.annotations.ApiModelProperty;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @author wangzhe
 * @ClassName CommentGenerator
 * @create 2021-07-16 22:11
 * @description 生成注释
 * @Version 1.0
 */
public class CommentGenerator extends DefaultCommentGenerator {

    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX="Example";
    private static final String API_PROPERTY_FULL_CLASS_NAME="io.swagger.annotations.ApiModelProperty";

    /**
     *
     * @Description: 设置用户配置的参数
     * @Date 22:52 2021/7/16
     * @Param [properties]
     **/
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     *
     * @Description: 给字段添加注释
     * @Date 22:54 2021/7/16
     * @Param [field, introspectedTable, introspectedColumn]
     **/
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            //addFieldJavaDoc(field, remarks);
            //数据库中特殊字符需要转义
            if (remarks.contains("\"")) {
                remarks=remarks.replace("\"","'");
            }
            //给model的字段添加swagger注解
            field.addJavaDocLine("@ApiModelProperty(value= \""+remarks+"\")");
        }

    }

    /**
     *
     * @Description: 给model字段添加注释, 给上面的方法做引用
     * @Date 23:03 2021/7/16
     * @Param [field, remarks]
     **/
    private void addFieldJavaDoc(Field field, String remarks) {
        //文档注释开始
        field.addJavaDocLine("/**");
        //获取数据库字段的备注信息  bug处("line separator")已修复
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");

    }

    /**
     * 重写注解方式
     * @Date 16:37 2021/7/23
     * @param compilationUnit
     *@return  void
     **/
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        //只在model中添加swagger注解类的导入PmsBrandExample.java
        if (!compilationUnit.isJavaInterface()&&!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_PROPERTY_FULL_CLASS_NAME));
        }
    }
}
