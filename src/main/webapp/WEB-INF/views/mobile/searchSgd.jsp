<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>检索施工队</title>
        <script type="text/javascript">
            function searchOrder() {
                $("#findOrder").submit();
            }
        </script>
    </head>
    <body>
        <div data-role="page">
            <form id="findOrder" method="get" action="findSgdxx.do">
                <div data-role="header" data-position="fixed">
                    <!--<a href="#" data-role="button">Back</a>-->
                    <h1>检索施工队</h1>
                </div><!-- /header -->
                <div data-role="content"> 
                    <input name="keywords" id="keywords" value="" placeholder="输入关键字检索" type="search">
                </div><!-- /content -->
                <div data-role="footer" data-position="fixed">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="javascript: searchOrder();" data-icon="search">查询</a></li>
                        </ul>
                    </div>
                </div>

            </form>
        </div><!-- /page -->
    </body>
</html>
