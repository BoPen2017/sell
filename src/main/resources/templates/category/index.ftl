<html>
<#include "../common/head.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">
<#--主要内容content-->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form action="/seller/category/save" method="post" role="form">
                        <div class="form-group">
                            <label>名字</label>
                            <input type="text" name="categoryName" class="form-control" value="${(productCategory.categoryName)!''}">
                        </div>
                        <div class="form-group">
                            <label>Type</label>
                            <input type="number" name="categoryType" class="form-control" value="${(productCategory.categoryType)!''}">
                        </div>
                        <input type="hidden" name="categoryId" value="${(productCategory.categoryId)!''}">
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>