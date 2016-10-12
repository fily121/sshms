<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>施工队详情</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-position="fixed">
                <!--<a href="#" data-role="button">Back</a>-->
                <h1>施工队详情</h1>
            </div><!-- /header -->
            <div data-role="content"> 
                <div data-role="fieldcontain">
                    <label for="orderName">施工队名称：</label>
                    ${sgdxx.sgdmc}
                </div>
                <div data-role="fieldcontain">
                    <label for="orderNumber">施工队详情：</label>
                    ${sgdxx.detail}
                </div>
                <div data-role="fieldcontain">
                    <label for="lxNumber">施工队地址：</label>
                    ${sgdxx.address}
                </div>
                <div data-role="fieldcontain">
                    <label for="sgdid" class="select">车型：</label>
                    ${sgdxx.ctype}
                </div>
                <div data-role="fieldcontain">
                    <label for="remark">队长：</label>
                    ${duizhang}
                </div>
                <div data-role="fieldcontain">
                    <label for="startTime">车牌号：</label>
                    ${sgdxx.cph}
                </div>
                <div data-role="fieldcontain">
                    <label for="table-column-toggle">人员列表：</label>
                    <table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="1">序号</th>
                                <th data-priority="1">姓名</th>
                                <th data-priority="2">性别</th>
                                <th data-priority="2">出生年月</th>
                                <th data-priority="4">身份证号码</th>
                                <th data-priority="3">文化程度</th>
                                <th data-priority="3">联系电话</th>
                                <th data-priority="3">微信号</th>
                                <th data-priority="5">联系邮箱</th>
                                <th data-priority="1">施工专业</th>
                                <th data-priority="1">职务岗位</th>
                                <th data-priority="1">用工类型</th>
                                <th data-priority="5">现岗工作时间</th>
                                <th data-priority="5">现工作地市</th>
                                <th data-priority="5">本地市工作开始时间</th>
                                <th data-priority="1">资质证书名称</th>
                                <th data-priority="5">资质证书编号</th>
                                <th data-priority="5">颁发时间</th>
                                <th data-priority="5">颁发机构</th>
                                <th data-priority="5">当前有效期结束时间</th>
                                <th data-priority="5">购买保险情况</th>
                                <th data-priority="5">其它说明</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user" varStatus="index">
                                <tr>
                                    <th>${index.index +1}</th>
                                    <td>${user.name}</td>
                                    <td>${user.gender}</td>
                                    <td>${user.birthday}</td>
                                    <td>${user.idNo}</td>
                                    <td>${user.education}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.wechatno}</td>
                                    <td>${user.email}</td>
                                    <td>${user.major}</td>
                                    <td>${user.gangwei}</td>
                                    <td>${user.yongglx}</td>
                                    <td>${user.gongzsj}</td>
                                    <td>${user.gongzds}</td>
                                    <td>${user.bendsgzkssjString}</td>
                                    <td>${user.zhengsmc}</td>
                                    <td>${user.zizNo}</td>
                                    <td>${user.zizTimeString}</td>
                                    <td>${user.zizOrg}</td>
                                    <td>${user.zizEndtimeString}</td>
                                    <td>${user.baox}</td>
                                    <td>${user.other}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div data-role="fieldcontain">
                    <table data-role="table" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <tbody>
                            <tr>
                                <th>总人数：</th>
                                <td>${users.size()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div data-role="fieldcontain">
                    <label for="table2">统计详情：</label>
                    <table data-role="table" id="table2" data-mode="columntoggle" class="ui-responsive table-stroke">
                        <tbody>
                            <tr>
                                <th>专业名称</th>
                                <th>人数</th>
                                <th>资质证书名称</th>
                                <th>人数</th>
                                <th>用工类型</th>
                                <th>人数</th>
                                <th>岗位职务</th>
                                <th>人数</th>
                            </tr>
                            <tr>
                                <td>基站设备</td>
                                <td>
                                    ${major['1']}
                                </td>
                                <td>移动岗位资质证</td>
                                <td>${zhengsmc['1']}</td>
                                <td>正式合同制</td>
                                <td>${yongglx['1']}</td>
                                <td>安全员</td>
                                <td>${gangwei['1']}</td>
                            </tr>
                            <tr>
                                <td>基站土建</td>
                                <td>${major['2']}</td>
                                <td>安全员证</td>
                                <td>${zhengsmc['2']}</td>
                                <td>劳务派遣</td>
                                <td>${yongglx['2']}</td>
                                <td>施工队长</td>
                                <td>${gangwei['2']}</td>
                            </tr>
                            <tr>
                                <td>铁塔安装</td>
                                <td>${major['3']}</td>
                                <td>登高证</td>
                                <td>${zhengsmc['3']}</td>
                                <td>试用</td>
                                <td>${yongglx['3']}</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>传输设备</td>
                                <td>${major['4']}</td>
                                <td>电工证</td>
                                <td>${zhengsmc['4']}</td>
                                <td>临时</td>
                                <td>${yongglx['4']}</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>传输管线</td>
                                <td>${major['5']}</td>
                                <td>焊工证</td>
                                <td>${zhengsmc['5']}</td>
                                <td>外协</td>
                                <td>${yongglx['5']}</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>宽带接入</td>
                                <td>${major['6']}</td>
                                <td>制冷证</td>
                                <td>${zhengsmc['6']}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>综合覆盖</td>
                                <td>${major['7']}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>电源配套</td>
                                <td>${major['8']}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div><!-- /content -->
            <div data-role="footer" data-position="fixed">
                <div data-role="navbar">
                    <ul>
                        <c:if test="${view eq false}">
                        <%--<shiro:hasPermission name="sgd:edit">--%>
                        <li><a href="addModifySgdxx.do?id=${sgdxx.id}" data-icon="edit">修改</a></li>
                            <%--</shiro:hasPermission>--%>
                        </c:if>
                        <c:if test="${empty modify or !modify}">
                        <li><a href="javascript: history.go(-1);" data-icon="arrow-l">返回</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div><!-- /page -->
</body>
</html>
