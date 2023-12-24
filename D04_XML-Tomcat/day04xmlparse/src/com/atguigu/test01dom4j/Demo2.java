package com.atguigu.test01dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * title:Xpath使用步骤
 * author: Ray
 * date: 2022/8/19
 * description :
 */
public class Demo2 {
    public static void main(String[] args) throws DocumentException {
        //创建SaxReader对象
        SAXReader reader = new SAXReader();
        //读取配置文件
        Document doucment = reader.read(Demo2.class.getClassLoader().getResourceAsStream("persons.xml"));
        //获取指定元素单个元素
//        Element element = (Element) doucment.selectSingleNode("//person");
//        String id = element.attributeValue("id");
//        System.out.println("id = " + id);
        //获取多个元素
        List<Element> list = doucment.selectNodes("//name");
//        List<Element> list = doucment.selectNodes("/persons/person/name");
        for (Element e : list) {
            System.out.println(e.getText());
        }


    }
}
