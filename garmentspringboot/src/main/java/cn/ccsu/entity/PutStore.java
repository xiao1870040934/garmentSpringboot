package cn.ccsu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 10:28
 * @Version 1.0
 */
public class PutStore extends BaseEntity implements Serializable {
    private Integer id;
    private String number;
    private String storage;
    private String agent;
    private String from;
    private String remark;
    private String addTime;
    private Integer isDelete;
    private List<PutStoreDetail> detail;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<PutStoreDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<PutStoreDetail> detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PutStore putStore = (PutStore) o;
        return Objects.equals(id, putStore.id) && Objects.equals(number, putStore.number) && Objects.equals(storage, putStore.storage) && Objects.equals(agent, putStore.agent) && Objects.equals(from, putStore.from) && Objects.equals(remark, putStore.remark) && Objects.equals(addTime, putStore.addTime) && Objects.equals(isDelete, putStore.isDelete) && Objects.equals(detail, putStore.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, number, storage, agent, from, remark, addTime, isDelete, detail);
    }

    @Override
    public String toString() {
        return "PutStore{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", storage='" + storage + '\'' +
                ", agent='" + agent + '\'' +
                ", from='" + from + '\'' +
                ", remark='" + remark + '\'' +
                ", addTime='" + addTime + '\'' +
                ", isDelete=" + isDelete +
                ", details=" + detail +
                '}';
    }
}
