<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>���Ź���</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script>
		$(function(){
			$('#newsTable').datagrid({
				title:'������Ϣ',
				iconCls:'icon-save',
				width:700,
				height:350,
				nowrap: true,
				autoRowHeight: false,
				striped: true,
				collapsible:true,
				url:'../getNewsListForConsole.action',
				sortName: 'changeDateTime',
				sortOrder: 'desc',
				remoteSort: false,
				idField:'newsId',
				frozenColumns:[[
	                {field:'ck',checkbox:true},
	                {title:'����ID',field:'newsId',width:80,sortable:true}
				]],
				columns:[[
			        {title:'������Ϣ',colspan:3},
					{field:'opt',title:'����',width:100,align:'center', rowspan:2,
						formatter:function(value,rec){
							return '<span style="color:red">�޸�  �ö�  ɾ��</span>';
						}
					}
				],[
					{field:'newsTitle',title:'���ű���',width:120},
					{field:'dateTime',title:'����ʱ��',width:220,rowspan:2,sortable:true,
						sorter:function(a,b){
							return (a>b?1:-1);
						}
					},
					{field:'changeDateTime',title:'�޸�ʱ��',width:150,rowspan:2,sortable:true,
						sorter:function(a,b){
							return (a>b?1:-1);
						}
					},
					{field:'isPost',title:'����״̬',width:150,rowspan:2,
						formatter:function(value){
							if(value=="1"){
								return '<span style="color:green" >�ѷ���</span>';
							}else{
								return '<span style="color:red" >δ����</span>';
							}
							
						}
					},
					{field:'author',title:'Ͷ����',width:150,rowspan:2
						
					}
				]],
				pagination:true,
				rownumbers:true,
				
			});
			var p = $('#newsTable').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
	</script>
</head>
<body>
	<table id="newsTable"></table>
	
</body>
</html>