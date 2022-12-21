<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>상세정보 보기</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/css/detail.css" rel="stylesheet">
    </head>

    <body>
     <%@include file="./fix/navigation.jsp" %>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()%>/shopping/image/${item.item_no}.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">item_no: ${item.item_no}</div>
                        <h1 class="display-5 fw-bolder">${item.title}</h1>
                        <div class="fs-5 mb-5">
                            <span>${item.item_price} 원</span>
                        </div>
                        <p class="lead">${item.content}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="number" id="item_ord" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>&nbsp
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" id="orderServlet" onclick="location.href='<%=request.getContextPath()%>/GetOrderSheet.do?item_no=${item.item_no}&id=${id}'" >
                                <i class="bi bi-emoji-smile me-1"></i> 
                                	Buy
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
   
     <%@include file="./fix/footer.jsp" %>
     <script type="text/javascript" src="<%=request.getContextPath()%>/purchase/script/orderSheet.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</body>
</html>