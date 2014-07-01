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
	                {title:'����ID',field:'newsId',width:80,sortable:true}
				]],
				columns:[[
			        {title:'������Ϣ',colspan:3},
					{field:'opt',title:'����',width:100,align:'center', rowspan:2,
						formatter:function(value,row,index){
							var t = '<a href="#" onclick="setTop(this)">�ö�</a>';
							var e = '<a href="#" onclick="editNews(this)">�޸�</a> ';
							var d = '<a href="#" onclick="delNews(this)">ɾ��</a>';
							return t+' '+' '+e+' '+d;
							
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
							title : '��ʾ',
							msg : '�ö��ɹ�'
						});
						$('#newsTable').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : 'ʧ����ʾ',
							msg : result.errorMsg
						});
					}
				});
				
			} else {
				$.messager.alert('δѡ��¼��ʾ','��ѡ��һ����¼!','error');
			}
		}
		
		
		
		
		function delNews() {
			var row = $('#newsTable').datagrid('getSelected');
			if (row) {
				$.messager.confirm('ȷ��', '��ȷ��Ҫɾ����������?', function(r) {
					if (r) {
						$.post('../delNews.action', {
							newsId : row.newsId
						}, function(result) {
							if (result=='OK') {
								$.messager.show({ // show error message
									title : 'ɾ�����ųɹ���ʾ',
									msg : 'ɾ���ɹ�'
								});
							} else {
								$.messager.show({ // show error message
									title : 'ɾ������ʧ����ʾ',
									msg : result.errorMsg
								});
							}
						});
					}
				});
			} else {
				$.messager.alert('δѡ��¼��ʾ','��ѡ��һ����Ҫɾ���ļ�¼!','error');
			}
		}
		
		
		
	</script>
</head>
<body>
	<table id="newsTable"></table>
	
</body>
</html>