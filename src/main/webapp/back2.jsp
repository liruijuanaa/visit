<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    title>Title</title>
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

            //加载所有数据
            $.get("${pageContext.request.contextPath}/dou/queryAll",function (result) {
                createIndex(result,"#div");
            },"JSON");


            $("#searchBtn").click(function () {
                let content = $("#searchText").val();
                $.get("${pageContext.request.contextPath}/elastic/findAllKeywords", {content: content,type:"",author:""}, function (result) {
                    createIndex(result,"#div");
                }, "JSON");
            });


            //a listener event
            $("#div").on("mouseover", "a", (e) => {
                console.log($(e.currentTarget).offset().top);
                console.log($(e.currentTarget).offset().left);
                let id = $(e.currentTarget).attr("poemid");
                let content = $("#content" + id).html();
                let authordes = $("#authordes" + id).html();
                let div = $("<div  />").attr("id", "contenttext").css({
                    "background": "#eee",
                    "border": "1px red solid",
                    "position": "absolute",
                    "width": "400",
                    "left": $(e.currentTarget).position().left + 30,
                    "top": $(e.currentTarget).position().top + 30,
                    "border-radius": "5px",
                    "display":"none",
                    "z-index":"9999",
                });
                let htmls = `<div class="panel panel-default">
                              <div class="panel-heading">
                                <h3 class="panel-title">正文:</h3>
                              </div>
                              <div class="panel-body">`+content+`</div>
                            </div>
                            <div class="panel panel-default">
                              <div class="panel-heading">
                                <h3 class="panel-title">作者简介:</h3>
                              </div>
                              <div class="panel-body">`+authordes+`</div>
                            </div>`;

                div.html(htmls);
                $(e.currentTarget).parent().parent().parent().parent().append(div);
                $("#contenttext").slideDown(3000);
            }).on("mouseout", "a", () => {
                $("#contenttext").remove();
            });


            //点击类别筛选
            $(".breadcrumb").on("click","li",(e)=>{
                $(e.currentTarget).siblings().removeClass("actives");
                $(e.currentTarget).addClass("actives");
                let type = $(".actives").first().text();
                let author = $(".actives").last().text();
                let content = $("#searchText").val();
                console.log(type);
                $.get("${pageContext.request.contextPath}/elastic/findAllKeywords", {content: content,type:type,author:author}, function (result) {
                    createIndex(result,"#div");
                }, "JSON");
            });






        });




        //封装创建主页函数
        function createIndex(result,list){
            $(list).empty();
            $.each(result.content, function (i, poem) {
                console.log(result)
                let div = $("<div />").css({
                    "border": "1px black solid",
                    "float": "left",
                    "width": "230",
                    "height": "260",
                    "margin": "10px 50px 15px 0px",
                    "border-radius": "10px",
                    "position":"relative"
                });
                let ul = $("<ul/>");
                let name = $("<li/>").html("<h4><a href='javascript:;' poemid=" + poem.id + ">" + poem.name + "</h4>");
                let author = $("<li/>").html("<h4>" + poem.author + "·" + poem.type + "</h4>");
                let content = $("<li/>").html(poem.content).css("display", "none").attr("id", "content" + poem.id);
                let authordes = $("<li/>").html(poem.authordes).css("display", "none").attr("id", "authordes" + poem.id);
                let imgpath = $("<img/>").attr("src", poem.imagepath).css("margin-top", "15px");
                ul.append(imgpath).append(name).append(author).append(content).append(authordes);
                div.append(ul);
                $(list).append(div);
            });
        }
    </script>
    <style>
        .breadcrumb > li + li:before {
            content: "|";
        }
        .actives{
            color:#f50a0a;
        }
    </style>
</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <h1 class="text-center">唐诗-宋词检索系统</h1>
        </div>
    </div>
    <br><br>

    <div class="row">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="searchText" class="col-md-2 control-label">检索唐诗宋词</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="searchText" placeholder="输入检索条件....">
                </div>
                <div class="col-sm-2">
                    <button type="button" id="searchBtn" class="btn btn-default">检索</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row">

        <div class="col-sm-8 col-sm-offset-2" style="margin-bottom: 10px;padding-left: 0px;">
            <ul class="breadcrumb" style="padding: 25px;">
                <li class="actives">所有</li>
                <li>唐诗</li>
                <li>宋词</li>
                <li>七言古诗</li>
                <li>五言古诗</li>
                <li>七言绝句</li>
                <li>五言绝句</li>
                <li>乐府</li>
                <li>宋词</li>
            </ul>
        </div>

        <div class="col-sm-8 col-sm-offset-2" style="padding-left: 0px;">
            <ul class="breadcrumb" style="padding: 25px;">
                <li class="actives">所有</li>
                <li>韦应物</li>
                <li>李清照</li>
                <li>吴文英</li>
                <li>杜甫</li>
                <li>李商隐</li>
                <li>杜牧</li>
                <li>晏几道</li>
                <li>柳永</li>
                <li>刘长卿</li>
                <li>王维</li>
                <li>李白</li>
                <li>孟浩然</li>
            </ul>


        </div>


    </div>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <div id="div">


            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <iframe src="http://10.15.0.4:5601/app/kibana#/visualize/edit/40a232f0-0ff4-11ea-9893-17bbabd0f21d?embed=true&_g=()" width="100%" height="800px;"></iframe>
        </div>
    </div>
</div>
</body>
</html>