package com.example.rxjavademo.main.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 牲畜 这里需要将在线和离线的module合并在一起
 * 因为是全量bean和接口请求bean可能会多的有字段
 */
public class LivestockBean implements Serializable {
    @SerializedName("id")
    private long cattleId;//牲畜ID
    private boolean isCheck = false;//列表自定义属性，是否选中
    private String cattleName;//牲畜名称
    private long farmId;//农场ID
    private String farmName;//农场名称
    private String deviceId;//绑定设备ID
    private int deviceType;//绑定设备类型(1Lora耳标、2蓝牙耳标)
    private String deviceTypeDesc;//绑定设备类型描述
    private String earTagId;//耳标ID
    private long regionId = -1;//所属围栏ID
    private String regionName;//围栏名称
    private int isBindDevice;//是否绑定设备 绑定状态 0未绑定 1 绑定
    private String isBindDeviceName;//是否绑定设备名称
    private int isHorn = -1;//是否有角  默认为-1
    private String isHornName;//是否有角名称
    private String labelId;//标签ID
    private String labelName = "";//标签名称
    private String gnlis;//祖父NLIS
    private String mnlis;//母系NLIS
    private String nvdNo;//NVDNumber
    private String pnlis;//父系NLIS
    private int bodyColor;//牲畜体色
    private String bodyColorName;//牲畜体色名称
    private long birthDate;//出身日期
    private long entryDate;//入场时间
    private long enterTime;  //入栏时间
    private int sourceType;//来源类型
    private String sourceTypeStr;// 来源类型(中文)
    private String supplier;//供应商
    private String supplierPic;//供应商PIC
    private String type;//类型
    private String typeName = "";//类型名称
    private String varietyId;//品种
    private String varietyName = "";//品种名称
    private String remark;//备注
    private double lat;//纬度
    private double lng;//经度
    private String locations;//地标坐标集
    private long positionTime;//定位时间
    private long mid;  //母亲id
    private long pid;  //父亲id
    private String nlis;  //自身nlis
    private String mname;  //母亲名
    private String pname;  //父亲名
    private String visionNum;  //视觉编码
    private long buyTime;  //购买日期
    private long buyPrice;  //购买价格
    private int buyWeight; //购买体重
    private int storedStatus;//存栏状态  10存栏  20出售
    private int stageStatus;//生理阶段状态
    private String stageStatusDesc;//生理阶段状态描述
    private String storedStatusDesc;//存栏状态描述
    private List<Long> calfIdList=new ArrayList<>();//后代牲畜Id列表
    private int calvingCount;  //后代牲畜数量
    private String sourceRemark;  //来源备注
    private int operateDeviceType = 0;//绑定或者解绑操作 离线 默认为什么都没操作

    public long getCattleId() {
        return cattleId;
    }

    public void setCattleId(long cattleId) {
        this.cattleId = cattleId;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getCattleName() {
        return cattleName;
    }

    public void setCattleName(String cattleName) {
        this.cattleName = cattleName;
    }

    public long getFarmId() {
        return farmId;
    }

    public void setFarmId(long farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeDesc() {
        return deviceTypeDesc;
    }

    public void setDeviceTypeDesc(String deviceTypeDesc) {
        this.deviceTypeDesc = deviceTypeDesc;
    }

    public String getEarTagId() {
        return earTagId;
    }

    public void setEarTagId(String earTagId) {
        this.earTagId = earTagId;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getIsBindDevice() {
        return isBindDevice;
    }

    public void setIsBindDevice(int isBindDevice) {
        this.isBindDevice = isBindDevice;
    }

    public String getIsBindDeviceName() {
        return isBindDeviceName;
    }

    public void setIsBindDeviceName(String isBindDeviceName) {
        this.isBindDeviceName = isBindDeviceName;
    }

    public int getIsHorn() {
        return isHorn;
    }

    public void setIsHorn(int isHorn) {
        this.isHorn = isHorn;
    }

    public String getIsHornName() {
        return isHornName;
    }

    public void setIsHornName(String isHornName) {
        this.isHornName = isHornName;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getGnlis() {
        return gnlis;
    }

    public void setGnlis(String gnlis) {
        this.gnlis = gnlis;
    }

    public String getMnlis() {
        return mnlis;
    }

    public void setMnlis(String mnlis) {
        this.mnlis = mnlis;
    }

    public String getNvdNo() {
        return nvdNo;
    }

    public void setNvdNo(String nvdNo) {
        this.nvdNo = nvdNo;
    }

    public String getPnlis() {
        return pnlis;
    }

    public void setPnlis(String pnlis) {
        this.pnlis = pnlis;
    }

    public int getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(int bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getBodyColorName() {
        return bodyColorName;
    }

    public void setBodyColorName(String bodyColorName) {
        this.bodyColorName = bodyColorName;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(long entryDate) {
        this.entryDate = entryDate;
    }

    public long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(long enterTime) {
        this.enterTime = enterTime;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceTypeStr() {
        return sourceTypeStr;
    }

    public void setSourceTypeStr(String sourceTypeStr) {
        this.sourceTypeStr = sourceTypeStr;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierPic() {
        return supplierPic;
    }

    public void setSupplierPic(String supplierPic) {
        this.supplierPic = supplierPic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(String varietyId) {
        this.varietyId = varietyId;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public long getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(long positionTime) {
        this.positionTime = positionTime;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getNlis() {
        return nlis;
    }

    public void setNlis(String nlis) {
        this.nlis = nlis;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getVisionNum() {
        return visionNum;
    }

    public void setVisionNum(String visionNum) {
        this.visionNum = visionNum;
    }

    public long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(long buyTime) {
        this.buyTime = buyTime;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getBuyWeight() {
        return buyWeight;
    }

    public void setBuyWeight(int buyWeight) {
        this.buyWeight = buyWeight;
    }

    public int getStoredStatus() {
        return storedStatus;
    }

    public void setStoredStatus(int storedStatus) {
        this.storedStatus = storedStatus;
    }

    public int getStageStatus() {
        return stageStatus;
    }

    public void setStageStatus(int stageStatus) {
        this.stageStatus = stageStatus;
    }

    public String getStageStatusDesc() {
        return stageStatusDesc;
    }

    public void setStageStatusDesc(String stageStatusDesc) {
        this.stageStatusDesc = stageStatusDesc;
    }

    public String getStoredStatusDesc() {
        return storedStatusDesc;
    }

    public void setStoredStatusDesc(String storedStatusDesc) {
        this.storedStatusDesc = storedStatusDesc;
    }

    public List<Long> getCalfIdList() {
        return calfIdList;
    }

    public void setCalfIdList(List<Long> calfIdList) {
        this.calfIdList = calfIdList;
    }

    public int getCalvingCount() {
        return calvingCount;
    }

    public void setCalvingCount(int calvingCount) {
        this.calvingCount = calvingCount;
    }

    public String getSourceRemark() {
        return sourceRemark;
    }

    public void setSourceRemark(String sourceRemark) {
        this.sourceRemark = sourceRemark;
    }

    public int getOperateDeviceType() {
        return operateDeviceType;
    }

    public void setOperateDeviceType(int operateDeviceType) {
        this.operateDeviceType = operateDeviceType;
    }

    @Override
    public String toString() {
        return "LivestockBean{" +
                "cattleId=" + cattleId +
                ", isCheck=" + isCheck +
                ", cattleName='" + cattleName + '\'' +
                ", farmId=" + farmId +
                ", farmName='" + farmName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                ", deviceTypeDesc='" + deviceTypeDesc + '\'' +
                ", earTagId='" + earTagId + '\'' +
                ", regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                ", isBindDevice=" + isBindDevice +
                ", isBindDeviceName='" + isBindDeviceName + '\'' +
                ", isHorn=" + isHorn +
                ", isHornName='" + isHornName + '\'' +
                ", labelId='" + labelId + '\'' +
                ", labelName='" + labelName + '\'' +
                ", gnlis='" + gnlis + '\'' +
                ", mnlis='" + mnlis + '\'' +
                ", nvdNo='" + nvdNo + '\'' +
                ", pnlis='" + pnlis + '\'' +
                ", bodyColor=" + bodyColor +
                ", bodyColorName='" + bodyColorName + '\'' +
                ", birthDate=" + birthDate +
                ", entryDate=" + entryDate +
                ", enterTime=" + enterTime +
                ", sourceType=" + sourceType +
                ", sourceTypeStr='" + sourceTypeStr + '\'' +
                ", supplier='" + supplier + '\'' +
                ", supplierPic='" + supplierPic + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", varietyId='" + varietyId + '\'' +
                ", varietyName='" + varietyName + '\'' +
                ", remark='" + remark + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", locations='" + locations + '\'' +
                ", positionTime=" + positionTime +
                ", mid=" + mid +
                ", pid=" + pid +
                ", nlis='" + nlis + '\'' +
                ", mname='" + mname + '\'' +
                ", pname='" + pname + '\'' +
                ", visionNum='" + visionNum + '\'' +
                ", buyTime=" + buyTime +
                ", buyPrice=" + buyPrice +
                ", buyWeight=" + buyWeight +
                ", storedStatus=" + storedStatus +
                ", stageStatus=" + stageStatus +
                ", stageStatusDesc='" + stageStatusDesc + '\'' +
                ", storedStatusDesc='" + storedStatusDesc + '\'' +
                ", calfIdList=" + calfIdList +
                ", calvingCount=" + calvingCount +
                ", sourceRemark='" + sourceRemark + '\'' +
                ", operateDeviceType=" + operateDeviceType +
                '}';
    }
}
