<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>机构信息</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.excheck-3.5.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="../css/zTreeStyle/zTreeStyle.css"/>
<script>
	var setting = {
	//	isSimpleData : true,              //数据是否采用简单 Array 格式，默认false
		treeNodeKey : "id",               //在isSimpleData格式下，当前节点id属性
		treeNodeParentKey : "pId",        //在isSimpleData格式下，当前节点的父节点id属性
		rootPID :"0",
		showLine : true,                  //是否显示节点间的连线
	
		check: {
			enable: true,
			nocheckInherit: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	var zTree;
	//var treeNodes;
	

	$(function(){
		$.ajax({
			async : false,
			cache:false,
			type: 'POST',
			dataType : "json",
			url: "/njceb/doGetOrgTree.action",//请求的action路径
			error: function () {//请求失败处理函数
				alert('请求失败');
			},
			success:function(data){ //请求成功后处理函数。  
				//alert(data);
				
				treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes
			}
		});

		// zTree = $("#tree").zTree(setting, treeNodes);  
	});
	
	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, treeNodes);

	});

</script>
</head>
<body>
	<div>      
		<ul id="tree" class="ztree"></ul>       
	</div>   
</body>
</html>	