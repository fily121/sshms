<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .input_area{
        margin-bottom:20px;
        margin-right: 10px;
        float: left;
        width:450px
    }
</style>
<script>
    $(function () {
        easyuiExt.initCombobox();
        var view = ${view};
        if (view === true) {
            $("#submitDiv").remove();
        }
    });
</script>

<form action="data/system/addModifyUser.do" method="post" id="userManageForm">
    <div class="input_area" style="margin-top:20px;">
        <input name="userId" value="${user.userId}" type="hidden"/>
        <input class="easyui-textbox" name="userName" id="userName" value="${user.userName}" style="width:95%" data-options="label:'用户名：',required:true" validType="maxLength[20]"/>
    </div>
    <div class="input_area" style="margin-top:20px;">
        <input class="easyui-combobox" name="roleId" id="roleId" value="${user.roleId}" style="width:95%" data-options="label:'所属角色：',required:true,valueField:'roleId',textField:'roleName',url:'data/system/getAllRole.do'"/>
    </div>
    <div class="input_area">
        <input class="easyui-passwordbox" name="userPwd" id="passwordNew1" style="width:95%" data-options="label:'密码：'" validType="maxLength[20]"/>
    </div>
    <div class="input_area">
        <input class="easyui-passwordbox" name="password3" id="passwordNew2" style="width:95%" data-options="label:'确认密码：'"  validType="equals['#passwordNew1']"/>
    </div>
    <div class="input_area">
        <input class="easyui-combobox" name="orgId"  value="${user.orgId}" id="orgId" style="width:95%" data-options="label:'所属施工队：',valueField:'id',textField:'sgdmc',url:'data/baseManage/getAllSgd.do',required:true"/>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="name"  value="${user.name}"  id="name" style="width:95%" data-options="label:'姓名：'" validType="maxLength[20]"/>
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="gender"  style="width:95%" data-options="label:'性别：'" >
            <option value="0" <c:if test="${user.gender eq 0}">selected</c:if>>男</option>
            <option value="1" <c:if test="${user.gender eq 1}">selected</c:if>>女</option>
        </select>
    </div>
    <div class="input_area">
        <input class="easyui-datebox" name="birthday"  value="${user.birthday}"  id="birthday" style="width:95%" data-options="label:'生日：'" />
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="idNo"  value="${user.idNo}"  id="idNo" style="width:95%" data-options="label:'身份证号：'" validType="maxLength[20]"/>
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="education"  style="width:95%" data-options="label:'文化程度：'" >
            <c:forEach items="${education}" var="ed">
                <option value="${ed.code}" <c:if test="${user.education eq ed.code}">selected</c:if>>${ed.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="phone"  value="${user.phone}"  id="phone" style="width:95%" data-options="label:'联系电话：'" validType="maxLength[11]"/>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="email"  value="${user.email}"  id="email" style="width:95%" data-options="label:'e-mail：'" validType="email"/>
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="major"  style="width:95%" data-options="label:'施工专业：'" >
            <c:forEach items="${major}" var="ma">
                <option value="${ma.code}" <c:if test="${user.major eq ma.code}">selected</c:if>>${ma.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="gangwei"  style="width:95%" data-options="label:'职务岗位：'" >
            <c:forEach items="${gangwei}" var="gw">
                <option value="${gw.code}" <c:if test="${user.gangwei eq gw.code}">selected</c:if>>${gw.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="yongglx"  style="width:95%" data-options="label:'用工类型：'" >
            <c:forEach items="${yongglx}" var="yg">
                <option value="${yg.code}" <c:if test="${user.yongglx eq yg.code}">selected</c:if>>${yg.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input_area">
        <input class="easyui-numberbox" name="gongzsj"  value="${user.gongzsj}"  id="gongzsj" style="width:95%" data-options="label:'现岗工作时间：'"/> 年
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="gongzds"  value="${user.gongzds}"  id="gongzds" style="width:95%" data-options="label:'现工作地市：'" validType="maxLength[11]"/>
    </div>
    <div class="input_area">
        <input class="easyui-datebox" name="bendsgzkssj"  value="${user.bendsgzkssj}"  id="bendsgzkssj" style="width:95%" data-options="label:'本地市工作开始时间：'" />
    </div>
    <div class="input_area">
        <select class="easyui-combobox" name="zhengsmc"  style="width:95%" data-options="label:'资质证书名称：'" >
            <c:forEach items="${certificate}" var="ce">
                <option value="${ce.code}" <c:if test="${user.zhengsmc eq ce.code}">selected</c:if>>${ce.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="zizNo"  value="${user.zizNo}"  id="zizNo" style="width:95%" data-options="label:'资质证书编号：'" validType="maxLength[11]"/>
    </div>
    <div class="input_area">
        <input class="easyui-datebox" name="zizTime"  value="${user.zizTime}"  id="zizTime" style="width:95%" data-options="label:'颁发时间：'" />
    </div>
    <div class="input_area">
        <input class="easyui-datebox" name="zizEndtime"  value="${user.zizEndtime}"  id="zizEndtime" style="width:95%" data-options="label:'当前有效期结束时间：'" />
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="zizOrg"  value="${user.zizOrg}"  id="zizOrg" style="width:95%" data-options="label:'颁发机构：'" />
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="baox"  value="${user.baox}"  id="baox" style="width:95%" data-options="label:'购买保险情况：'" />
    </div>
    <div class="input_area">
        <input class="easyui-textbox" name="other"  value="${user.other}"  id="other" style="width:95%" data-options="label:'其它说明：'" />
    </div>
    <div id="submitDiv" style="text-align:center;padding:5px 0;float:left;margin:0 auto;width:750px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userManage.submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userManage.clearForm()" style="width:80px">清空</a>
    </div>
</form>
