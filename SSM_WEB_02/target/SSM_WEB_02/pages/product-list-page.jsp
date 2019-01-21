<%--
  Created by IntelliJ IDEA.
  User: QinLiNa
  Date: 2019/1/11
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--数据列表-->
<form id="productListForm" action="${pageContext.request.contextPath}/product/delByIds" method="post">
    <table id="dataList"
           class="table table-bordered table-striped table-hover dataTable">
        <thead>
        <tr>
            <th class="" style="padding-right: 0px;">
                <input
                        id="selall" type="checkbox" class="icheckbox_square-blue">
            </th>
            <th class="sorting_asc">编号</th>
            <th class="sorting">商品号</th>
            <th class="sorting">商品名称</th>
            <th class="sorting">出发城市</th>
            <th class="sorting">出发时间</th>
            <th class="sorting">商品价格</th>
            <th class="sorting">商品描述</th>
            <th class="sorting">是否上架</th>

            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagebean.list}" var="product" varStatus="vs">
            <tr>
                <td><input name="ids" type="checkbox" value="${product.id}"></td>
                <td>${product.id}</td>

                <td>${product.productNum}</td>
                <th>${product.productName}</th>
                <th>${product.cityName}</th>
                <th>${product.departureTime}</th>
                <th>${product.productPrice}</th>
                <th>${product.productDesc}</th>
                <th>${product.productStatus==1 ? "上架" : "下架"}</th>

                <td class="text-center">
                    <button type="button" class="btn bg-olive btn-xs"
                            onclick='location.href="${pageContext.request.contextPath}/product/toUpdateProductPage?id=${product.id}"'>
                        修改
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</form>
<!--数据列表/-->
<!-- .box-footer-->
<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
            总共${pagebean.pageNum} 页，共${pagebean.totalCount} 条数据。
            每页 <select id="numPerPageSelect" class="form-control" onchange="gotoPage(1)">
            <option value="2">2</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="javascript:gotoPage('1')" aria-label="Previous">首页</a></li>
            <li><a href="javascript:gotoPage('${pagebean.pageNum - 1}')">上一页</a></li>
            <c:forEach begin="1" end="${pagebean.totalPage}" step="1" var="page">
                <li class="${page==pagebean.pageNum ? 'active':''}"><a href="javascript:gotoPage('${page}')">${page}</a>
                </li>
            </c:forEach>
            <li><a href="javascript:gotoPage('${pagebean.pageNum + 1}')">下一页</a></li>
            <li><a href="javascript:gotoPage('${pagebean.totalPage}')" aria-label="Next">尾页</a></li>
        </ul>
    </div>

</div>
<!-- /.box-footer-->
<script type="text/javascript">
    // 页面加载完成后
    $(function () {
        // 指定每页显示多少条的默认值
        $("#numPerPageSelect option[value='${pagebean.numPerPage}']").prop("selected", true);
    });

    // 跳转到指定页面
    function gotoPage(pageNum) {
        if (pageNum >= 1 && pageNum <=${pagebean.totalPage}) {
            // 获取每页选择显示条数
            var numPerPage = $("#numPerPageSelect").val();
            location.href = "${pageContext.request.contextPath}/product/queryProductListByPage?pageNum=" + pageNum + "&numPerPage=" + numPerPage;
        } else {
            alert("没有对应的页码!")
        }
    }
</script>
</body>
</html>
