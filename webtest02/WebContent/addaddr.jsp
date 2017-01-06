<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.soft.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.6.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//省市级联-省找市
	$("#province").change(function(){
		debugger
		//获取checkbox的选中项
		var checkvalue = $("#province").val();
		//如果没有选则清空市区的选中项内容
		if(checkvalue == 0){
			$("#city").hide();
			$("#district").hide();
			$("#city").empty();
			$("#district").empty();
		}
		//如果选择则向后台发送查询请求
		if(checkvalue != 0){
			$.ajax({
				
				url:"AjaxChangeprovince",
				data:{"checkvalue":checkvalue},
				type:"post",
				success:function(text){
					//查询出错情况
					if(text == "notfound"){
						alert("没找到省、市、区");
						$("#city").hide();
						$("#district").hide();
						$("#city").empty();
						$("#district").empty();
						return;
					}
// 					//查询出错情况
// 					if(text == "notnumber"){
// 						alert("不是数字");
// 						return;
// 					}
					//查询出错情况
// 					if(text == "isempty"){
// 						alert("空的");
// 						return;
// 					}
					debugger
					//查询到了则解析json字符串
					var arr = eval(text);
					var temp = "";
					//初始化市标记
					var p = "<option value='0'>请选择市</option>";
					$.each(arr,function(i,dom){
						//遍历拼接节点
						temp = temp + "<option value='"+dom['id']+"'>"+dom['name']+"</option>";
					});
					
					$("#district").hide();
					$("#city").show();
					//清空省中原有的列表项内容
					$("#city").empty();
					//追加查询结果
					$("#city").append(p+temp);
				}
				
			});
		}
	});
	
	//市找区
	$("#city").change(function(){
		debugger
		//获取checkbox的选中项
		var checkvalue = $("#city").val();
		//如果没有选则清空市区的选中项内容
		if(checkvalue == 0){
			$("#city").hide();
			$("#district").hide();
			$("#city").empty();
			$("#district").empty();
		}
		//如果选择则向后台发送查询请求
		if(checkvalue != 0){
			$.ajax({
				
				url:"AjaxChangeprovince",
				data:{"checkvalue":checkvalue},
				type:"post",
				success:function(text){
					//查询出错情况
					if(text == "notfound"){
						alert("没找到省、市、区");
						$("#district").hide();
						$("#district").empty();
						return;
					}
// 					//查询出错情况
// 					if(text == "notnumber"){
// 						alert("不是数字");
// 						return;
// 					}
					//查询出错情况
// 					if(text == "isempty"){
// 						alert("空的");
// 						return;
// 					}
					debugger
					//查询到了则解析json字符串
					var arr = eval(text);
					var temp = "";
					//初始化市标记
					var p = "<option value='0'>请选择市</option>";
					$.each(arr,function(i,dom){
						//遍历拼接节点
						temp = temp + "<option value='"+dom['id']+"'>"+dom['name']+"</option>";
					});
					
					$("#district").show();
					$("#city").show();
					//清空省中原有的列表项内容
					$("#district").empty();
					//追加查询结果
					$("#district").append(p+temp);
				}
				
			});
		}
	});
});

function subabc(){
	debugger
	var province = $("select[name='province']").val();
	var city = $("select[name='city']").val();
	var district = $("select[name='district']").val();
	var provinceid = $("#provinceid").val(province);
	var cityid = $("#cityid").val(city);
	var districtid = $("#districtid").val(district);
	return true;
}

</script>
</head>
    <body>
      <div class="block">
        <form action="DoAddUserAddr" method="post" name="theForm" id="theForm" onsubmit="return subabc()">
        <input type="hidden" name="provinceid" id="provinceid" value=""/>
        <input type="hidden" name="cityid" id="cityid" value=""/>
        <input type="hidden" name="districtid" id="districtid" value=""/>
          <div class="flowBox">
            <h6>
              <span>
               	 收货人信息
              </span>
            </h6>
            <table  border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
              <tbody>
                <tr>
                  <td bgcolor="#ffffff" width="120px">
                   	 配送区域:
                  </td>
                  <td colspan="3" bgcolor="#ffffff">
<!--                     <select name="country" id="country" style="border:1px solid #ccc;"> -->
<!--                       <option value="0"> -->
<!--                         	请选择国家 -->
<!--                       </option> -->
<!--                       <option value="1"> -->
<!--                        	 	中国 -->
<!--                       </option> -->
<!--                     </select> -->
                    
<!--                     <select name="province" id="province"  > -->
<!--         				<option value="0">请选择省</option> -->
<!--                     </select> -->
					<select name="province" id="province" >
					<option value="0" >请选择国家</option>
					<c:forEach var="province" items="${list_province}">
					<option  value="${province.id}">${province.cityname}</option>
					</c:forEach>
					</select>
                    
                    <select name="city" id="city" style="border:1px solid #ccc;display:none">
                      <option value="0">
                        	请选择市
                      </option>
                    </select>
                    
                    <select name="district" id="district" style="display:none">
                      <option value="0">
                        	请选择区
                      </option>
                    </select>
                    (必填)
                  </td>
                </tr>
                <tr>
                  <td bgcolor="#ffffff">
                   	 收货人姓名:
                  </td>
                  <td bgcolor="#ffffff">
                    <input type="text" class="inputBg" name="receiver" id="receiver" value="">
                    (必填)<label id="receivermsg"></label>
                  </td>
                </tr>
                <tr>
                  <td bgcolor="#ffffff">
                    	详细地址:
                  </td>
                  <td bgcolor="#ffffff">
                    <input type="text" class="inputBg" name="receiveraddr" id="addr" value="">
                    (必填)<label id="addrmsg"></label>
                  </td>
                </tr>
                <tr>
                  <td bgcolor="#ffffff">
                   	联系方式:
                  </td>
                  <td bgcolor="#ffffff">
                    <input type="text" class="inputBg" name="receivertel" id="tel" value="" maxlength="11">
                    (必填)<label id="telmsg"></label>
                  </td>
                </tr>
                <tr>
                  <td bgcolor="#ffffff"><label style="color:red;font-size:9px;">${msg}</label></td>
                  <td colspan="4" align="center" bgcolor="#ffffff">
                  	<input type="hidden" name="ordernumber" id="ordernumber" value="${ordernumber}" />
                    <input type="submit" name="sub" class="bnt_blue_2" value="保存">
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </form>
      </div>
    </body>
</html>