package com.atguigu.test01dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * title:DOM4J的使用步骤：
 * author: Ray
 * date: 2022/8/19
 * description :
 */
public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        //创建SaxReader
        SAXReader reader = new SAXReader();
        //读取配置文件到内存中，获取第一个文档对象
        Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("persons.xml"));
        //获取根元素
        Element rootElement = document.getRootElement();
        //获取所有子元素
        List<Element> list = rootElement.elements();
        //遍历集合
        for (Element element : list) {
//            System.out.println(element);
            String id = element.attributeValue("id");//获取元素属性值
            System.out.println("id = " + id);
            List<Element> es = element.elements();
            for (Element e : es) {
                String name = e.getName();//获取标签名
                String text = e.getText();//获取元素文本内容
                System.out.println(name + " = " + text);
            }
        }
    }
}
