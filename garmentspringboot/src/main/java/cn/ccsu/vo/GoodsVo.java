package cn.ccsu.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/8 22:49
 * @Version 1.0
 */
public class GoodsVo implements Serializable {
    private Integer goodsId;
    private String name;
    private Integer count;
    private String size;
    private String colour;
    private String number;
    private Integer outCount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public Integer getOutCount() {
        return outCount;
    }

    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsVo goodsVo = (GoodsVo) o;
        return Objects.equals(goodsId, goodsVo.goodsId) && Objects.equals(name, goodsVo.name) && Objects.equals(count, goodsVo.count) && Objects.equals(size, goodsVo.size) && Objects.equals(colour, goodsVo.colour) && Objects.equals(number, goodsVo.number) && Objects.equals(outCount, goodsVo.outCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, name, count, size, colour, number, outCount);
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                ", number='" + number + '\'' +
                ", outCount=" + outCount +
                '}';
    }
}
