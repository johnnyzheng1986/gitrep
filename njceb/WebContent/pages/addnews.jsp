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
		<p>
			���ű���: <input type="text" id="newsTitle" name="newsTitle" />
		</p>

		<p>
			�������ݣ�
			<textarea name="content" style="visibility: hidden; display: none;"></textarea>
			<script type="text/javascript">
				 CKEDITOR.replace('content');
			</script>
		</p>

		<input type="button" value="����" onclick="saveNews()"></input>
	</form>

</body>
</html>
