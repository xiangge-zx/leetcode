package com.ti.rongyao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Song
 * @Date 2021/2/26 16:55
 * @Version 1.0
 * @Description
 */
public class TestUtil {
        /**
         * 利用好其预编译功能，可以有效加快正则匹配速度
         */
        public static Pattern dynamic = Pattern.compile(".*\\$\\{([a-z]+)\\}.*");
        public static Pattern dynamicLimitCount = Pattern.compile("\\$\\{([a-z]+)\\}");

        /**
        * 判断内容中是否包含动态参数(${key}形式的)
        *
        * @param content 要判断的内容
        * @return
        */
       public static boolean isContainsDynamicParameter(String content) {
         return dynamic.matcher(content).matches();
        }

        public static List<String> getKeyListByContent(String content) {
            Set<String> paramSet = new LinkedHashSet<>();
            Matcher m = dynamicLimitCount.matcher(content);
            while (m.find()) {
            paramSet.add(m.group(1));
        }
        return new ArrayList<>(paramSet);
        }

        public static void main(String[] args) {
        //测试代码
        String content = "尊敬的${name}客户您好，请于${time}前到达";
        System.out.println(isContainsDynamicParameter(content));
        List<String> keyListByContent = getKeyListByContent(content);
        System.out.println("内容中的动态参数为:");
        keyListByContent.forEach(System.out::println);
        }
}