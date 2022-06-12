package cn.ccsu.entity;


import java.io.Serializable;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 10:29
 * @Version 1.0
 */
public class PutStoreDetail extends BaseEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer count;
    private String colour;
    private String size;
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PutStoreDetail that = (PutStoreDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(count, that.count) && Objects.equals(colour, that.colour) && Objects.equals(size, that.size) && Objects.equals(goodsId, that.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, count, colour, size, goodsId);
    }

    @Override
    public String toString() {
        return "PutStoreDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", colour='" + colour + '\'' +
                ", size='" + size + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }
}
