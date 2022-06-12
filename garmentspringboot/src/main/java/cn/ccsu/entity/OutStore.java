package cn.ccsu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/8 20:23
 * @Version 1.0
 */
public class OutStore extends BaseEntity implements Serializable {
    private Integer id;
    private String number;
    private String storage;
    private String agent;
    private String towhere;
    private Date outTime;
    private String remark;
    private Integer isDelete;
    private List<OutStoreDetail> detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getTowhere() {
        return towhere;
    }

    public void setTowhere(String towhere) {
        this.towhere = towhere;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OutStoreDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<OutStoreDetail> detail) {
        this.detail = detail;
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
        OutStore outStore = (OutStore) o;
        return Objects.equals(id, outStore.id) && Objects.equals(number, outStore.number) && Objects.equals(storage, outStore.storage) && Objects.equals(agent, outStore.agent) && Objects.equals(towhere, outStore.towhere) && Objects.equals(outTime, outStore.outTime) && Objects.equals(remark, outStore.remark) && Objects.equals(isDelete, outStore.isDelete) && Objects.equals(detail, outStore.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, number, storage, agent, towhere, outTime, remark, isDelete, detail);
    }

    @Override
    public String toString() {
        return "OutStore{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", storage='" + storage + '\'' +
                ", agent='" + agent + '\'' +
                ", towhere='" + towhere + '\'' +
                ", outTime=" + outTime +
                ", remark='" + remark + '\'' +
                ", isDelete=" + isDelete +
                ", detail=" + detail +
                '}';
    }
}
