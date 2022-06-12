package cn.ccsu.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/4 18:33
 * @Version 1.0
 */
public class Goods extends BaseEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer count;
    private String size;
    private String colour;
    private String number;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) && Objects.equals(name, goods.name) && Objects.equals(count, goods.count) && Objects.equals(size, goods.size) && Objects.equals(colour, goods.colour) && Objects.equals(number, goods.number) && Objects.equals(isDelete, goods.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, count, size, colour, number, isDelete);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", size=" + size +
                ", colour='" + colour + '\'' +
                ", number='" + number + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
