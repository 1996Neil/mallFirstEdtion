package com.mall.mallfirstedtion.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
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
            addFieldJavaDoc(field, remarks);
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
}
