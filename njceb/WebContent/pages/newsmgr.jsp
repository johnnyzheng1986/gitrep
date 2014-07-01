<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻管理</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script>
		$(function(){
			$('#newsTable').datagrid({
				title:'新闻信息',
				iconCls:'icon-save',
				width:800,
				height:600,
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
	                {title:'新闻ID',field:'newsId',width:80,sortable:true}
				]],
				columns:[[
			        {title:'新闻信息',colspan:3},
					{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
						formatter:function(value,row,index){
							var t = '<a href="#" onclick="setTop(this)">置顶</a>';
							var e = '<a href="#" onclick="editNews(this)">修改</a> ';
							var d = '<a href="#" onclick="delNews(this)">删除</a>';
							return t+' '+' '+e+' '+d;
							
						}
					}
				],[
					{field:'newsTitle',title:'新闻标题',width:120},
					{field:'dateTime',title:'发布时间',width:220,rowspan:2,sortable:true,
						sorter:function(a,b){
							return (a>b?1:-1);
						}
					},
					{field:'changeDateTime',title:'修改时间',width:150,rowspan:2,sortable:true,
						sorter:function(a,b){
							return (a>b?1:-1);
						}
					},
					{field:'isPost',title:'发布状态',width:150,rowspan:2,
						formatter:function(value){
							if(value=="1"){
								return '<span style="color:green" >已发布</span>';
							}else{
								return '<span style="color:red" >未发布</span>';
							}
							
						}
					},
					{field:'author',title:'投稿人',width:150,rowspan:2
						
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
		
		function editNews() {
		
		}
		
		
		function setTop() {
			var row = $('#newsTable').datagrid('getSelected');
			if (row) {
				
				$.post('../setTop.action', {
					newsId : row.newsId
				}, function(result) {
					if (result=='OK') {
						$.messager.show({ 
							title : '提示',
							msg : '置顶成功'
						});
						$('#newsTable').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : '失败提示',
							msg : result.errorMsg
						});
					}
				});
				
			} else {
				$.messager.alert('未选记录提示','请选择一条记录!','error');
			}
		}
		
		
		
		
		function delNews() {
			var row = $('#newsTable').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '您确定要删除此新闻吗?', function(r) {
					if (r) {
						$.post('../delNews.action', {
							newsId : row.newsId
						}, function(result) {
							if (result=='OK') {
								$.messager.show({ // show error message
									title : '删除新闻成功提示',
									msg : '删除成功'
								});
							} else {
								$.messager.show({ // show error message
									title : '删除新闻失败提示',
									msg : result.errorMsg
								});
							}
						});
					}
				});
			} else {
				$.messager.alert('未选记录提示','请选择一条您要删除的记录!','error');
			}
		}
		
		
		
	</script>
</head>
<body>
	<table id="newsTable"></table>
	
</body>
</html>