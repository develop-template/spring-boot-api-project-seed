package cn.javabus.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

public class CollectionUtil {


    /**
     * convert str to list, list contains data type is string
     * for example:
     *     1,2,3,4 --> list [1,2,3,4]
     *
     * @param targetStr  target str
     * @param separator  separator
     * @return
     *       if str is empty return list, but list size is zero;
     *       else return conver list
     */
    public static <T> Set<T> strToSet(String targetStr, String separator, Class<? extends Number> clazz) {
        Set<T> result = new HashSet<>();
        if (StringUtils.isEmpty(targetStr)) {
            return result;
        }
        try {
            Method method =  clazz.getMethod("valueOf", String.class);
            String[] values = targetStr.split(separator);
            for (String value : values) {
                if (!StringUtils.isEmpty(value)) {
                    value = value.trim();
                    result.add((T)method.invoke(null, value));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * convert list to str
     * for example:
     *      list [1,2,3,4] --> str 1,2,3,4
     *
     * @param targetList   target list
     * @param separator    separator
     * @return
     *      if targetList is empty or size is zero return null
     *      else return convert str
     */
    public static String listToStr(List<String> targetList, String separator) {
        String result = null;
        if (targetList == null || targetList.size() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder("");
        for (String str : targetList) {
            sb.append(str).append(separator);
        }
        result = sb.toString();
        if (result.length() > 0 && result.endsWith(separator)) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 把一个list中不相等的元素拆分为多个子list, list 必须是有序的
     * @param list
     * @param comparator
     * @param <E>
     * @return
     */
    public static <E> List<List<E>> splitList(List<E> list, Comparator<E> comparator) {
        List<List<E>> split = new ArrayList<>();

        List<E> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (temp.isEmpty()) {
                temp.add(list.get(i));
                continue;
            }
            E preElement = temp.get(temp.size() - 1);
            int res = comparator.compare(preElement, list.get(i));
            if (res == 0) {
                temp.add(list.get(i));
                continue;
            } else {
                split.add(new ArrayList<>(temp));
                temp.clear();
                temp.add(list.get(i));
            }
        }
        split.add(temp);
        return split;
    }
    /**
     *  对象去重
     *
     * @param objects 对象集合
     * @param <T> 类型实例
     *
     * @return
     */
    public static <T> List<T> distinctObject(List<T> objects, final String fieldName) {
        if (objects != null) {
            Set<T> set = new TreeSet<T>(new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    //字符串,则按照asicc码升序排列
                    try {
                        PropertyDescriptor pd1 = new PropertyDescriptor(fieldName, o1.getClass());
                        PropertyDescriptor pd2 = new PropertyDescriptor(fieldName, o2.getClass());
                        Method pd1Method = pd1.getReadMethod();
                        pd1Method.setAccessible(true);
                        Method pd2Method = pd2.getReadMethod();
                        pd2Method.setAccessible(true);
                        return String.valueOf(pd1Method.invoke(o1, null)).compareTo(String.valueOf(pd2Method.invoke(o2, null)));
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                }
            });
            set.addAll(objects);
            return new ArrayList<>(set);
        } else {
            return null;
        }
    }

}
