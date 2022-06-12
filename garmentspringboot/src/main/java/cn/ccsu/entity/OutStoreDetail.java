package cn.ccsu.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/8 20:24
 * @Version 1.0
 */
public class OutStoreDetail extends BaseEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer outCount;
    private String size;
    private String colour;
    private Integer goodsId;

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

    public Integer getOutCount() {
        return outCount;
    }

    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutStoreDetail that = (OutStoreDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(outCount, that.outCount) && Objects.equals(size, that.size) && Objects.equals(colour, that.colour) && Objects.equals(goodsId, that.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, outCount, size, colour, goodsId);
    }

    @Override
    public String toString() {
        return "OutStoreDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", outCount=" + outCount +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }
}
