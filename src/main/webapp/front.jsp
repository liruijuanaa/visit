<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
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
            $.ajax({
                url: "${pageContext.request.contextPath}/poem/queryAll",
                dataType: "json",
                success:function (data) {
                    $.each(data,function (index,poem) {
                        console.log(poem.href);
                        var $div=$("<ul style=\"border: 1px #0f0f0f solid;float:left;border-radius: 10px;margin:10px;height: 150px;width: 150px\" ></ul>");
                        var $image=$("<img src=\""+poem.imagepath+"\" height=\"60px\" width=\"40px\"><hr>");
                        var $name=$("<li/>").text(poem.name);
                        var $author=$("<li>"+poem.author+"-"+poem.type+"</li>");
                       $div.append($image).append($name).append($author);
                        $("#show").append($div);
                    })


                }
            })
            $("#jian").click(function () {
                $.ajax({
                    url: "",
                    type: "GET",
                    data:$("#form-search").serialize(),
                    success:function (data) {

                    }
                })
            })
        })
    </script>
    </head>
    <body>
        <center><h3>唐诗-宋词检索系统</h3></center>
        <div class="input-group">
            <form id="form-search">
                <span class="input-group-addon">检索唐诗宋词</span>
                <input type="text" placeholder="输入检索条件..." class="form-control">
                <button type="button" id="jian">检索</button>
            </form>
        </div>
        <div id="show" style="float: left">

        </div>

    </body>
</html>