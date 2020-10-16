<%--
  Created by IntelliJ IDEA.
  User: 11504
  Date: 2020/6/3
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <!--bootstrap核心css-->
    <link rel="stylesheet" href="boot/css/bootstrap.min.css">
    <!--jqfrid核心css-->
    <link rel="stylesheet" href="jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <!--jquery核心js-->
    <script src="boot/js/jquery-3.3.1.min.js"></script>
    <!--bootstrap核心js-->
    <script src="boot/js/bootstrap.min.js"></script>
    <!--jqgrid核心js-->
    <script src="jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <!---->
    <script src="jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script>
        $(function () {
            $("#poemlist").jqGrid({
                url:"${pageContext.request.contextPath}/poem/fenye",
                editurl:"${pageContext.request.contextPath}/poem/edit",
                datatype:"json",
                styleUI:"Bootstrap",
                pager:"poemPager",
                rowNum:10,
                height:380,
                caption:"唐诗宋词列表",
                viewrecords: true,
                autowidth:true,
                colNames:["Id", "诗词名", "作者", "类型", "来源","内容","作者简介"],
                colModel:[
                    {name:"id" , editable:true},
                    {name:"name" , editable:true},
                    {name:"author" , editable:true},
                    {name:"type" , editable:true},
                    {name:"origin" , editable:true},
                    {name:"content", editable:true},
                    {name:"authordes", editable:true}
                ]
            }).jqGrid("navGrid","#poemPager",{search:false})
            $("#aa").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/dou/insert"
                })
            })
            $("#bb").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/dou/delete"
                })
            })
        })
    </script>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">唐诗宋词后台管理系统V1.0</a>
                <button type="button" class="btn btn-danger" id="bb">清空ES所有文档</button>
                <button type="button" class="btn btn-info" id="aa">基于基础数据重建ES索引库</button>
            </div>
        </div>
    </nav>

        <div class="container-fluid">
            <table id="poemlist">

            </table>
            <div id="poemPager"></div>
        </div>
    </div>

</body>
</html>
