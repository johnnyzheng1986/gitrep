<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>用户角色分配</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script>
		var roles;
		$(function(){
			$.ajax({
				async : false,
				cache:false,
				type: 'POST',
				dataType : "json",
				url: "/njceb/getRoleForUser.action",//请求的action路径
				error: function () {//请求失败处理函数
					alert('请求失败');
				},
				success:function(data){ //请求成功后处理函数。  
					roles = data;   
				}
			});
		});
		function roleFormatter(value){
			for(var i=0; i<roles.length; i++){
				if (roles[i].roleId == value) return roles[i].roleName;
			}
			return value;
		}
		$(function(){
			var lastIndex;
			$('#tt').datagrid({
				toolbar:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$("#tt").datagrid('endEdit', lastIndex);
		                //如果调用acceptChanges(),使用getChanges()则获取不到编辑和新增的数据。
		                var row = $("#tt").datagrid('getSelected');
		                var userId = row.userId;
		                var roleId = row.roleId;
		                
		                $.ajax({
		                    type: "POST",
		                    url: "../updateUserRole.action",
		                 	data: row,
		                    success: function (msg) {
		                    },
		                    error: function (errormessage) {

		                    }
		                });
		                
					}
				},'-',{
					text:'取消',
					iconCls:'icon-undo',
					handler:function(){
						$('#tt').datagrid('rejectChanges');
					}
				}],
				onBeforeLoad:function(){
					$(this).datagrid('rejectChanges');
				},
				onClickRow:function(rowIndex){
					if (lastIndex != rowIndex){
						$('#tt').datagrid('endEdit', lastIndex);
						$('#tt').datagrid('beginEdit', rowIndex);
					}
					lastIndex = rowIndex;
				}
			});
		});
	</script>
</head>
<body>
	<table id="tt" style="width:700px;height:auto"
			data-options="iconCls:'icon-edit',singleSelect:true,idField:'userId',url:'../getUserList.action'"
			title="用户角色信息">
		<thead>
			<tr>
				<th data-options="field:'userId',width:80">用户ID</th>
				<th data-options="field:'userName',width:80">用户名</th>
				<th data-options="field:'roleId',width:100,formatter:roleFormatter,
						editor:{
							type:'combobox',
							options:{
								valueField:'roleId',
								textField:'roleName',
								data:roles,
								required:true
							}
						}">用户角色</th>
			</tr>
		</thead>
	</table>
	
	
</body>
</html>