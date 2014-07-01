<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script>
$(document).ready(function () {
    $('.easyui-accordion li a').click(function () {
        var tabTitle = $(this).text();
        var url = $(this).attr("href");
        addTab(tabTitle, url);
        $('.easyui-accordion li div').removeClass("selected");
        $(this).parent().addClass("selected");
    }).hover(function () {
        $(this).parent().addClass("hover");
    }, function () {
        $(this).parent().removeClass("hover");
    });

    function addTab(subtitle, url) {
        if (!$('#tabs').tabs('exists', subtitle)) {
            $('#tabs').tabs('add', {
                title: subtitle,
                content: createFrame(url),
                closable: true,
                width: $('#mainPanle').width() - 10,
                height: $('#mainPanle').height() - 26
            });
        } else {
            $('#tabs').tabs('select', subtitle);
       }
        tabClose();
    }


    function createFrame(url) {
        var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
        return s;
    }


    function tabClose() {
        /*˫���ر�TABѡ�*/
        $(".tabs-inner").dblclick(function () {
            var subtitle = $(this).children("span").text();
            $('#tabs').tabs('close', subtitle);
        })

        $(".tabs-inner").bind('contextmenu', function (e) {
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
            var subtitle = $(this).children("span").text();
            $('#mm').data("currtab", subtitle);
            return false;
        });
    }

    //���Ҽ��˵��¼�
	function tabCloseEven() {
        //�رյ�ǰ
 	$('#mm-tabclose').click(function () {
            var currtab_title = $('#mm').data("currtab");
            $('#tabs').tabs('close', currtab_title);
        })
        //ȫ���ر�
 	$('#mm-tabcloseall').click(function () {
            $('.tabs-inner span').each(function (i, n) {
                var t = $(n).text();
               $('#tabs').tabs('close', t);
            });
        });

        //�رճ���ǰ֮���TAB
        $('#mm-tabcloseother').click(function () {
            var currtab_title = $('#mm').data("currtab");
            $('.tabs-inner span').each(function (i, n) {
                var t = $(n).text();
                if (t != currtab_title)
                    $('#tabs').tabs('close', t);
            });
        });
        //�رյ�ǰ�Ҳ��TAB
        $('#mm-tabcloseright').click(function () {
            var nextall = $('.tabs-selected').nextAll();
            if (nextall.length == 0) {
               //msgShow('ϵͳ��ʾ','���û����~~','error');
                alert('���û����~~');
                return false;
            }
            nextall.each(function (i, n) {
                var t = $('a:eq(0) span', $(n)).text();
                $('#tabs').tabs('close', t);
            });
            return false;
       });
        //�رյ�ǰ����TAB
        $('#mm-tabcloseleft').click(function () {
            var prevall = $('.tabs-selected').prevAll();
            if (prevall.length == 0) {
                alert('��ͷ�ˣ�ǰ��û����~~');
                return false;
            }
            prevall.each(function (i, n) {
                var t = $('a:eq(0) span', $(n)).text();
                $('#tabs').tabs('close', t);
            });
            return false;
        });

        //�˳�
        $("#mm-exit").click(function () {
            $('#mm').menu('hide');

        })
    }
});
</script>

<style>
.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}
</style>
</head>

<body class="easyui-layout">
	<div region="north" border="true" split="true"
		style="overflow: hidden; height: 80px;">
		<div class="top-bg"></div>
	</div>
	<div region="south" border="true" split="true"
		style="overflow: hidden; height: 40px;">
		<div class="footer">�й���������Ͼ����� ��Ȩ���� �0�8 2014</div>
	</div>
	<div region="west" split="true" title="�����˵�" style="width: 200px;">
		<div id="aa" class="easyui-accordion"
			style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">

			<div title="Ȩ�޹���" iconcls="icon-save"
				style="overflow: auto; padding: 10px;">
				<ul class="easyui-tree">
					<li><span>��Ϣ����</span>
						<ul>
							<li>
								<span>
									<a target="mainFrame" href="./rolemgr.jsp">��ɫ����</a> 
								</span>
							</li>
							<li>
								<span>
									<a target="mainFrame" href="./orginfo.jsp">������Ϣ</a> 
								</span>
							</li>
							<li>
								<span><a target="mainFrame" href="./userrolemgr.jsp">�û���ɫ����</a> </span>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div title="֪ͨ����" iconcls="icon-reload" selected="true"
				style="padding: 10px;">content2</div>
				
			<div title="���Ź���" iconcls="icon-reload" selected="true"
				style="padding: 10px;">content2</div>
			<ul class="easyui-tree">
					<li><span>����</span>
						<ul>
							<li>
								<span>
									<a target="mainFrame" href="./addnews2.jsp">��������</a> 
								</span>
							</li>
							<li>
								<span>
									<a target="mainFrame" href="./newsmgr.jsp">��������</a> 
								</span>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div id="mainFrame" region="center" style="overflow: hidden;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="��ӭʹ��" style="padding: 20px; overflow: hidden;" id="home">
				<h1>Welcome!</h1>
			</div>
		</div>

	</div>


</body>
</html>