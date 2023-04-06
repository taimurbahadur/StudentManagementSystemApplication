//package com.intellicode.studentmanagementsystemapplication.Entity;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.io.Serializable;
//import java.util.Date;
//
//@MappedSuperclass
//public abstract class BaseEntity implements Serializable {
//
//
//    private static final long serialVersionUID = 671453595895902185L;
//
//    @CreationTimestamp
//    @Column(name = "CREATED_DATE")
//    protected Date createdDate;
//
//    @UpdateTimestamp
//    @Column(name = "UPDATED_DATE")
//    protected Date updatedDate;
//
//    @Column(name = "IS_DELETED", columnDefinition = "tinyint(0) DEFAULT 0")
//    protected Boolean isDeleted;
//
//    @Column(name = "UPDATED_BY", columnDefinition = "int(11) DEFAULT 0")
//    protected Integer updatedBy;
//
//    @Column(name = "CREATED_BY", columnDefinition = "int(11) DEFAULT 0")
//    protected Integer createdBy;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "DEX_ROW_TS")
//    protected Date rowDateIndex;
//
//    @Column(name = "DEX_ROW_ID")
//    protected Integer rowIndexId;
//
//    @Column(name = "ORIGINATED_FROM")
//    protected String originatedFrom;
//
//    @Column(name = "FLEX_1")
//    protected String flex1;
//
//    @Column(name = "FLEX_2")
//    protected String flex2;
//
//    @Column(name = "FLEX_3")
//    protected String flex3;
//
//    @Column(name = "FLEX_4")
//    protected String flex4;
//
//    @Column(name = "FLEX_5")
//    protected String flex5;
//
//    @PrePersist
//    protected void prePersist() {
//        if(createdBy == null) {
//            createdBy = 0;
//        }
//        updatedBy = createdBy;
//
//    }
//
//    @PreUpdate protected void preUpdate() {
//
//    }
//
//
//
//    public BaseEntity() {
//        this.isDeleted = false;
//        this.updatedDate = UtilDateAndTime.getCurrentDate();
//        this.updatedDate = UtilDateAndTime.getCurrentDate();
//    }
//
//    public BaseEntity( Date createdDate, Date modifiedDate) {
//        this.isDeleted = false;
//        this.createdDate = createdDate;
//        this.updatedDate = modifiedDate;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public Boolean getIsDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(Boolean isDeleted) {
//        this.isDeleted = isDeleted;
//    }
//
//    public Integer getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(Integer updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getRowDateIndex() {
//        return rowDateIndex;
//    }
//
//    public void setRowDateIndex(Date updatedRow) {
//        this.rowDateIndex = updatedRow;
//    }
//
//    public Integer getRowIndexId() {
//        return rowIndexId;
//    }
//
//    public void setRowIndexId(Integer rowId) {
//        this.rowIndexId = rowId;
//    }
//
//    public String getFlex1() {
//        return flex1;
//    }
//
//    public void setFlex1(String flex1) {
//        this.flex1 = flex1;
//    }
//
//    public String getFlex2() {
//        return flex2;
//    }
//
//    public void setFlex2(String flex2) {
//        this.flex2 = flex2;
//    }
//
//    public String getFlex3() {
//        return flex3;
//    }
//
//    public void setFlex3(String flex3) {
//        this.flex3 = flex3;
//    }
//
//    public String getFlex4() {
//        return flex4;
//    }
//
//    public void setFlex4(String flex4) {
//        this.flex4 = flex4;
//    }
//
//    public String getFlex5() {
//        return flex5;
//    }
//
//    public void setFlex5(String flex5) {
//        this.flex5 = flex5;
//    }
//
//    public String getOriginatedFrom() {
//        return originatedFrom;
//    }
//
//    public void setOriginatedFrom(String originatedFrom) {
//        this.originatedFrom = originatedFrom;
//    }
//
// (non-Javadoc)
//     * @see java.lang.Object#toString()
//
//
//    @Override
//    public String toString() {
//        return "BaseEntity [createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", deleted=" + isDeleted
//                + "rowDateIndex=" + rowDateIndex + "rowIndexId=" + rowIndexId + "flex1=" + flex1 + "flex2" + flex2
//                + "flex3" + flex3 + "flex4" + flex4 + "flex5" + flex5 + "]";
//    }
//
// (non-Javadoc)
//     * @see java.lang.Object#hashCode()
//
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
//        result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
//        result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
//        return result;
//    }
//
// (non-Javadoc)
//     * @see java.lang.Object#equals(java.lang.Object)
//
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        BaseEntity other = (BaseEntity) obj;
//        if (createdDate == null) {
//            if (other.createdDate != null)
//                return false;
//        } else if (!createdDate.equals(other.createdDate))
//            return false;
//        if (isDeleted == null) {
//            if (other.isDeleted != null)
//                return false;
//        } else if (!isDeleted.equals(other.isDeleted))
//            return false;
//        if (updatedDate == null) {
//            if (other.updatedDate != null)
//                return false;
//        } else if (!updatedDate.equals(other.updatedDate))
//            return false;
//        return true;
//    }
//}
