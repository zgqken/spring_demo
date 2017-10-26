package com.ken.java.collection;

import java.util.HashSet;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/6 0006
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<User> hashSet = new HashSet<>();
        User user = new User();
        user.setId("1");
        user.setName("23");
        hashSet.add(user);
        System.out.println(hashSet.size());
//        user.setName("22");
        hashSet.remove(user);
        System.out.println(hashSet.size());
    }
}

class User{

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        User user = (User) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, user.id)
                .append(name, user.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .toHashCode();
    }
}
