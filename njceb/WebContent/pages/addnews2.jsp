<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��������</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckeditor/config.js"></script>
<link rel="stylesheet" href="../uploadify/uploadify.css" type="text/css"></link>
<script type="text/javascript" src="../uploadify/jquery.uploadify-3.1.min.js"></script>
<script>
	var filePath="";
	var fileName ="";
	function CKupdate() {
		for (instance in CKEDITOR.instances)
			CKEDITOR.instances[instance].updateElement();
	}
	
	$(function() {
		//var fileMap = new HashMap();
		$("#multiple_file_upload").uploadify({
			'uploader' : '../fileUpload.action',//************ action **************
			'height' : 27,//��ʾ��ť�ĸ߶ȣ�Ĭ��30PX����Ҫ��Ϊ50PX���������ã�'height' : 50��
			'width' : 50,//��ʾ��ť�Ŀ��
			'buttonText' : '� ��',//��ť����ʾ�����֣�Ĭ�ϡ�SELECT FILES��
			'buttonCursor' : 'hand',//�ϴ���ťHoverʱ�������״��Ĭ��ֵ�ǡ�hand��
			'auto' : false, //�Ƿ��Զ���ʼ   
			'multi' : false, //�Ƿ�֧�ֶ��ļ��ϴ���Ĭ��Ϊtrue
			'method' : 'post',//Ĭ���ǡ�post��,Ҳ��������Ϊ��get��
			'swf' : '../uploadify/uploadify.swf',//��������ʾ�ļ�
			'cancelImg' : '../uploadify/uploadify-cancel.png',//ȡ����ť��ͼƬ
			'fileTypeDesc' : 'jpg��png��gif��bmp',//�����ϴ����ļ����͵��������ڵ������ļ�ѡ��������ʾ
			'fileTypeExts' : '*.jpg;*.png;*.gif;*.bmp;*.doc;*.txt',//ָ���ļ���ʽ
			'fileSizeLimit' : '50MB',//�ϴ��ļ���С���ƣ�Ĭ�ϵ�λ��KB������Ҫ���ƴ�С��100KB���ڣ������ø�����Ϊ��'100KB'
			'fileObjName' : 'myFile',//�ļ��������ơ������ڷ������˻�ȡ�ļ���
			'formData' : {
				'userName' : '',
				'content' : ''
			},
			'progressData' : 'all', // 'percentage''speed''all'//��������ʾ�ļ��ϴ����ȵķ�ʽ��all-�ϴ��ٶ�+�ٷֱȣ�percentage-�ٷֱȣ�speed-�ϴ��ٶ�
			'preventCaching' : true,//������Ϊtrue��һ���������������swf�ļ�URL�ĺ��棬��ֹ��������档Ĭ��ֵΪtrue
			'timeoutuploadLimit' : 5,//��ͬʱ�ϴ����ļ���Ŀ
			'removeCompleted' : true,//Ĭ����True�����ϴ���ɺ�Ϳ������ϴ��ļ��������ˡ�
			'removeTimeout' : 5,//�ϴ���ɺ���ɾ�������еĽ�������Ĭ��Ϊ3����3�롣
			'requeueErrors' : true,//������ΪTrue����ô���ϴ���������Ϊ�������ϴ�ʧ�ܵ��ļ��������¼�����С�
			'successTimeout' : 30,//��ʾ�ļ��ϴ���ɺ�ȴ���������Ӧ��ʱ�䡣��������ʱ�䣬��ô����Ϊ�ϴ��ɹ���Ĭ����30����ʾ30�롣
			'uploadLimit' : 999,//����ϴ��ļ�������Ĭ��999
			'onUploadStart' : function(file) {
				//$("#file_upload").uploadify("settings", "formData", {'userName':name,'qq':qq});  
				//$("#file_upload").uploadify("settings", "buttonText", "aaa");
				//alert(file.name + " is ready to go!")
				$("#stopUpload").removeAttr("hidden");
			},
			'onUploadSuccess' : function(file, data, response) {
				//alert(file.name + " upload success !");
				filePath=data;
				fileName = file.name;
				$("#stopUpload").attr("hidden",true);
			}

		});
	
	});
	
	function saveNews() {
		CKupdate();
		
		/* Get input values from form */
	    var values = jQuery("#newsForm").serializeArray();
		
	    /* Because serializeArray() ignores unset checkboxes and radio buttons: */
	    values = values.concat(
	            jQuery('#newsForm input[type=checkbox]:not(:checked)').map(
	                    function() {
	                        return {"name": this.name, "value": 'off'}
	                    }).get()
	    );
	    values = values.concat({"name":"fileName","value":fileName},{"name":"filePath","value":filePath});

		$.ajax({
			cache : true,
			type : "POST",
			url : "../addNews.action",
			data : values,
			async : false,
			error : function(request) {
				alert("����ʧ��!" + request);
			},
			success : function(data) {
				alert("����ɹ�!");
			}
		});
	}
		

</script>
</head>
<body>
	<h1 class="samples">���ŷ���</h1>

	<form id="newsForm" method="post">
		<div>
			���ű���: <input type="text" id="newsTitle" name="newsTitle" />
			Ͷ����: <input type="text" id="newsAuthor" name="newsAuthor" />
		</div>
		<div>
			�Ƿ���������: <input type="checkbox" id="isPost" name="isPost" />&nbsp;&nbsp;&nbsp;
			�Ƿ��ö�: <input type="checkbox" id="isTop" name="isTop" />
		</div>
			
		<div>
			�������ݣ�
			<textarea name="content" style="visibility: hidden; display: none;"></textarea>
			<script type="text/javascript">
				var editor = CKEDITOR.replace('content');
			</script>
		</div>

		
	 	<div align="left">
	 	  	��Ӹ�����
	        <input type="file" name="uploadify" id="multiple_file_upload" />  
	        <hr>  
	        <a href="javascript:$('#multiple_file_upload').uploadify('upload','*')">��ʼ�ϴ�</a>  
	        <a href="javascript:$('#multiple_file_upload').uploadify('cancel','*')">ȡ���ϴ�</a>  
	        <a href="javascript:$('#multiple_file_upload').uploadify('stop','*')" hidden=true id="stopUpload">ֹͣ�ϴ�</a>  
	    	<input type="hidden"></input>
	    </div>  		
		<div>
			<input type="button" value="����" onclick="saveNews()"></input>
		</div>
		
		
	</form>

</body>
</html>
