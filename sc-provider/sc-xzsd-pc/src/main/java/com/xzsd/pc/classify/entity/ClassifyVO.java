package com.xzsd.pc.classify.entity;

import java.util.List;

/**
 * 商品分类实体类（传出参数）
 * @author WangZeBin
 * @date 2020-04-05
 */
public class ClassifyVO {
    /**
     * 分类编号
     */
    private String classId;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 备注
     */
    private String remark;
    /**
     * 分类集合
     */
    private List<ClassifyVO> classTwoList;
    /**
     * 版本号
     */
    private String version;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ClassifyVO> getClassTwoList() {
        return classTwoList;
    }

    public void setClassTwoList(List<ClassifyVO> classTwoList) {
        this.classTwoList = classTwoList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
