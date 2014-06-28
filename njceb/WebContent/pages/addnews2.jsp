<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>发布新闻</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckeditor/config.js"></script>
<script>
	function CKupdate() {
		for (instance in CKEDITOR.instances)
			CKEDITOR.instances[instance].updateElement();
	}

	function saveNews() {
		CKupdate();
		$.ajax({
			cache : true,
			type : "POST",
			url : "../addNews.action",
			data : $('#newsForm').serialize(),
			async : false,
			error : function(request) {
				alert("保存失败!" + request);
			},
			success : function(data) {
				alert("保存成功!");
			}
		});
	}
	function uploadImage(editorInstance) {
		var xx = '<div id=\"word_image_container_temp\" style=\"display:none;\"></div>';
		var yy1 = '<div id=\"wordImageAppletWrapper\" style=\"height: 22px;background-color: #f2f1f1;border-top: 1px solid gray;position:fixed; bottom:0;left:0; width:100%; overflow: hidden;z-index:1000;\" > ';
		var yy3 = '</div>';
		
		document.write(xx);
		document.write(yy1);
		document.write(yy3);
		

		var ed = editorInstance;
		var txt = ed.getData();
		var txt0 = txt;
		jQuery('#word_image_container_temp').html(txt);
		//alert(jQuery('#container_temp').html());
		var i = 0;
		$('#word_image_container_temp img').each(
				function() {
					var src = $(this).attr('src');
					if (src.indexOf("file:///") != -1) {
						//图片在本地的地址
						var srct = src.replace('file:///', '');
						
						$.ajax({
							cache : true,
							type : "POST",
							url : "../uploadimg.action",
							data : srct,
							async : false,
							error : function(request) {
								alert("上传失败!" + request);
							},
							success : function(data) {
								alert("上传成功!");
							}
						});
						
						
						//alert(srct);
						//图片存放在服务器上的地址，由后台返回
						var serverPath = '../image/';
						if (serverPath != 'error') {
							//alert(serverPath);
							txt = txt.replace(src, serverPath);
						}
					}
		});

	}
</script>
</head>
<body>
	<h1 class="samples">新闻发布</h1>

	<form id="newsForm" method="post">
		<p>
			新闻标题: <input type="text" id="newsTitle" name="newsTitle" />
		</p>

		<p>
			新闻内容：
			<textarea name="content" style="visibility: hidden; display: none;"></textarea>
			<script type="text/javascript">
				var editor = CKEDITOR.replace('content');
				CKEDITOR.instances["content"].on("change", function() {
					//上传图片到服务器
					uploadImage(CKEDITOR.instances["content"]);
				});
			</script>
		</p>

		<input type="button" value="保存" onclick="saveNews()"></input>
	</form>

</body>
</html>
